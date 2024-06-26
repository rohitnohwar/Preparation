package a;

public class Class1<T> extends Class<T> {
    T i;

    public Class1(int i) {
//        super(i);
//this.i = i;
    }

    public Class1() {
        super();
//this.i = i;
    }

    private static final int[] j = new int[]{1, 3};
    public void a() {
        System.out.println(i);
    }

}
