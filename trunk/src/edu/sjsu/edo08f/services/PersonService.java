package edu.sjsu.edo08f.services;

import edu.sjsu.edo08f.domain.Person;

import java.util.List;
import java.util.Map;

/**
 * Created by: Oleksiy Yarmula
 * Date: Oct 12, 2008
 */
public interface PersonService {

    List<Person> getAll(); // exceptions: general exception. may return empty list

    List<Person> search (String searchedFieldName, String searchedValue); // exc: general exception, invalid argument exception (if nulls are passed in)

}
