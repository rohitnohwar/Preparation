package rohit.nohwar.lld.structuralpatterns.facadepattern;

import rohit.nohwar.lld.structuralpatterns.facadepattern.shapes.*;

public class ShapeDrawingFacade {
    private ShapeInterface circle;
    private ShapeInterface square;
    private ShapeInterface rectangle;
    private ShapeInterface triangle;

    public ShapeDrawingFacade() {
        circle = new Circle();
        square = new Square();
        rectangle = new Rectangle();
        triangle = new Triangle();
    }

    public void drawAll() {
        circle.draw();
        square.draw();
        rectangle.draw();
        triangle.draw();
    }

    public void drawParticularShape(String shape) {
        if(shape.equals("circle")) {
            circle.draw();
        }
        else if(shape.equals("square")) {
            square.draw();
        }
        else if(shape.equals("rectangle")) {
            rectangle.draw();
        }
        else if(shape.equals("triangle")) {
            triangle.draw();
        }
    }
}
