package com.siili.siiligpt.service;

import com.siili.siiligpt.openai.client.OpenAIClient;
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

    private ChatService chatService;

    @BeforeEach()
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        chatService = new ChatService(openAIClient);
    }

    @Test
    public void testChatMethodReturnsResponse() {
        // Arrange
        String prompt = "Hello, chatbot!";
        String expectedResponse = "Hi there! How can I help you?";

        // Mock the behavior of OpenAIClient's chat method
        when(openAIClient.chat(prompt)).thenReturn(expectedResponse);

        // Act
        String actualResponse = chatService.chat(prompt);

        // Assert
        assertEquals(expectedResponse, actualResponse);

        // Verify that the chat method was called with the expected argument
        verify(openAIClient).chat(prompt);
    }
}
