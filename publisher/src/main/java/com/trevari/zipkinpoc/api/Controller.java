package com.trevari.zipkinpoc.api;

import com.trevari.zipkinpoc.publish.Publisher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message")
public class Controller {

    private final Logger logger = LoggerFactory.getLogger(Controller.class);
    private final Publisher publisher;

    public Controller(Publisher publisher) {
        this.publisher = publisher;
    }

    @PostMapping
    public void sendMessage(@RequestBody String message) {
        logger.info("New message : " + message);

        publisher.send(message);
    }
}