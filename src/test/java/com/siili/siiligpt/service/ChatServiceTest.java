package com.siili.siiligpt.service;

import com.siili.siiligpt.model.ChatDTO;
import com.siili.siiligpt.openai.client.OpenAIClient;
import com.siili.siiligpt.repository.ChatRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class ChatServiceTest {

    @Mock
    private OpenAIClient openAIClient;
    @Mock
    private ChatRepository chatRepository;
    @Mock
    private MessageService messageService;

    private ChatService chatService;

    @BeforeEach()
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        chatService = new ChatService(openAIClient, chatRepository, messageService);
    }

    @Test
    public void testCreateChatReturnsId() {
        // Arrange
        ChatDTO chat = new ChatDTO();
        chat.setName("name");
        int expectedId = 0;

        when(chatRepository.save(chat)).thenReturn(chat);

        // Act
        int actualId = chatService.createChat(chat);

        // Assert
        assertEquals(expectedId, actualId);

        // Verify that the save method was called with the expected argument
        verify(chatRepository).save(chat);
    }

    @Test
    public void testChatReturnsChatDTO() {
        // Arrange
        String prompt = "prompt";
        int chatId = 0;
        ChatDTO expectedChatDTO = new ChatDTO();
        expectedChatDTO.setId(chatId);
        expectedChatDTO.setName("name");
        expectedChatDTO.setMessages(null);

        when(chatRepository.findById(chatId)).thenReturn(java.util.Optional.of(expectedChatDTO));

        // Act
        ChatDTO actualChatDTO = chatService.chat(prompt, chatId);

        // Assert
        assertEquals(expectedChatDTO, actualChatDTO);

        // Verify that the findById method was called with the expected argument
        verify(chatRepository).findById(chatId);
    }
}
