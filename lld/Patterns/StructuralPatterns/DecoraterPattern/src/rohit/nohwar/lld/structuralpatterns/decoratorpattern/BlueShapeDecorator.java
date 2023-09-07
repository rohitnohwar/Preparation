package rohit.nohwar.lld.structuralpatterns.decoratorpattern;

public class BlueShapeDecorator extends AbstractShapeDecorator{
    BlueShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        shape.draw();
        System.out.println("with blue border");
    }
}
