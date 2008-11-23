package edu.sjsu.edo08f.services.utils;

import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Instructor;
import edu.sjsu.edo08f.domain.Student;
import edu.sjsu.edo08f.exceptions.*;
import org.springframework.util.StringUtils;
import org.apache.log4j.Logger;

import java.util.List;

/**
 * Created by: Alex Yarmula
 * Date: Nov 11, 2008
 */
public class CourseVerifier extends CommonVerifier {

    private Logger logger = Logger.getLogger(CourseVerifier.class);

    private InstructorVerifier instructorVerifier;

    public void setInstructorVerifier(InstructorVerifier instructorVerifier) {
        this.instructorVerifier = instructorVerifier;
    }

    private StudentVerifier studentVerifier;

    public void setStudentVerifier(StudentVerifier studentVerifier) {
        this.studentVerifier = studentVerifier;
    }

    public void verifyCourseOnCreate (Course course, Instructor instructor) {
        verifyCourse(course);
        verifyCourseDuplicates(course);
        instructorVerifier.verifyInstructorExists(instructor);
        if (isInstructorOccupiedForThisCourse(instructor, course)) {
            throw new ScheduleConflictException("This course conflicts with current schedule of this instructor");
        }
        
        if (isCoursesScheduleOverlapWithSomebodysOfficeHours (course)) {
            throw new RoomBookedException ("This course can't be taken at given time/location, " +
                    "because the place is occupied by one of instructors' office hours");
        }
    }

    public void verifyCourseOnUpdate (Course course) {
        verifyCourse(course);
        verifyCourseExists(course);
        verifyCourseDuplicates (course);

        Instructor instructor = instructorDao.getInstructorByCourse(course.getId());

        if (isInstructorOccupiedForThisCourse(instructor, course)) {
            throw new ScheduleConflictException("This course conflicts with current schedule of this instructor");
        }

        if (isCoursesScheduleOverlapWithSomebodysOfficeHours (course)) {
            throw new RoomBookedException ("This course can't be taken at given time/location, " +
                    "because the place is occupied by one of instructors' office hours");
        }
        
    }

    public void verifyCourseOnDelete (Course course) {

        verifyCourseExists(course);
        List<Student> students = studentDao.getStudentsByCourse(course.getId());
        if (students.size() > 0) {
            throw new HasDependenciesException
                    (String.format("The course has %d students enrolled and can't be deleted", students.size()));
        }
    }

    public void verifyEnrollStudent (Course course, Student student) {
        verifyCourseExists(course);
        studentVerifier.verifyStudentExists (student);
        List<Course> coursesForStudent = courseDao.getCoursesByStudentId (student.getId());

        int unitsForCurrentStudentTotal = 0;
        for (Course currentCourse : coursesForStudent) {
            if (course.getId().equals(currentCourse.getId())) {
                throw new CantEnrollStudentException("This student is already enrolled in this course");
            }
            unitsForCurrentStudentTotal += currentCourse.getUnits();
        }

        if (unitsForCurrentStudentTotal + course.getUnits() > 24) {
            throw new CantEnrollStudentException(
                    String.format("The student is already enrolled in %d units," +
                            "and therefore can't take a course with %d units", unitsForCurrentStudentTotal,
                            course.getUnits()));
        }

        if (isStudentsOtherCoursesOverlapWithCourse (student, course)) {
            throw new ScheduleConflictException("Student has other courses for provided time " +
                    "and can't be enrolled in this course");
        }
    }

    public void verifyUnenrollStudent (Course course, Student student) {
        verifyCourseExists(course);
        studentVerifier.verifyStudentExists (student);
        List<Course> coursesForStudent = courseDao.getCoursesByStudentId (student.getId());

        boolean isEnrolled = coursesForStudent.contains(course);
        
        if (! isEnrolled) {
            throw new CantUnenrollStudentException("This student is not enrolled " +
                    "in this course, and therefore can't be deleted");
        }

    }

    private void verifyCourse (Course course) {

        if (course == null ) {
            logger.warn("The course has to be defined");
            throw new InvalidArgumentException("The course has to be defined");
        }
        if (! StringUtils.hasLength(course.getName())) {
            logger.warn("The course should have a name");
            throw new InvalidCourseException("The course should have a name");
        }
        if (! StringUtils.hasLength(course.getLocation())) {
            logger.warn("The course should have a location");
            throw new InvalidCourseException("The course should have a location");
        }
        if (course.getSection() == null || course.getSection()  < 0) {
            logger.warn("The course section should be defined and be 1 or more");
            throw new InvalidCourseException("The course section should be defined and be 0 or more");
        }
        verifyMeetingHours(course.getMeetingHours());

        if (isCourseOverlappingWithDBForThisTimeLocation(course)) {
            throw new RoomBookedException();
        }
    }

    public void verifyCourseExists (Course course) {
        if (course == null ) {
            logger.warn("The course has to be defined");
            throw new InvalidArgumentException("The course has to be defined");
        }
        if (course.getId() == null) {
            logger.warn("The course must have an ID set");
            throw new InvalidArgumentException("The course must have an ID set");
        }
        if (courseDao.getById(course.getId()) == null) {
            throw new NoSuchCourseException();
        }
    }

    // called only after "verifyCourse" to avoid NPE
    private void verifyCourseDuplicates (Course course) {
        Course courseFromDB = courseDao.getByNameAndSection
                (course.getName(), course.getSection());
        if (courseFromDB != null ) {
            if (course.getId() != null) {
                if (!courseFromDB.getId().equals(course.getId())) {
                    throw new DuplicateCourseException(course.getName(), course.getSection());
                }
            } else {
                throw new DuplicateCourseException(course.getName(), course.getSection());
            }
        }
    }


}
