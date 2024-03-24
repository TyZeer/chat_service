package com.web.chat.services;

import com.web.chat.models.Message;
import com.web.chat.models.Topic;
import com.web.chat.repos.MessageRepository;
import com.web.chat.repos.TopicRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final TopicRepository topicRepository;
    private final MessageRepository messageRepository;
    public void sendMessage(long sender, long receiver, long topic_id, String contents){
        Message message = Message.builder()
                .sender_id(sender)
                .recipient_id(receiver)
                .timestamp(LocalDateTime.now())
                .contents(contents)
                .topic_id(topic_id)
                .build();
        if (topicRepository.existsById(topic_id)){
            messageRepository.save(message);
        }
        else{
            Topic topic =
                    Topic.builder()
                            .topicName("Name Template")
                            .build();
        }
    }
    public List<Message> showMessages(long topicId){
        System.out.println("Я НИХУЯ НЕ СДЕЛАЛ");
        return new ArrayList<>();
    }


}
