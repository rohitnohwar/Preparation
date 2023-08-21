package rohit.nohwar.lld.patterns.creationalpatterns.objectpoolpattern;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ObjectPool<T extends Poolable> {
    public Lock l = new ReentrantLock();
    Queue<T> q = new LinkedList<>();

    public ObjectPool(T obj, int quantity) {
        for (int i = 0; i < quantity; i++) {
            q.add(obj);
        }
    }

    public T get() {
        l.lock();
        if(!q.isEmpty()) return q.remove();
        l.unlock();
        return null;
    }

    public void release(T obj) {
        l.lock();
        obj.reset();
        q.add(obj);
        l.unlock();
    }
}
