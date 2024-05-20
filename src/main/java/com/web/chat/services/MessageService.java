package com.web.chat.services;

import com.web.chat.models.Image;
import com.web.chat.models.Message;
import com.web.chat.models.Topic;
import com.web.chat.repos.ImageRepository;
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
    private final ImageRepository imageRepository;
    public void sendMessage(long sender, long receiver, long topic_id, String contents){
        Message message = Message.builder()
                .senderId(sender)
                .recipientId(receiver)
                .timestamp(LocalDateTime.now())
                .contents(contents)
                .topicId(topic_id)
                .build();
        if (topicRepository.existsById(topic_id)){
            messageRepository.save(message);
        }
        else{
            Topic topic =
                    Topic.builder()
                            .topicName("Name Template")
                            .build();
            topicRepository.save(topic);
            messageRepository.save(message);
        }
    }
    public List<Message> showMessagesByTopic(long topicId){
        List<Message> messages;
        if (topicRepository.existsById(topicId)){
            messages = messageRepository.findAllByTopicId(topicId);
            return messages;
        }
        return null;
    }
    public void sendImage(long topicId, byte[] data){
        if (topicRepository.existsById(topicId)){
            Image image = Image.builder()
                    .data(data)
                    .mimeType("image/jpeg")
                    .build();
            imageRepository.save(image);
        }
    }
   // public List<Message> showAllOutComingMessages(Long senderId){}

    //public List<Message> showAllIncomingMessages(Long recipientId){}

}
