package a;

public class Class2<T extends  Helper> extends Class1{
    T i;

    public Class2(T i) {
        super(6);

        this.i = i;

//        super.a() = 3;
    }



    public void b() {
        System.out.println(i);
    }


}
