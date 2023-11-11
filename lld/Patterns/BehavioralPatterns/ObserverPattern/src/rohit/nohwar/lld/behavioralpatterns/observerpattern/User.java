package rohit.nohwar.lld.behavioralpatterns.observerpattern;

public class User implements UserInterface{
    String name;

    public User(String name) {
        this.name = name;
    }

    public void sendNotification(YoutubeChannel youtubeChannel, String event) {
        System.out.println(youtubeChannel.getName() + " " + "sent this notification:- " + event);
    }
}
