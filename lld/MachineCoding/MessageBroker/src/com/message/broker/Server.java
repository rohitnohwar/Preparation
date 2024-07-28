package com.message.broker;

@lombok.Getter
public class Server {
    private String name;

    private Queue queue;

    public Server(String name, Queue queue) {
        this.name = name;
        this.queue = queue;
    }

    public void sendMessage(Topic topic, Message message) {
        queue.publish(this, topic, message);
    }

    public void receiveMessage(Message message, Topic topic) {
        System.out.println("On topic " + topic.name + ". Message:- " + message.message);
    }
}
