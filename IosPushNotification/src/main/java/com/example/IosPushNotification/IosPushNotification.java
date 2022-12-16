package com.example.IosPushNotification;

import java.io.File;
import com.eatthepath.pushy.apns.ApnsClient;
import com.eatthepath.pushy.apns.ApnsClientBuilder;
import com.eatthepath.pushy.apns.PushNotificationResponse;
import com.eatthepath.pushy.apns.util.ApnsPayloadBuilder;
import com.eatthepath.pushy.apns.util.SimpleApnsPayloadBuilder;
import com.eatthepath.pushy.apns.util.SimpleApnsPushNotification;
import com.eatthepath.pushy.apns.util.TokenUtil;
import com.eatthepath.pushy.apns.util.concurrent.PushNotificationFuture;

class IosPushNotification {

	public void iOSPush() {
		try {
			/*
			 * File file = new
			 * File("src/main/resources/static/certificates/Certificates.p12");
			 * System.out.println(file.exists());
			 */
			final ApnsClient apnsClient = new ApnsClientBuilder().setApnsServer(ApnsClientBuilder.DEVELOPMENT_APNS_HOST)
					.setClientCredentials(new File("src/main/resources/static/certificates/Certificates.p12"),
							"cachatto123%")
					.build();
			
			final PushNotificationFuture<SimpleApnsPushNotification, PushNotificationResponse<SimpleApnsPushNotification>> sendNotificationFuture = apnsClient
					.sendNotification(pushNotification);

//			final Future<Void> connectFuture = apnsClient.connect(ApnsClientBuilder.DEVELOPMENT_APNS_HOST);
//			connectFuture.await();

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Inside catch");
		} 
		

	}

	final SimpleApnsPushNotification pushNotification ;

	{
		final ApnsPayloadBuilder payloadBuilder = new SimpleApnsPayloadBuilder();
		payloadBuilder.setAlertBody("swagatam");

		final String payload = payloadBuilder.build();
		final String token = TokenUtil.sanitizeTokenString("<836c69133d57660e9936b2aacd3c5369dc9e988ce4f2664f5910fbfda34e6d44>");

		pushNotification = new SimpleApnsPushNotification(token, "com.DeviceTokenGen", payload);
	}

}
