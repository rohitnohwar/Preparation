package rohit.nohwar.lld.patterns.creationalpatterns.prototypepattern;

public class Cavalry extends GameUnit {
    int arr[] = new int[]{0};

    public Cavalry(String copyType) {
        super(copyType);
    }

    public int getArr() {
        return arr[0];
    }
    public void setArr() {
        this.arr = new int[]{1};
    }

    public GameUnit clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }
}
