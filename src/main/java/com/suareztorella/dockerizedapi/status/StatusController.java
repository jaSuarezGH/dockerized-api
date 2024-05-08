package com.suareztorella.dockerizedapi.status;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
@RequestMapping("/status")
public class StatusController {

    @GetMapping
    public String statusCheck() {
        return "ping";
    }

}