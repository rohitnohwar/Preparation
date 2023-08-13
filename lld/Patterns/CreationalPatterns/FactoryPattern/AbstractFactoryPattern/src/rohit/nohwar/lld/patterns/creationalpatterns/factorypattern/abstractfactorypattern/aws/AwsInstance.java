package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.aws;

import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.InstanceInterface;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.StorageInterface;

public class AwsInstance implements InstanceInterface{
    private InstanceInterface.Capacity capacity;
    private StorageInterface storageInterface;

    public AwsInstance(InstanceInterface.Capacity capacity) {
        this.capacity = capacity;
    }

    @Override
    public void attachStorage(StorageInterface storage) {
        this.storageInterface = storage;
        System.out.println("Storage attached to awsInstance");
    }

    @Override
    public InstanceInterface.Capacity getCapacity() {
        return this.capacity;
    }
}
