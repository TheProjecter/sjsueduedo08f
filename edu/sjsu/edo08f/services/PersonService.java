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

    /*
    Need to think more about how search is going to work:
    Maybe field - valueToSeach isn't enough. It may need to seach > 5 and < 10 of somrthing
     */
    List<Person> search (Map<String /*name of field*/, String /*value*/> params); // may return an empty list

}
