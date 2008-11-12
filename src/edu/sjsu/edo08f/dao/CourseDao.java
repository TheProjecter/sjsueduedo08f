package edu.sjsu.edo08f.dao;

import edu.sjsu.edo08f.domain.Course;
import java.util.List;
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
}