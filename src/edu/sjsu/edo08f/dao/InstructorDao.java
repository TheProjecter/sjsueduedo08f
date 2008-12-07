package edu.sjsu.edo08f.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import edu.sjsu.edo08f.domain.Instructor;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by: Alex Yarmula
 * Date: Nov 11, 2008
 */
public class InstructorDao extends SqlMapClientDaoSupport {

    private final String NAMESPACE = "Instructor.";

    public Instructor getById (Long id) {
        return (Instructor) getSqlMapClientTemplate().queryForObject(NAMESPACE + "getById", id);
    }

    public List<Instructor> getAll () {
        return (List<Instructor>) getSqlMapClientTemplate().queryForList(NAMESPACE + "getAll");
    }

    public Instructor getInstructorByCourse (Long courseId) {
        return (Instructor) getSqlMapClientTemplate().queryForObject(NAMESPACE + "getInstructorByCourse", courseId);
    }

    public Long getInstructorIdByCourse (Long courseId) {
        return (Long) getSqlMapClientTemplate().queryForObject(NAMESPACE + "getInstructorIdByCourse", courseId);
    }

    public Instructor getByEmployeeId (String employeeId) {
        return (Instructor) getSqlMapClientTemplate().queryForObject(NAMESPACE + "getByEmployeeId", employeeId);
    }

    public Instructor create (Instructor instructor, Long locationId) {

        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put ("instructor", instructor);
        parameters.put("locationId", locationId);

        getSqlMapClientTemplate().insert(NAMESPACE + "create", parameters);
        getSqlMapClientTemplate().insert(PersonDao.NAMESPACE + "createInstructor", instructor);
        return instructor;
    }

    public Instructor update (Instructor instructor, Long locationId) {
        
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put ("instructor", instructor);
        parameters.put("locationId", locationId);

        getSqlMapClientTemplate().insert(NAMESPACE + "update", parameters);

        getSqlMapClientTemplate().update(PersonDao.NAMESPACE + "updateInstructor", instructor);
        return instructor;
    }

    public void delete (Long instructorId) {
        getSqlMapClientTemplate().delete(PersonDao.NAMESPACE + "deleteInstructor", instructorId);
        getSqlMapClientTemplate().delete(NAMESPACE + "delete", instructorId);
    }

}
