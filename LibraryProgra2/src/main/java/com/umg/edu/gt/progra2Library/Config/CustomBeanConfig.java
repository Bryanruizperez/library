package com.umg.edu.gt.progra2Library.Config;

import com.umg.edu.gt.progra2Library.Service.NotificationService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomBeanConfig {
    @Bean
    public NotificationService notificationService() {
        return new NotificationService();
    }
}
