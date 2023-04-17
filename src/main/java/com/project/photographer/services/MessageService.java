package com.project.photographer.services;

import com.project.photographer.models.Message;
import com.project.photographer.repositories.MessageRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MessageService {
    @Autowired
    private MessageRepo messageRepo;
    public List<Message> getAllMessages(){
        return messageRepo.findAll();
    }

    public Message createMessage(Message createdData){
        Message messageToCreate = new Message();
        messageToCreate.setMessage(createdData.getMessage());
        messageToCreate.setEmail(createdData.getEmail());
        messageToCreate.setCreatedAt(LocalDate.now());
        return messageRepo.save(messageToCreate);
    }

    public void deleteMessage(Long id){
        Message messageToDelete = messageRepo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid message Id: {" + id + "}"));
        messageRepo.delete(messageToDelete);
    }
}
