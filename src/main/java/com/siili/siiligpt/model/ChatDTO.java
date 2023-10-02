package com.siili.siiligpt.model;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "chat")
public class ChatDTO {

    @Id
    @SequenceGenerator(name = "chat_id_seq", sequenceName = "chat_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "chat_id_seq")
    private int id;
    private String name;

    @Transient
    private List<MessageDTO> messages;
    private Date created;
    private Date updated;

    public ChatDTO() {
    }

    public ChatDTO(ChatDTO other) {
        this.id = other.getId();
        this.name = other.getName();
        this.messages = other.getMessages();
        this.created = other.getCreated();
        this.updated = other.getUpdated();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MessageDTO> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageDTO> messages) {
        this.messages = messages;
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
