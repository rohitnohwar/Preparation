package a;

public class Class2<T> extends Class1<T>{
    T i;

    public Class2(T i) {
        super();
//        super(i);
        if (i instanceof Integer) {
//            i += 1;
        }

//        super.i = 3;

//        super.a() = 3;
    }



    public void b() {
        System.out.println(i);
    }


}
