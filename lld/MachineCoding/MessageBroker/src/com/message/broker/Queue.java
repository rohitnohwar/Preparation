package com.message.broker;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Queue {
    private class MessageListNode {
        private Message message;
        private Topic topic;

        public MessageListNode(Message message, Topic topic) {
            this.message = message;
            this.topic = topic;
        }
    }
    Map<String, Topic> topics;
    List<MessageListNode> messages;

    public Queue() {
        this.topics = new HashMap<>();
        this.messages = new ArrayList<>();
    }

    public void publish(Server sender, Topic topic, Message message) {
        topics.get(topic).publish(message);
        messages.add(new MessageListNode(message, topic));
    }

    public void replayFromTopicIndex(Topic topic, int index) {
        topic.replayFromIndex(index);
    }

    public void replayFromAbsoluteIndex(int index) {
        for (MessageListNode messageListNode: messages) {
            Topic topic = messageListNode.topic;
            topic.publish(messageListNode.message);
        }
    }
}
