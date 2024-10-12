package com.umg.edu.gt.progra2Library.Service;
import org.apache.log4j.Logger;

public class NotificationService {

    private static final Logger logger = Logger.getLogger(LibroService.class);
    public void sendNotification(String message){
        logger.info("send notification: "+ message);
    }
}
