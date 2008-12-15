package edu.sjsu.edo08f.services;

import edu.sjsu.edo08f.dao.PersonDao;
import edu.sjsu.edo08f.domain.Person;
import edu.sjsu.edo08f.exceptions.NoSuchPersonException;
import edu.sjsu.edo08f.services.utils.SearchUtils;

import java.util.List;

import org.apache.log4j.Logger;

/**
 * Created by: Oleksiy Yarmula
 * Date: Nov 11, 2008
 */
public class PersonServiceImpl implements PersonService {

    private PersonDao personDao;

    public void setPersonDao(PersonDao personDao) {
        this.personDao = personDao;
    }

    private SearchUtils searchUtils;

    public void setSearchUtils(SearchUtils searchUtils) {
        this.searchUtils = searchUtils;
    }

    private static Logger logger = Logger.getLogger(PersonServiceImpl.class);

    public List<Person> getAll() {
        List<Person> persons = personDao.getAll();
        if (persons.size() == 0) logger.info("There were no entries in Person table");
        return persons;
    }

    public Person getById(Long id) {
        Person person = personDao.getById(id);
        if (person == null) {
            logger.warn("The person with such id wasn't found");
            throw new NoSuchPersonException("The person with such id wasn't found");
        }
        return person;
    }

    public List<Person> search(String searchedFieldName, String searchedValue) {
        return searchUtils.searchPerson(searchedFieldName, searchedValue);
    }
}
