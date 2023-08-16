package rohit.nohwar.lld.patterns.creationalpatterns.singleton.serializablepreventionsingleton;

import java.io.Serializable;

public class SerializablePreventionSingleton implements Serializable {
    private static final SerializablePreventionSingleton instance = new SerializablePreventionSingleton();
    private SerializablePreventionSingleton() {

    }

    public static SerializablePreventionSingleton getInstance() {
        return instance;
    }

    public Object readResolve() {
        return instance;
    }
}
