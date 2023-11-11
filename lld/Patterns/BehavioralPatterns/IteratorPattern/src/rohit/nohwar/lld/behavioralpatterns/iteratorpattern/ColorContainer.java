package rohit.nohwar.lld.behavioralpatterns.iteratorpattern;

import java.util.List;

public class ColorContainer implements Container {
    String[] colors = new String[] {"RED", "ORANGE", "BLACK", "GREEN", "WHITE"};
    public ColorIterator getIterator() {
        return new ColorIterator();
    }

    private class ColorIterator implements Iterator{
        private int index;
        public boolean hasNext() {
            if (index < colors.length) return true;
            return false;
        }

        public Object next() {
            return colors[index++];
        }
    }
}
