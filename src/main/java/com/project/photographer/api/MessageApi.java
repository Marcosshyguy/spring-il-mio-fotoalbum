package com.project.photographer.api;

import com.project.photographer.models.Category;
import com.project.photographer.models.Message;
import com.project.photographer.models.Pic;
import com.project.photographer.repositories.MessageRepo;
import com.project.photographer.services.MessageService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping("/api/messages")
public class MessageApi {
    @Autowired
    private MessageService messageService;
    @PostMapping
    public Message createMessage(@Valid @RequestBody Message newMessage){
        return messageService.createMessage(newMessage);
    }

}
