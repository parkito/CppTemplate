package com.karnov.crud.service;

import com.karnov.crud.entity.Users;
import com.karnov.crud.exception.EntityCreateException;
import com.karnov.crud.exception.RepositoryException;
import com.karnov.crud.repository.api.UserRepository;
import com.karnov.crud.repository.impl.UserRepositoryImpl;

//import static com.karnov.crud.utility.DIContainer.userRepositoryInstance;
import static com.karnov.crud.utility.Utility.encryptPassword;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class UserService {

    private UserRepository userRepository = new UserRepositoryImpl();

    public boolean createUser(Users user) {
        try {
//            encryptPassword(user.getPassword());
            userRepository.create(user);
            return true;
        } catch (EntityCreateException ex) {
            return false;
        }
    }

    public Users findUserByEmail(String email) {
        try {
            return userRepository.findUserByEmail(email);
        } catch (EntityCreateException ex) {
            return null;
        }
    }

    public boolean deleteUser(String email) {
        try {
            Users user = userRepository.findUserByEmail(email);
            userRepository.delete(user);
            return true;
        } catch (RepositoryException ex) {
            return false;
        }
    }

    public boolean updateUser(Users oldUser, Users newUser) {
        try {
            Users user = userRepository.findUserByEmail(oldUser.getEmail());
            newUser.setId(oldUser.getId());
//            if (!oldUser.getPassword().equals(newUser.getPassword())) {
//                newUser.setPassword(encryptPassword(newUser.getPassword()));
//            }
            userRepository.update(user);
            return true;
        } catch (RepositoryException ex) {
            return false;
        }
    }

}
