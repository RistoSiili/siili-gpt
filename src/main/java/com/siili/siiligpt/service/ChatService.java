package com.siili.siiligpt.service;

import com.siili.siiligpt.model.ChatDTO;
import com.siili.siiligpt.model.MessageDTO;
import com.siili.siiligpt.openai.client.OpenAIClient;
import com.siili.siiligpt.repository.ChatRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class ChatService {
    private final OpenAIClient openAIClient;
    private final ChatRepository chatRepository;
    private final MessageService messageService;

    public ChatService(OpenAIClient openAIClient, ChatRepository chatRepository, MessageService messageService) {
        this.openAIClient = openAIClient;
        this.chatRepository = chatRepository;
        this.messageService = messageService;
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

    public ChatDTO chat(String prompt, int chatId) {
        // Create an owner message
        messageService.createMessage(new MessageDTO(prompt, chatId, "user"));

        // Get the assistant's response
        String assistantResponse = openAIClient.chat(prompt);

        // Create an assistant message
        messageService.createMessage(new MessageDTO(assistantResponse, chatId, "assistant"));

        ChatDTO chatDTO = chatRepository.findById(chatId).orElseThrow();
        chatDTO.setMessages(messageService.getMessagesForChatId(chatId));
        return chatDTO;
    }
}
