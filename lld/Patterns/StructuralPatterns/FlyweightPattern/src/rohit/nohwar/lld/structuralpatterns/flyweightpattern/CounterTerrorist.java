package rohit.nohwar.lld.structuralpatterns.flyweightpattern;

public class CounterTerrorist implements Player{
    String weapon;
    @Override
    public void assignWeapon(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public void getMission() {
        System.out.println("Terrorist with weapon " + weapon);
    }
}
