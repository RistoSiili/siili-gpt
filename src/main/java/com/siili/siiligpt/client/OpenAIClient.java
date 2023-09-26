package com.siili.siiligpt.client;

import com.siili.siiligpt.model.ChatRequest;
import com.siili.siiligpt.model.ChatResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

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

    public String chat(String prompt) {
        // create a request
        ChatRequest request = new ChatRequest(model, prompt);

        ChatResponse response = restTemplate.postForObject(apiUrl, request, ChatResponse.class);

        if (response == null || response.getChoices() == null || response.getChoices().isEmpty()) {
            return "No response";
        }

        // return the first response
        return response.getChoices().get(0).getMessage().getContent();
    }
}
