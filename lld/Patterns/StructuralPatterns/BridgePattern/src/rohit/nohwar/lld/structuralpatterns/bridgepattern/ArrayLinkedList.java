package rohit.nohwar.lld.structuralpatterns.bridgepattern;

public class ArrayLinkedList<T> implements LinkedList<T>{
    private int DEFAULT_SIZE = 2;
    private Object[] arr = new Object[DEFAULT_SIZE];

    @Override
    public void addFirst(Object element) {

    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public void addLast(Object element) {

    }

    @Override
    public T removeLast() {
        return null;
    }
}
