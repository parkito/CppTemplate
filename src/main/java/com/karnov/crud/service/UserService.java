package com.karnov.crud.service;

import com.karnov.crud.entity.Person;
import com.karnov.crud.exception.EntityCreateException;
import com.karnov.crud.exception.RepositoryException;
import com.karnov.crud.repository.api.UserRepository;

import static com.karnov.crud.utility.DIContainer.userRepositoryInstance;
import static com.karnov.crud.utility.Utility.encryptPassword;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class UserService {

    private UserRepository userRepository = userRepositoryInstance();

    public boolean createUser(Person person) {
        try {
            encryptPassword(person.getPassword());
            userRepository.create(person);
            return true;
        } catch (EntityCreateException ex) {
            return false;
        }
    }

    public Person findUserByEmail(String email) {
        try {
            return userRepository.findUserByEmail(email);
        } catch (EntityCreateException ex) {
            return null;
        }
    }

    public boolean deleteUser(String email) {
        try {
            Person person = userRepository.findUserByEmail(email);
            userRepository.delete(person);
            return true;
        } catch (RepositoryException ex) {
            return false;
        }
    }

    public boolean updateUser(Person oldPerson, Person newPerson) {
        try {
            Person person = userRepository.findUserByEmail(oldPerson.getEmail());
            newPerson.setId(oldPerson.getId());
            if (!oldPerson.getPassword().equals(newPerson.getPassword())) {
                newPerson.setPassword(encryptPassword(newPerson.getPassword()));
            }
            userRepository.update(person);
            return true;
        } catch (RepositoryException ex) {
            return false;
        }
    }

}
