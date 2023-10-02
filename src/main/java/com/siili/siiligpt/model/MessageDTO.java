package com.siili.siiligpt.model;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "message")
public class MessageDTO {

    @Id
    @SequenceGenerator(name = "message_id_seq", sequenceName = "message_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_id_seq")
    private int id;

    private int chatId;
    private String role;
    private String content;
    private Date created = new Date();
    private Date updated = new Date();

    public MessageDTO() {
    }

    public MessageDTO(String content, int chatId, String role) {
        this.content = content;
        this.role = role;
        this.chatId = chatId;
    }

    public MessageDTO(MessageDTO other) {
        this.id = other.getId();
        this.chatId = other.getChatId();
        this.role = other.getRole();
        this.content = other.getContent();
        this.created = other.getCreated();
        this.updated = other.getUpdated();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChatId() {
        return chatId;
    }

    public void setChatId(int chatId) {
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
