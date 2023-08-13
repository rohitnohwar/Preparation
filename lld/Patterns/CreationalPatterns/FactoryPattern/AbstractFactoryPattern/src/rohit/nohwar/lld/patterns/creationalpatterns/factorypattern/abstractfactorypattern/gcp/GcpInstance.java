package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.gcp;

import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.InstanceInterface;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.StorageInterface;

public class GcpInstance implements InstanceInterface {
    private InstanceInterface.Capacity capacity;
    private StorageInterface storageInterface;

    public GcpInstance(InstanceInterface.Capacity capacity) {
        this.capacity = capacity;
    }

    @Override
    public void attachStorage(StorageInterface storage) {
        this.storageInterface = storage;
        System.out.println("Storage attached to gcpInstance");
    }

    @Override
    public InstanceInterface.Capacity getCapacity() {
        return this.capacity;
    }
}
