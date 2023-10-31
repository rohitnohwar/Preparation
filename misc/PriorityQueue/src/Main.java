import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
class PriorityQueue {
    private List<Integer> list;
    private int size;

    public PriorityQueue() {
        list = new ArrayList<>();
        size = 0;
    }

    private void heapify(int i) {
        int smallest = i;
        int leftChild = (i * 2 ) + 1;
        int rightChild = (i * 2 ) + 2;
        
        if (leftChild < size && list.get(leftChild) < list.get(smallest)) {
            smallest = leftChild;
        }
        if (rightChild < size && list.get(rightChild) < list.get(smallest)) {
            smallest = rightChild;
        }

        if (smallest != i) {
            int temp = list.get(i);
            list.set(i, list.get(smallest));
            list.set(smallest, temp);

            heapify(smallest);
        }
    }

    public void add(int element) {
        list.add(element);
        size++;

        int index = size - 1;

        while (index != 0) {
            if (list.get((index - 1) / 2) > list.get(index)) {
                int temp = list.get(index);
                list.set(index, list.get((index - 1) / 2));
                list.set((index - 1) / 2, temp);

                index = (index - 1) / 2;
            }
            else {
                break;
            }
        }
    }

    public int remove() {
        int temp = list.get(0);
        list.set(0, list.get(size - 1));
        list.set(size - 1, temp);

        list.remove(size - 1);
        size--;

        heapify(0);

        return temp;
    }

    public int peek() {
        return list.get(0);
    }

    public int size() {
        return size;
    }

    public List<Integer> getList() {
        return list;
    }
}

public class Main {
    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        pq.add(94);
        pq.add(44);
        pq.add(99);
        pq.add(3);
        pq.add(1);
        pq.add(2);
        System.out.println(pq.getList());
        pq.remove();
        System.out.println(pq.getList());
    }
}