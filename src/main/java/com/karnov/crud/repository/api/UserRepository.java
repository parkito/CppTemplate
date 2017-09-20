package com.karnov.crud.repository.api;

import com.karnov.crud.entity.Users;
import com.karnov.crud.exception.RepositoryException;

import java.util.List;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public interface UserRepository extends GenericRepository<Users, Long> {

    Users findUserByEmail(String email) throws RepositoryException;

    List<Users> findUsersByEmails(List<String> emails) throws RepositoryException;

}
