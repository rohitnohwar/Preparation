package rohit.nohwar.lld.structuralpatterns.bridgepattern;

public class Main {
    public static void main(String[] args) {
        FifoCollection<Integer> queue = new Queue<>(new ArrayLinkedList<Integer>());

        queue.addLast(7);
        queue.removeFirst();
    }
}