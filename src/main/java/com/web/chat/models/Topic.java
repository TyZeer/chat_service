package com.web.chat.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name ="topic")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;

    public String topicName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    public List<Message> topicMessages;
}
