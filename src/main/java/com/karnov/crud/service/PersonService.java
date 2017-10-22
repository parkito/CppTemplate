package com.karnov.crud.service;

import com.karnov.crud.entity.Person;
import com.karnov.crud.exception.EntityCreateException;
import com.karnov.crud.exception.RepositoryException;
import com.karnov.crud.repository.api.PersonRepository;

import javax.persistence.EntityNotFoundException;

import java.util.List;

import static com.karnov.crud.utility.DIContainer.userRepositoryInstance;
import static com.karnov.crud.utility.Utility.encryptPassword;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class PersonService {

    private PersonRepository personRepository = userRepositoryInstance();

    public boolean createPerson(Person person) {
        try {
            encryptPassword(person.getPassword());
            personRepository.create(person);
            return true;
        } catch (EntityCreateException ex) {
            return false;
        }
    }

    public Person findPersonByEmail(String email) {
        try {
            return personRepository.findUserByEmail(email);
        } catch (RepositoryException ex) {
            return null;
        }
    }

    public boolean deletePerson(String email) {
        try {
            Person person = personRepository.findUserByEmail(email);
            personRepository.delete(person);
            return true;
        } catch (RepositoryException ex) {
            return false;
        }
    }

    public boolean updatePerson(Person oldPerson, Person newPerson) {
        try {
            Person person = personRepository.findUserByEmail(oldPerson.getEmail());
            newPerson.setId(oldPerson.getId());
            if (!oldPerson.getPassword().equals(newPerson.getPassword())) {
                newPerson.setPassword(encryptPassword(newPerson.getPassword()));
            }
            personRepository.update(person);
            return true;
        } catch (RepositoryException ex) {
            return false;
        }
    }

    public List<Person> findAll() {
        try {
            return personRepository.getAll();
        } catch (RepositoryException ex) {
            return null;
        }
    }

}
