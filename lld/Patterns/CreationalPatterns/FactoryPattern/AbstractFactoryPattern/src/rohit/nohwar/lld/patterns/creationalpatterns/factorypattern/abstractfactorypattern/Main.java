package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern;

import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.aws.AwsFactory;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.aws.AwsInstance;
import rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern.gcp.GcpFactory;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static InstanceInterface getInstance(AbstractFactoryInterface factory, int storageCapacity, InstanceInterface.Capacity instanceCapacity) {
        StorageInterface storage = factory.createStorage(storageCapacity);
        InstanceInterface instance = factory.createInstance(instanceCapacity);

        instance.attachStorage(storage);
        return instance;
    }
    public static void main(String[] args) {
        AbstractFactoryInterface awsFactory = new AwsFactory();
        InstanceInterface awsInstance = getInstance(awsFactory, 20480, InstanceInterface.Capacity.small);

        AbstractFactoryInterface gcpFactory = new GcpFactory();
        InstanceInterface gcpInterface = getInstance(gcpFactory, 20480, InstanceInterface.Capacity.small);
    }
}