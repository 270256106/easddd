package com.shunyi.trainingcontext.acl.ports.clients;

import com.shunyi.ddd.core.stereotype.Adapter;
import com.shunyi.ddd.core.stereotype.PortType;
import com.shunyi.trainingcontext.domain.notification.Notification;

/**
 * @author zhang
 */
@Adapter(PortType.Client)
public interface NotificationClient {
    void send(Notification notification);
}
