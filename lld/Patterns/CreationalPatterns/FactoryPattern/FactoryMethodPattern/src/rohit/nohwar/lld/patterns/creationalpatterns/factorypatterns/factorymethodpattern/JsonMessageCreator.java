package rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern;

import rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern.message.AbstractMessage;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern.message.JsonMessage;

public class JsonMessageCreator extends AbstractMessageCreator{
    public AbstractMessage createMessage() {
        return new JsonMessage();
    }
}
