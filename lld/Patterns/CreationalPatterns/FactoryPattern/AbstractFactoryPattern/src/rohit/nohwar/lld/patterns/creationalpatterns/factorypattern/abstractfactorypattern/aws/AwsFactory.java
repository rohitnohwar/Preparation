package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.aws;

import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.AbstractFactoryInterface;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.InstanceInterface;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.StorageInterface;

public class AwsFactory implements AbstractFactoryInterface {

    @Override
    public InstanceInterface createInstance(InstanceInterface.Capacity capacity) {
        return new AwsInstance(capacity);
    }

    @Override
    public StorageInterface createStorage(int capacity) {
        return new AwsStorage(capacity);
    }
}
