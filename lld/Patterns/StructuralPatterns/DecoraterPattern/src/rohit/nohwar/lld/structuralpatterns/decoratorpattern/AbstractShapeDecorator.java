package rohit.nohwar.lld.structuralpatterns.decoratorpattern;

public class AbstractShapeDecorator implements Shape{
    Shape shape;

    AbstractShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}
