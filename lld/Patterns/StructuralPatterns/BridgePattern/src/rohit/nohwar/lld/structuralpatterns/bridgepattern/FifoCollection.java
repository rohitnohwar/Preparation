package rohit.nohwar.lld.structuralpatterns.bridgepattern;

public interface FifoCollection<T> {
    void addLast(T element);
    void removeFirst();
}
