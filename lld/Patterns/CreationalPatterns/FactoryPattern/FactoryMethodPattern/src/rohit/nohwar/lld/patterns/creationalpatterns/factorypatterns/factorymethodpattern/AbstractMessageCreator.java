package rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern;

import rohit.nohwar.lld.patterns.creationalpatterns.factorypatterns.factorymethodpattern.message.AbstractMessage;

public abstract class AbstractMessageCreator {
    public String getMessage() {
        AbstractMessage message = createMessage();
        message.addHeaders();
        message.encrypt();
        return message.getContent();
    }

    public abstract AbstractMessage createMessage();
}
