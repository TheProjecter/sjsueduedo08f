package edu.sjsu.edo08f.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

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

    public Student getByTowerId (String towerId) {
        return (Student) getSqlMapClientTemplate().queryForObject(NAMESPACE + "getByTowerId", towerId);
    }

    public Student create (Student student) {
        getSqlMapClientTemplate().insert(NAMESPACE + "create", student);
        getSqlMapClientTemplate().insert(PersonDao.NAMESPACE + "createStudent", student);
        return student;
    }

    public Student update (Student student) {
        getSqlMapClientTemplate().update(NAMESPACE + "update", student);
        getSqlMapClientTemplate().update(PersonDao.NAMESPACE + "updateStudent", student);
        return student;
    }

    public void delete (Long studentId) {
        getSqlMapClientTemplate().delete(PersonDao.NAMESPACE + "deleteStudent", studentId);
        getSqlMapClientTemplate().delete(NAMESPACE + "delete", studentId);
    }

}
