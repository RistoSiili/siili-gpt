package com.siili.siiligpt.repository;

import com.siili.siiligpt.model.MessageDTO;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<MessageDTO, Integer> {

    Iterable<MessageDTO> findAllByChatId(int chatId);
}
