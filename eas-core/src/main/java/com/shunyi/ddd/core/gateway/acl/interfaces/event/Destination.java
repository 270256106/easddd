package com.shunyi.ddd.core.gateway.acl.interfaces.event;

/**
 * @author zhang
 * @create 2021-01-13 16:57
 */
public class Destination {
    private String host;
    private int port;
    private String topic;

    public Destination(String host, int port, String topic) {
        this.host = host;
        this.port = port;
        this.topic = topic;
    }

    public String server() {
        return String.format("%s%s", host, port);
    }
    public String topic() {
        return topic;
    }
}