package service;

import entity.User;
import exception.EntityCreateException;
import exception.RepositoryException;
import repository.api.UserRepository;

import static utility.DIContainer.userRepositoryInstance;
import static utility.Utility.encryptPassword;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public class UserService {

    private UserRepository userRepository = userRepositoryInstance();

    public boolean createUser(User user) {
        try {
            encryptPassword(user.getPassword());
            userRepository.create(user);
            return true;
        } catch (EntityCreateException ex) {
            return false;
        }
    }

    public User findUserByEmail(String email) {
        try {
            return userRepository.findUserByEmail(email);
        } catch (EntityCreateException ex) {
            return null;
        }
    }

    public boolean deleteUser(String email) {
        try {
            User user = userRepository.findUserByEmail(email);
            userRepository.delete(user);
            return true;
        } catch (RepositoryException ex) {
            return false;
        }
    }

    public boolean updateUser(User oldUser, User newUser) {
        try {
            User user = userRepository.findUserByEmail(oldUser.getEmail());
            newUser.setId(oldUser.getId());
            if (!oldUser.getPassword().equals(newUser.getPassword())) {
                newUser.setPassword(encryptPassword(newUser.getPassword()));
            }
            userRepository.update(user);
            return true;
        } catch (RepositoryException ex) {
            return false;
        }
    }

}
