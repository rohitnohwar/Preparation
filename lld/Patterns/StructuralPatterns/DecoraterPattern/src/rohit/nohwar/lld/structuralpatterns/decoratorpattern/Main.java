package rohit.nohwar.lld.structuralpatterns.decoratorpattern;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Shape circle = new Circle();
        AbstractShapeDecorator redShapeDecorator = new RedShapeDecorator(circle);
        circle.draw();
        redShapeDecorator.draw();

        Shape square = new Square();
        AbstractShapeDecorator blueShapeDecorator = new BlueShapeDecorator(square);
        square.draw();
        blueShapeDecorator.draw();
    }
}