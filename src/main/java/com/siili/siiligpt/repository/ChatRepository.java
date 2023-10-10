package com.siili.siiligpt.repository;

import com.siili.siiligpt.model.ChatDTO;
import org.springframework.data.repository.CrudRepository;

public interface ChatRepository extends CrudRepository<ChatDTO, Integer> {

}
