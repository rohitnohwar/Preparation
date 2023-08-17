package rohit.nohwar.lld.patterns.creationalpatterns.singleton.cloneablepreventionsingleton;

public class CloneablePreventionSingleton implements Cloneable{
    private CloneablePreventionSingleton() {

    }
    private static final CloneablePreventionSingleton instance = new CloneablePreventionSingleton();

    public static CloneablePreventionSingleton getInstance() {
        return instance;
    }

    public CloneablePreventionSingleton clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
