package com.project.photographer.services;

import com.project.photographer.models.Message;
import com.project.photographer.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;
    public Message createMessage(Message createdData){
        Message messageToCreate = new Message();
        messageToCreate.setMessage(createdData.getMessage());
        messageToCreate.setEmail(createdData.getEmail());
        return messageRepo.save(messageToCreate);
    }
}
