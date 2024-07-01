package a;

public class Class1<T, U> extends Class {
    T i;

    public Class1(T i) {
        this.i = i;
        System.out.println(i);
        System.out.println(super.i);
    }

    public void k() {
        System.out.println(this.i);
        System.out.println(super.i);
    }



    public Class1() {
//        super();
//this.i = i;
        Integer j = 3;
    }

    private static final int[] j = new int[]{1, 3};
    public void a() {
        System.out.println(i);
    }

}
