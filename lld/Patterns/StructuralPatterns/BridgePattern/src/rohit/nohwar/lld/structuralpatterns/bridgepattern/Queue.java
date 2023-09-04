package rohit.nohwar.lld.structuralpatterns.bridgepattern;

public class Queue<T> implements FifoCollection<T>{
    private LinkedList<T> linkedList;
    public Queue(LinkedList<T> linkedList) {
        this.linkedList = linkedList;
    }
    @Override
    public void addLast(T element) {

    }

    @Override
    public void removeFirst() {

    }
}
