package com.siili.siiligpt.controller;

import com.siili.siiligpt.model.ChatDTO;
import com.siili.siiligpt.service.ChatService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ChatController {

    private final ChatService chatService;

    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @PostMapping("/create-chat")
    public ResponseEntity<Integer> createChat(@RequestBody ChatDTO chatDTO) {
        int id = chatService.createChat(chatDTO);
        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @PostMapping("/chat")
    public ResponseEntity<ChatDTO> chat(@RequestParam int chatId, @RequestParam String prompt) {
        return new ResponseEntity<>(chatService.chat(prompt, chatId), HttpStatus.OK);
    }

    @GetMapping("/chats")
    public ResponseEntity<List<ChatDTO>> getChats() {
        return new ResponseEntity<>(chatService.getChats(), HttpStatus.OK);
    }
}
