package edu.sjsu.edo08f.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;

import edu.sjsu.edo08f.domain.Student;

/**
 * Created by: Alex Yarmula
 * Date: Nov 11, 2008
 */
public class StudentDao  extends SqlMapClientDaoSupport {

    private final String NAMESPACE = "Student.";

    public Student getById (Long id) {
        return (Student) getSqlMapClientTemplate().queryForObject(NAMESPACE + "getById", id);
    }

    public List<Student> getAll () {
        return (List<Student>) getSqlMapClientTemplate().queryForList(NAMESPACE + "getAll");
    }

    public List<Student> getStudentsByCourse (Long courseId) {
        return (List<Student>) getSqlMapClientTemplate().queryForList(NAMESPACE + "getStudentsByCourse", courseId);
    }

}
