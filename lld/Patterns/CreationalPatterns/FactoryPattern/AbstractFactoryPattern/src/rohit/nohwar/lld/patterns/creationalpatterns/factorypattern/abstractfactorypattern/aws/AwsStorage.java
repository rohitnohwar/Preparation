package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.aws;

import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.InstanceInterface;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.StorageInterface;

public class AwsStorage implements StorageInterface {
    private int capacity;
    public AwsStorage(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }
}
