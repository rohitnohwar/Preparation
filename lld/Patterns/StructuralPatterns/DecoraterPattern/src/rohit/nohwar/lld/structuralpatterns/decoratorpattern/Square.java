package rohit.nohwar.lld.structuralpatterns.decoratorpattern;

public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing square");
    }
}
