import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class DelayedWorker implements Delayed {
    private final long duration;
    private String m;

    public DelayedWorker(long duration, String m) {
        this.m = m;
        this.duration = System.currentTimeMillis() + duration;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return duration - System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed other) {
        long comparedTo = ((DelayedWorker) other).getDuration();
        if (duration < comparedTo) return -1;
        else if (duration > comparedTo) return +1;
        return 0;
    }

    public long getDuration() {
        return duration;
    }

    public String toString() {
        return m;
    }
}
public class Main {
    public static void main(String[] args) throws InterruptedException {
        DelayedWorker d1 = new DelayedWorker(2000, "sdfgh");
        DelayedWorker d2 = new DelayedWorker(3000, "sdfghbjn");

        BlockingQueue<DelayedWorker> q = new DelayQueue<>();

        q.add(d1);
        q.add(d2);

        while(!q.isEmpty()) System.out.println(q.take());
    }
}