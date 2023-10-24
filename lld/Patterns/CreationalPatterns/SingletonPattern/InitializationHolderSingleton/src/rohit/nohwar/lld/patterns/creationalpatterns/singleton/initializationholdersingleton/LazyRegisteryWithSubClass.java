package rohit.nohwar.lld.patterns.creationalpatterns.singleton.initializationholdersingleton;

public class LazyRegisteryWithSubClass {
    private LazyRegisteryWithSubClass() {

    }

    private class RegistryHolder {
        private static final LazyRegisteryWithSubClass INSTANCE = new LazyRegisteryWithSubClass();
    }

    public static  LazyRegisteryWithSubClass getInstance() {
        return RegistryHolder.INSTANCE;
    }
}
