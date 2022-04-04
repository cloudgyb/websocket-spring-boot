package com.github.cloudgyb.websocket;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * 消息产生源，使用一个线程来模拟消息的产生，5秒一个消息。
 * 我实现了ApplicationRunner接口，这样项目一旦启动就有消息产生了
 *
 * @author cloudgyb
 * @since 2022/4/4 21:27
 */
@Component
public class MsgSource implements ApplicationRunner {
    private final MyWebSocketHandler myWebSocketHandler;

    public MsgSource(MyWebSocketHandler myWebSocketHandler) {
        this.myWebSocketHandler = myWebSocketHandler;
    }

    @Override
    public void run(ApplicationArguments args) {
        new Thread(() -> {
            while (true) {
                myWebSocketHandler.pushMsg("这是一个消息" + new Date());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
