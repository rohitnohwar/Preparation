package rohit.nohwar.lld.structuralpatterns.proxypattern;

public class Image implements ImageInteface{
    String name;
    boolean allowedToBeShown;

    public Image(String name, boolean allowedToBeShown) {
        this.name = name;
        this.allowedToBeShown = allowedToBeShown;
    }

    public void printName() {
        System.out.println("Name is " + name);
    }

    public void showImage() {
        System.out.println("Showing image");
    }
}
