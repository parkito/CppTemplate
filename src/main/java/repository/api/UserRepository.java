package repository.api;

import entity.User;
import exception.RepositoryException;

import java.util.List;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public interface UserRepository extends GenericRepository<User, Long> {

    User findUserByEmail(String email) throws RepositoryException;

    List<User> findUsersByEmails(List<String> emails) throws RepositoryException;

}
