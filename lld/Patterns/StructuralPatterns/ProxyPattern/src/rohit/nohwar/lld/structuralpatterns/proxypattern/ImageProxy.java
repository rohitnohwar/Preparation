package rohit.nohwar.lld.structuralpatterns.proxypattern;

public class ImageProxy implements ImageInteface{
    String name;
    Image image;
    boolean allowedToBeShown;

    public ImageProxy(String name, boolean allowedToBeShown) {
        this.name = name;
        this.allowedToBeShown = allowedToBeShown;
    }

    public void printName() {
        if (image == null) {
            image = new Image(name, allowedToBeShown);
        }

        image.printName();
    }

    public void showImage() throws IllegalAccessException {
        if (allowedToBeShown == false) {
            throw new IllegalAccessException();
        }

        if (image == null) {
            image = new Image(name, allowedToBeShown);
        }

        image.showImage();
    }
}
