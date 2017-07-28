package com.acolina.server.controller;

import com.acolina.server.dto.Message;
import com.acolina.server.dto.OutputMessage;
import java.util.Date;

import org.springframework.messaging.handler.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.logging.Logger;

@Controller
@RequestMapping("/")
public class ChatController {

    private static final Logger LOG = Logger.getLogger(ChatController.class.getName());

    @RequestMapping(method = RequestMethod.GET)
    public String viewApplication() {
        return "index";
    }

    @MessageMapping("/chat")
    @SendTo("/topic/message")
    public OutputMessage sendMessage(Message message) {
        LOG.info("Message sent");
        return new OutputMessage(message, new Date());
    }
}
