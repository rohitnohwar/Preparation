package rohit.nohwar.lld.patterns.creationalpatterns.prototypepattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws CloneNotSupportedException {
        Soldier s1 = new Soldier("shallow");
        Soldier s2 = (Soldier) s1.clone();

        System.out.println("s1 before:- "+s1.getArr());
        System.out.println("s2 before:- "+s2.getArr());

        s2.arr[0] = 1;

        System.out.println("s1 after:- "+s1.getArr());
        System.out.println("s2 after:- "+s2.getArr());





        Soldier s3 = new Soldier("deep");
        Soldier s4 = (Soldier) s3.clone();

        System.out.println("s3 before:- "+s3.getArr());
        System.out.println("s4 before:- "+s4.getArr());

        s4.arr[0] = 1;

        System.out.println("s3 after:- "+s3.getArr());
        System.out.println("s4 after:- "+s4.getArr());
    }
}