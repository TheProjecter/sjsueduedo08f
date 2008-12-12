package edu.sjsu.edo08f.services.utils;

import edu.sjsu.edo08f.dao.CourseDao;
import edu.sjsu.edo08f.dao.PersonDao;
import edu.sjsu.edo08f.exceptions.InvalidArgumentException;
import edu.sjsu.edo08f.exceptions.GeneralException;
import edu.sjsu.edo08f.domain.Course;
import edu.sjsu.edo08f.domain.Person;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.List;
import java.lang.reflect.Method;

/**
 * Created by: Alex Yarmula
 * Date: Nov 27, 2008
 */
public class SearchUtils {

    private CourseDao courseDao;
    private PersonDao personDao;

    public void setCourseDao(CourseDao courseDao) {
        this.courseDao = courseDao;
    }

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    public List<Person> searchPerson(String searchedField, String searchedValue) {

        if (searchedField.equals("first-name")) searchedField = "firstname";
        else if (searchedField.equals("last-name")) searchedField = "lastname";
        else if (searchedField.equals("zip-code")) searchedField = "zipcode";

        searchedField = searchedField.toLowerCase();

        checkThatFieldsHaveValues (searchedField, searchedValue);

        Map<String, String> allowedFieldsWithTypes = getFieldsWithTypesForClass ("Person");

        checkIfFieldIsAllowed (searchedField, allowedFieldsWithTypes.keySet());

        boolean fullMatch = isSearchByFullValue (allowedFieldsWithTypes.get(searchedField));

        if (fullMatch) {
            checkSearchedValueToBeNumber (searchedValue);
        }

        if (searchedField.equals("firstname")) searchedField = "first_name";
        if (searchedField.equals("lastname")) searchedField = "last_name";
        if (searchedField.equals("zipcode")) searchedField = "zip_code";

        searchedField = "person." + searchedField;

        if (fullMatch) return personDao.searchExact(searchedField, searchedValue);
        else return personDao.search(searchedField, searchedValue);

    }

    public List<Course> searchCourse(String searchedField, String searchedValue) {

        searchedField = searchedField.toLowerCase();

        checkThatFieldsHaveValues (searchedField, searchedValue);

        Map<String, String> allowedFieldsWithTypes = getFieldsWithTypesForClass ("Course");

        checkIfFieldIsAllowed (searchedField, allowedFieldsWithTypes.keySet());

        boolean fullMatch = isSearchByFullValue (allowedFieldsWithTypes.get(searchedField));

        if (fullMatch) {
            checkSearchedValueToBeNumber (searchedValue);
        }

        if (searchedField.equals("location")) searchedField = "location.name";
        else searchedField = "course." + searchedField;

        if (fullMatch) return courseDao.searchExact(searchedField, searchedValue);
        else return courseDao.search(searchedField, searchedValue);
    }

    private void checkThatFieldsHaveValues (String searchedField, String searchedValue) {
        if (!StringUtils.hasText (searchedField)) throw new InvalidArgumentException("The searched field must have value");
        if (!StringUtils.hasText (searchedValue)) throw new InvalidArgumentException("The searched token must have value");
    }

    private Map<String, String> getFieldsWithTypesForClass (String className) {
        Map<String, String> allowedFieldsWithTypes = new HashMap<String, String>();
        Class searchedClass = getClassByName (className);
        for (Method method: searchedClass.getMethods()) {
            String methodName = method.getName();
            if (methodName.startsWith("get")) {
                String nameOfField = methodName.substring("get".length()).toLowerCase();
                String fieldType = method.getReturnType().getName();
                if (!fieldType.contains ("java.lang") || fieldType.contains("java.lang.Class")) continue;
                allowedFieldsWithTypes.put(nameOfField, fieldType);
            }
        }

        return allowedFieldsWithTypes;
    }

    private Class getClassByName (String className) {
        try {
            return Class.forName("edu.sjsu.edo08f.domain." + className);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new GeneralException(String.format("Class \"%s\"doesn't exist", className));
        }
    }

    private void checkIfFieldIsAllowed (String fieldName, Set<String> allFields) {
        if (! allFields.contains(fieldName)) {
            throw new InvalidArgumentException(String.format("There's no field named \"%s\" to search", fieldName));
        }
    }

    private boolean isSearchByFullValue (String searchedValueType) {

        try {
            return (Number.class.isAssignableFrom(Class.forName(searchedValueType)));
        } catch (Exception e) {
            e.printStackTrace();
            throw new GeneralException(String.format("Class \"%s\"doesn't exist, even though we just received it", searchedValueType));
        }

    }

    private void checkSearchedValueToBeNumber (String searchedValue) {
        try {
            Double.parseDouble(searchedValue);
        } catch (NumberFormatException e) {
            throw new InvalidArgumentException(
                    String.format("The searched value \"%s\" has to be a number, but it's not", searchedValue));
        }
    }

}
