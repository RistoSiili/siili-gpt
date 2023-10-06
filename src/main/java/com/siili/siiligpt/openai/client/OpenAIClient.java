package com.siili.siiligpt.openai.client;

import com.siili.siiligpt.model.MessageDTO;
import com.siili.siiligpt.openai.model.ChatRequest;
import com.siili.siiligpt.openai.model.ChatResponse;
import com.siili.siiligpt.openai.model.Message;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OpenAIClient {
    @Qualifier("openaiRestTemplate")
    private RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    public OpenAIClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public String chat(List<MessageDTO> messages) {
        // create a request
        ChatRequest request = new ChatRequest(model, convertMessages(messages));

        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        // return the first response
        return response.getChoices().get(0).getMessage().getContent();
    }

    private List<Message> convertMessages(List<MessageDTO> messages) {
        return messages.stream()
                .map(messageDTO -> new Message(messageDTO.getRole(), messageDTO.getContent()))
                .collect(Collectors.toList());
    }
}
