package rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern;

import rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern.message.AbstractMessage;

public abstract class AbstractMessageCreator {
    public AbstractMessage getMessage() {
        AbstractMessage message = createMessage();
        message.addHeaders();
        message.encrypt();
        return message;
    }

    public abstract AbstractMessage createMessage();
}
