package com.karnov.crud.repository.impl;

import com.karnov.crud.entity.User;
import com.karnov.crud.exception.RepositoryException;
import com.karnov.crud.repository.api.UserRepository;

import javax.persistence.PersistenceException;
import java.util.List;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class UserRepositoryImpl extends GenericRepositoryImpl<User, Long> implements UserRepository {

    @Override
    public User findUserByEmail(String email) throws RepositoryException {
        try {
            return (User) entityManager
                    .createQuery("select u from User u where u.email=:email")
                    .setParameter("email", email)
                    .getSingleResult();
        } catch (PersistenceException ex) {
            throw new RepositoryException("Entity wasn't found: " + email, ex);
        }
    }

    @Override
    public List<User> findUsersByEmails(List<String> emails) throws RepositoryException {
        try {
            return entityManager
                    .createQuery("select u from User u where u.email in :emails")
                    .setParameter("emails", emails)
                    .getResultList();
        } catch (PersistenceException ex) {
            throw new RepositoryException("Entity wasn't found: " + emails, ex);
        }
    }

}
