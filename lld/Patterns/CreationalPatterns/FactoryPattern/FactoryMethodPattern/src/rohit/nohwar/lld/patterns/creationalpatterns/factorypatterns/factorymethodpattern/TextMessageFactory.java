package rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern;

import rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern.message.AbstractMessage;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern.message.JsonMessage;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern.message.TextMessage;

public class TextMessageFactory extends AbstractMessageFactory{
    public AbstractMessage createMessage() {
        return new TextMessage();
    }
}
