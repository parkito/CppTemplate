package com.karnov.crud.repository.api;

import com.karnov.crud.entity.Person;
import com.karnov.crud.exception.RepositoryException;

import java.util.List;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public interface PersonRepository extends GenericRepository<Person, Long> {

    Person findUserByEmail(String email) throws RepositoryException;

    List<Person> findPersonsByEmails(List<String> emails) throws RepositoryException;

}
