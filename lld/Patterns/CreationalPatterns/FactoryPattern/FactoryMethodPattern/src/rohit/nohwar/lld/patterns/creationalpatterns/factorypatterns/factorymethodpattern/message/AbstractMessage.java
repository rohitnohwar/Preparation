package rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern.message;

public abstract class AbstractMessage {
    public abstract String getContent();
    public void addHeaders(){
        // Adding headers
    }
    public void encrypt(){
        //Adding encryption
    }
}
