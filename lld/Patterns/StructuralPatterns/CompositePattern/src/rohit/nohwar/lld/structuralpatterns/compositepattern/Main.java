package rohit.nohwar.lld.structuralpatterns.compositepattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        AbstractFile bf1 = new BinaryFile("bf1");
        AbstractFile bf2 = new BinaryFile("bf2");
        AbstractFile bf3 = new BinaryFile("bf3");
        AbstractFile bf4 = new BinaryFile("bf4");

        AbstractFile d1 = new Directory("d1");
        AbstractFile d2 = new Directory("d2");

        d1.addFile(d2);
        d2.addFile(bf1);
        d2.addFile(bf2);
        d1.addFile(bf3);
        d1.addFile(bf4);

        System.out.println(d1.getChildren());
        System.out.println(d2.getChildren());

        d1.deleteFile(d2);
        System.out.println(d1.getChildren());
    }
}