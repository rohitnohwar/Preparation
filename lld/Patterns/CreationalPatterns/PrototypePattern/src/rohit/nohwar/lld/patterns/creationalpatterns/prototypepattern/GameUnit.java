package rohit.nohwar.lld.patterns.creationalpatterns.prototypepattern;

import java.io.*;

public abstract class GameUnit implements Cloneable, Serializable {
    public String copyType;
    public GameUnit(String copyType) {
        this.copyType = copyType;
    }
    @Override
    public GameUnit clone() throws CloneNotSupportedException {
        if (copyType.equals("shallow")) {
            return (GameUnit) super.clone();
        }
        else {
            try {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                ObjectOutputStream oos = new ObjectOutputStream(baos);
                oos.writeObject(this);

                ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
                ObjectInputStream ois = new ObjectInputStream(bais);
                return (GameUnit) ois.readObject();
            } catch (IOException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
