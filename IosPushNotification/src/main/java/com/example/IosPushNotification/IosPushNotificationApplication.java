package com.example.IosPushNotification;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IosPushNotificationApplication {

	public static void main(String[] args) {
		SpringApplication.run(IosPushNotificationApplication.class, args);
		
		IosPushNotification iop = new IosPushNotification();
		iop.iOSPush();
	}

}
