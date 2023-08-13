package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.gcp;

import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.AbstractFactoryInterface;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.InstanceInterface;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.StorageInterface;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.aws.AwsInstance;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.aws.AwsStorage;

public class GcpFactory implements AbstractFactoryInterface {
    public InstanceInterface createInstance(InstanceInterface.Capacity capacity) {
        return new GcpInstance(capacity);
    }

    @Override
    public StorageInterface createStorage(int capacity) {
        return new GcpStorage(capacity);
    }
}
