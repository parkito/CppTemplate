package ru.siksmfp.ejb.crud.service;

import ru.siksmfp.ejb.crud.entity.Role;
import ru.siksmfp.ejb.crud.entity.UserEntity;
import ru.siksmfp.ejb.crud.repository.impl.UserRepository;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author Artem Karnov @date 4/17/2018.
 * @email artem.karnov@t-systems.com
 */
@Stateless
public class UsersService {
    @EJB
    private UserRepository userRepository;

    public UserEntity findUserByEmail(String email) {
        return userRepository.findUserByEmail(email);
    }

    public void deleteUser(String email) {
        userRepository.deleteUserByEmail(email);
    }

    public void createUser(String email, String firstName, String secondName, String password) {
        UserEntity newUser = new UserEntity(email, firstName, secondName, password, Role.USER);
        userRepository.save(newUser);
    }
}
