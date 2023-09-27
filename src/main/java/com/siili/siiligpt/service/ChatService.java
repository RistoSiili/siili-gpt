package com.siili.siiligpt.service;

import com.siili.siiligpt.model.ChatDTO;
import com.siili.siiligpt.openai.client.OpenAIClient;
import com.siili.siiligpt.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChatService {
    private final OpenAIClient openAIClient;
    private final ChatRepository chatRepository;

    public ChatService(OpenAIClient openAIClient, ChatRepository chatRepository) {
        this.openAIClient = openAIClient;
        this.chatRepository = chatRepository;
    }

    public int createChat(ChatDTO chat) {
        validateChat(chat);
        return chatRepository.save(chat).getId();
    }

    private void validateChat(ChatDTO chat) {
        if (chat.getCreated() == null) {
            chat.setCreated(new Date());
        }
        if (chat.getUpdated() == null) {
            chat.setUpdated(new Date());
        }
    }

    public String chat(String prompt) {
        return openAIClient.chat(prompt);
    }
}
