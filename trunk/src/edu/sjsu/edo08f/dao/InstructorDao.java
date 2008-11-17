package edu.sjsu.edo08f.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import edu.sjsu.edo08f.domain.Instructor;

import java.util.List;

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

}
