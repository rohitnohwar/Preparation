package rohit.nohwar.lld.patterns.creationalpatterns.singleton.serializablepreventionsingleton;

import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        SerializablePreventionSingleton instance1 = SerializablePreventionSingleton.getInstance();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(baos);
        oos.writeObject(instance1);

        ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bais);
        SerializablePreventionSingleton instance2 = (SerializablePreventionSingleton) ois.readObject();

        System.out.println("Hashcode of instance1:- " + instance1.hashCode());
        System.out.println("Hashcode of instance2:- " + instance2.hashCode());
        System.out.println(instance1.hashCode() == instance2.hashCode());
    }
}