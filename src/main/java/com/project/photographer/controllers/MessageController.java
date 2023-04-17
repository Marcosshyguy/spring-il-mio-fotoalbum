package com.project.photographer.controllers;

import com.project.photographer.services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("messages")
public class MessageController {
    @Autowired
    MessageService messageService;
    @GetMapping
    public String getMessage(Model model){
        model.addAttribute("messages",messageService.getAllMessages());
        return "/messages/index";
    }

    @DeleteMapping("/delete/{id}")
    public String update(@PathVariable Long id){
        messageService.deleteMessage(id);
        return "redirect:/messages";
    }
}
