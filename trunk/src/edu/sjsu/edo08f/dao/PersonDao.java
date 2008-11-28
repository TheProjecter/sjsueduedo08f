package edu.sjsu.edo08f.dao;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import edu.sjsu.edo08f.domain.Person;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

/**
 * Created by: Alex Yarmula
 * Date: Nov 10, 2008
 */
public class PersonDao extends SqlMapClientDaoSupport {

    public static final String NAMESPACE = "Person.";

    public Person getById (Long id) {
        return (Person) getSqlMapClientTemplate().queryForObject(NAMESPACE + "getById", id);
    }

    public List<Person> getAll () {
        return (List<Person>) getSqlMapClientTemplate().queryForList(NAMESPACE + "getAll");
    }

    public List<Person> search (String searchedField, String searchedValue) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("searchedField", searchedField);
        parameters.put("searchedValue", "%" + searchedValue + "%");
        return (List<Person>) getSqlMapClientTemplate().queryForList(NAMESPACE + "search", parameters);
    }

    public List<Person> searchExact (String searchedField, String searchedValue) {
        Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("searchedField", searchedField);
        parameters.put("searchedValue", searchedValue);
        return (List<Person>) getSqlMapClientTemplate().queryForList(NAMESPACE + "searchExact", parameters);
    }

}
