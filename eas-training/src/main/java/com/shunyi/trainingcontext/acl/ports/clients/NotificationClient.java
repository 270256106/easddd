package com.shunyi.trainingcontext.acl.ports.clients;

import com.shunyi.trainingcontext.domain.notification.Notification;

/**
 * @author zhang
 */
public interface NotificationClient {
    void send(Notification notification);
}
