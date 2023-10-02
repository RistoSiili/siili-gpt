package com.siili.siiligpt.service;

import com.siili.siiligpt.model.MessageDTO;
import com.siili.siiligpt.repository.MessageRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    public MessageService(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    public int createMessage(MessageDTO message) {
        validateMessage(message);
        return messageRepository.save(message).getId();
    }

    public List<MessageDTO> getMessagesForChatId(int chatId) {
        return (List<MessageDTO>) messageRepository.findAllByChatId(chatId);
    }

    private void validateMessage(MessageDTO message) {
        if (message.getCreated() == null) {
            message.setCreated(new Date());
        }
        if (message.getUpdated() == null) {
            message.setUpdated(new Date());
        }
    }
}
