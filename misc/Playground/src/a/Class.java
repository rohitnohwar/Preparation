package a;

public class Class<T> {

    T i;

    static class a {
        private static int b;

        static class v {
            private v() {

            }
            private int q;
        }
    }

    public Class(T i) {
        this.i = i;
    }

    void b() {
        a.b = 1;
        a.v w = new a.v();
    }
}
