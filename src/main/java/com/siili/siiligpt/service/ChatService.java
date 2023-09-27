package com.siili.siiligpt.service;

import com.siili.siiligpt.openai.client.OpenAIClient;
import org.springframework.stereotype.Service;

@Service
public class ChatService {
    private final OpenAIClient openAIClient;

    public ChatService(OpenAIClient openAIClient) {
        this.openAIClient = openAIClient;
    }

    public String chat(String prompt) {
        return openAIClient.chat(prompt);
    }
}
