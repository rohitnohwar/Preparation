package rohit.nohwar.lld.structuralpatterns.proxypattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws IllegalAccessException {
        ImageInteface image1 = new ImageProxy("i1", true);
        ImageInteface image2 = new ImageProxy("i2", false);

        image1.showImage();
        image2.showImage();
    }
}