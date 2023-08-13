package rohit.nohwar.lld.patterns.creationalpatterns.factorypattern.abstractfactorypattern;

public interface InstanceInterface {
    //Map capacity to GCP compute instance types. Use GCP API to provision
    enum Capacity{
        micro,
        small,
        large
    }
    public void attachStorage(StorageInterface storage);

    Capacity getCapacity();
}
