package rohit.nohwar.lld.patterns.creationalpatterns.singleton.initializationholdersingleton;

public class LazyRegisteryWithSubClass {
    private LazyRegisteryWithSubClass() {

    }
    private static int q;

    private static class RegistryHolder {
        private static final LazyRegisteryWithSubClass INSTANCE = new LazyRegisteryWithSubClass();
        public void a() {
            q=3;
        }
    }

    public static  LazyRegisteryWithSubClass getInstance() {
        return RegistryHolder.INSTANCE;
    }
}
