package com.web.chat.services;

import com.web.chat.models.Topic;
import com.web.chat.repos.MessageRepository;
import com.web.chat.repos.TopicRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TopicService {
    private final TopicRepository topicRepository;
    private final MessageRepository messageRepository;
    public Topic createNewTopic(){
        Topic newTopic = new Topic();
        newTopic = giveTopicName(newTopic);
        return newTopic;
    }
    public Topic giveTopicName(Topic topic){
        //call to api to set name
        topic.setTopicName("topicName");
        return topic;
    }
}
