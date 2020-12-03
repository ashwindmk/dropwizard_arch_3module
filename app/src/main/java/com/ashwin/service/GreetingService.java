package com.ashwin.service;

import com.ashwin.mapper.GreetingMapper;
import com.ashwin.model.Greeting;
import com.ashwin.repository.MessageRepository;

import javax.inject.Inject;

public class GreetingService {
    @Inject
    private MessageRepository messageRepository;

    public Greeting generateGreeting(String name) {
        String message = messageRepository.fetchAny();
        return GreetingMapper.toGreeting(message, name);
    }
}
