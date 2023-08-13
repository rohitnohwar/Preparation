package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern;

public interface AbstractFactoryInterface {
    InstanceInterface createInstance(InstanceInterface.Capacity capacity);
    StorageInterface createStorage(int capacity);
}
