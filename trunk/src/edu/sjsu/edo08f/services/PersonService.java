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

    List<Person> getAll(); // exceptions: general exception. may return empty list
    Person getById (Long id);  //thows general exception, no such person, invalid argument

    List<Person> search (String searchedFieldName, String searchedValue); // exc: general exception, invalid argument exception

}
