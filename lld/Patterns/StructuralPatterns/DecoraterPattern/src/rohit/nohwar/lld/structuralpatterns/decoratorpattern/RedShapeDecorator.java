package rohit.nohwar.lld.structuralpatterns.decoratorpattern;

public class RedShapeDecorator extends AbstractShapeDecorator{
    RedShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        System.out.println("with red border");
    }
}
