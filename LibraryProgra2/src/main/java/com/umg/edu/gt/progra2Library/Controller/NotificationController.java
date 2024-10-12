package com.umg.edu.gt.progra2Library.Controller;

import com.umg.edu.gt.progra2Library.Service.NotificationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class NotificationController {
    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService){
        this.notificationService =notificationService;
    }
    @GetMapping("/sendNotification")
    public String sendNotication(){
        notificationService.sendNotification("Hola este es un mensaje");
        return "mensaje enviado";
    }

}
