package com.github.cloudgyb.websocket.config;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 标注到Handler上，以便自动注册
 *
 * @author cloudgyb
 * @since 2022/4/4 19:11
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface WebSocketEndpoint {
    /**
     * WebSocket 端点路径
     */
    String value();
}
