package com.shunyi.ddd.core.gateway.acl.port;


import com.shunyi.ddd.core.event.Event;

/**
 * @author zhang
 * @create 2021-01-13 16:57
 */
public interface EventPublisher<T extends Event> {
    void publish(T event);
}