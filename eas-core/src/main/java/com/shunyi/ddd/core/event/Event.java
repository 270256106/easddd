package com.shunyi.ddd.core.event;

import java.io.Serializable;

/**
 * @author zhang
 * @create 2021-01-13 10:28
 */
public interface Event extends Serializable {
    String eventId();
}