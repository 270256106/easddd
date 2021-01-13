package com.shunyi.trainingcontext.acl.adapters.clients;

import com.shunyi.trainingcontext.acl.ports.clients.NotificationClient;
import com.shunyi.trainingcontext.domain.notification.Notification;
import org.springframework.stereotype.Component;

/**
 * @author zhang
 * @create 2021-01-12 16:18
 */
@Component
public class NotificationClientImpl implements NotificationClient {
    @Override
    public void send(Notification notification) {
        System.out.println("send the notification");
    }
}