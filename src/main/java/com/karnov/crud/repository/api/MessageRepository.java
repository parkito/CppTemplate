package com.karnov.crud.repository.api;

import com.karnov.crud.entity.Message;

import java.util.List;

/**
 * @author Artem Karnov @date 9/23/2017.
 * artem.karnov@t-systems.com
 */
public interface MessageRepository {

    List<Message> findAllMessageFromPerson(String email);

    List<Message> findAllMessageToPerson(String email);
}
