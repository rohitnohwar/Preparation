package rohit.nohwar.lld.patterns.creationalpatterns.prototypepattern;

import rohit.nohwar.lld.patterns.creationalpatterns.prototypepattern.GameUnit;

public class Soldier extends GameUnit {
    public int arr[] = new int[]{0};

    public Soldier(String copyType) {
        super(copyType);
    }

    public int getArr() {
        return arr[0];
    }
    public void setArr() {
        this.arr = new int[]{1};
    }
}
