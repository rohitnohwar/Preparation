package com.message.broker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Topic {
    String name;
    List<Message> messages;
    Map<String, Server> subscribers;

    public Topic(String name) {
        this.name = name;
        this.subscribers = new HashMap<>();
        this.messages = new ArrayList<>();
    }

    public void addSubscribers(Server server) {
        this.subscribers.put(server.getName(), server);
    }

    public void publish(Message message) {
        Topic topic = this;
        messages.add(message);
        for (Map.Entry<String, Server> s: subscribers.entrySet()) {
            Thread thread = new Thread() {
                public void run() {
                    s.getValue().receiveMessage(message, topic);
                }
            };

            thread.run();
        }
    }

    public void replayFromIndex(int index) {
        for (int i = index; i < messages.size(); i++) {
            Topic topic = this;
            for (Map.Entry<String, Server> s: subscribers.entrySet()) {
                int finalI = i;
                Thread thread = new Thread() {
                    public void run() {
                        s.getValue().receiveMessage(messages.get(finalI), topic);
                    }
                };

                thread.run();
            }
        }
    }
}
