package com.siili.siiligpt.model;

import java.util.Date;

public class MessageDTO {
    String id;
    String chatId;
    String role;
    String content;
    Date created;
    Date updated;

    public MessageDTO() {
    }

    public MessageDTO(MessageDTO other) {
        this.id = other.getId();
        this.chatId = other.getChatId();
        this.role = other.getRole();
        this.content = other.getContent();
        this.created = other.getCreated();
        this.updated = other.getUpdated();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getChatId() {
        return chatId;
    }

    public void setChatId(String chatId) {
        this.chatId = chatId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
