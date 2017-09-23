package com.karnov.crud.repository.impl;

import com.karnov.crud.entity.Message;
import com.karnov.crud.repository.api.MessageRepository;

import java.util.List;

/**
 * @author Artem Karnov @date 9/23/2017.
 * artem.karnov@t-systems.com
 */
public class MessageRepositoryImpl extends GenericRepositoryImpl<Message, Long> implements MessageRepository {
    // TODO: 9/23/2017 finish it
    @Override
    public List<Message> findAllMessageFromPerson(String email) {
        return entityManager
                .createQuery("select m from Message m where m.email=:email")
                .setParameter("email", email)
                .getResultList();
    }

    @Override
    public List<Message> findAllMessageToPerson(String email) {
        return null;
    }
}
