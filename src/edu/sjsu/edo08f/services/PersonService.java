package edu.sjsu.edo08f.services;

import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.domain.Course;

import java.util.List;
import java.util.Map;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public interface PersonService {

    List<Person> getAll();
    Person getById (Long id);

    List<Person> search (String searchedFieldName, String searchedValue);

}
