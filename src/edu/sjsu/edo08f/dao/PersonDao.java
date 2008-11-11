package edu.sjsu.edo08f.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import edu.sjsu.edo08f.domain.Person;

/**
 * Created by: Alex Yarmula
 * Date: Nov 10, 2008
 */
public class PersonDao extends SqlMapClientDaoSupport {

    private final String NAMESPACE = "Person.";

    public Person getById (Long id) {
        return (Person) getSqlMapClientTemplate().queryForObject(NAMESPACE + "getById", id);
    }

}
