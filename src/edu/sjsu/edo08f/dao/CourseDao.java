package edu.sjsu.edo08f.dao;

import edu.sjsu.edo08f.domain.Course;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

/**
 * Created by: Alex Yarmula
 * Date: Nov 11, 2008
 */
public class CourseDao extends SqlMapClientDaoSupport {

    private final String NAMESPACE = "Course.";

    public Course getById (Long id) {
        return (Course) getSqlMapClientTemplate().queryForObject(NAMESPACE + "getById", id);
    }

    public List<Course> getAll () {
        return (List<Course>) getSqlMapClientTemplate().queryForList(NAMESPACE + "getAll");
    }

    public Course getByNameAndSection (String name, Integer section) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("name", name);
        parameters.put("section", section);
        return (Course) getSqlMapClientTemplate().queryForObject(NAMESPACE + "getByNameAndSection", parameters);
    }

    public List<Course> getByLocationName(String locationName) {
        return (List<Course>) getSqlMapClientTemplate().queryForList(NAMESPACE + "getByLocationName", locationName);
    }

    public List<Course> getCoursesByInstructorId (Long instructorId) {
        return (List<Course>) getSqlMapClientTemplate().queryForList(NAMESPACE + "getByInstructorId", instructorId); 
    }

    public List<Course> getCoursesByStudentId (Long studentId) {
        return (List<Course>) getSqlMapClientTemplate().queryForList(NAMESPACE + "getByStudentId", studentId); 
    }

    public Course create (Course course, Long instructorId, Long locationId) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("course", course);
        parameters.put("instructorId", instructorId);
        parameters.put("locationId", locationId);
        getSqlMapClientTemplate().insert(NAMESPACE + "create", parameters);
        return course;
    }

    public Course update (Course course, Long locationId) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("course", course);
        parameters.put("locationId", locationId);
        getSqlMapClientTemplate().update(NAMESPACE + "update", parameters);
        return course;
    }

    public void delete (Long courseId) {
        getSqlMapClientTemplate().delete(NAMESPACE + "delete", courseId);
    }

    public void enrollStudent (Long courseId, Long studentId) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("courseId", courseId);
        parameters.put("studentId", studentId);
        getSqlMapClientTemplate().insert(NAMESPACE + "enrollStudent", parameters);
    }

}