package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.gcp;

import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.StorageInterface;

public class GcpStorage implements StorageInterface {
    private int capacity;
    public GcpStorage(int capacity) {
        this.capacity = capacity;
    }

    @Override
    public int getCapacity() {
        return this.capacity;
    }
}
