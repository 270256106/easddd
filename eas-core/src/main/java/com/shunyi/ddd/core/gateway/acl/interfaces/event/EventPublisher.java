package com.shunyi.ddd.core.gateway.acl.interfaces.event;

import com.shunyi.ddd.core.domain.Event;

/**
 * @author zhang
 * @create 2021-01-13 16:57
 */
public interface EventPublisher<T extends Event> {
    void publish(T event);
}