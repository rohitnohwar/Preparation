package rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern;

import rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern.message.AbstractMessage;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern.message.JsonMessage;

public class JsonMessageFactory extends AbstractMessageFactory{
    public AbstractMessage createMessage() {
        return new JsonMessage();
    }
}
