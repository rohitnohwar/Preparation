package rohit.nohwar.lld.patterns.creationalpatterns.singleton.eagersingleton;

public class EagerRegistry {

    private EagerRegistry() {

    }

    private static final EagerRegistry INSTANCE = new EagerRegistry();

    public static  EagerRegistry getInstance() {
        return INSTANCE;
    }
}
