package com.ashwin.repositoryimpl;

import com.ashwin.repository.MessageRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MessageRepositoryImpl implements MessageRepository {
    private List<String> messages;

    @Inject
    public MessageRepositoryImpl() {
        messages = new ArrayList<>();
        messages.add("Have a great day");
        messages.add("Nice to have you");
        messages.add("Welcome");
        messages.add("Welcome back");
    }

    @Override
    public List<String> fetchAll() {
        return messages;
    }

    @Override
    public String fetchAny() {
        Random random = new Random();
        int i = random.nextInt(messages.size());
        return messages.get(i);
    }
}
