package ru.siksmfp.ejb.crud.repository.impl;

import ru.siksmfp.ejb.crud.entity.Role;
import ru.siksmfp.ejb.crud.entity.UserEntity;
import ru.siksmfp.ejb.crud.exception.DAOException;
import ru.siksmfp.ejb.crud.repository.api.GenericRepository;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import java.util.Arrays;
import java.util.List;

/**
 * @author Artem Karnov @date 7/9/2018.
 * @email artem.karnov@t-systems.com
 */
@Stateless
public class UserRepository extends GenericRepository<UserEntity, Long> {

    @PostConstruct
    public void setUp() {
        deleteAll();

        UserEntity user1 = new UserEntity("email1", "name1", "secondName1", "1", Role.ADMIN);
        UserEntity user2 = new UserEntity("email2", "name2", "secondName2", "2", Role.USER);
        UserEntity user3 = new UserEntity("email3", "name3", "secondName3", "3", Role.USER);
        UserEntity user4 = new UserEntity("email4", "name4", "secondName4", "4", Role.ROOT);
        UserEntity user5 = new UserEntity("email5", "name5", "secondName5", "5", Role.USER);
        UserEntity user6 = new UserEntity("email6", "name6", "secondName6", "6", Role.USER);
        UserEntity user7 = new UserEntity("email7", "name7", "secondName7", "7", Role.USER);
        UserEntity user8 = new UserEntity("email8", "name8", "secondName8", "8", Role.ADMIN);

        List<UserEntity> userEntities = Arrays.asList(user1, user2, user3, user4, user5, user6, user7, user8);
        batchSave(userEntities);
    }

    public UserEntity findUserByEmail(String email) {
        UserEntity userEntity;
        try {
            Query query = entityManager.createQuery("from UserEntity where email =:email");
            query.setParameter("email", email);
            try {
                userEntity = (UserEntity) query.getSingleResult();
            } catch (NoResultException ex) {
                return null;
            }
            return userEntity;
        } catch (Exception ex) {
            throw new DAOException("Can't find user by email " + email, ex);
        }
    }

    public void deleteUserByEmail(String email) {
        try {
            entityManager.getTransaction().begin();
            Query query = entityManager.createQuery("delete UserEntity where email =:email");
            query.setParameter("email", email);
            query.executeUpdate();
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            throw new DAOException("Can't delete user by email " + email, ex);
        }
    }
}
