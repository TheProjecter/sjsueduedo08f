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
}