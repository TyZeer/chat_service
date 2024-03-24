package com.web.chat.repos;

import com.web.chat.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TopicRepository extends JpaRepository<Topic,Long > {

    boolean existsById(long topicId);
}
