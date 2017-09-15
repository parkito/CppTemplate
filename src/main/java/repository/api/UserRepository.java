package repository.api;

import entity.User;

/**
 * @author Artem Karnov @date 15.09.2017.
 * artem.karnov@t-systems.com
 */
public interface UserRepository extends GenericRepository<User, Long> {

    User findUserByEmail(String email);

}
