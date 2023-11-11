package rohit.nohwar.lld.behavioralpatterns.observerpattern;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class YoutubeChannel {
    String name;
    Set<User> subscribers;

    public YoutubeChannel(String name) {
        this.name = name;
        this.subscribers = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public void addSubscriber(User user) {
        this.subscribers.add(user);
    }

    public void removeSubscriber(User user) {
        if (subscribers.contains(user)) this.subscribers.remove(user);
    }

    public void notifyUsers(String event) {
        for (User user: this.subscribers) {
            user.sendNotification(this, event);
        }
    }
}
