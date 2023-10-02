package com.siili.siiligpt.repository;

import com.siili.siiligpt.model.MessageDTO;

public interface MessageRepository extends CrudRepository<MessageDTO, Integer> {

    Iterable<MessageDTO> findAllByChatId(int chatId);
}
