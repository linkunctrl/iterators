package related;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomCollection implements Iterable<String> {
    private String[] items;
    private int count = 0;

    public CustomCollection(int size) {
        items = new String[size];
    }

    public void add(String item) {
        if (count < items.length) {
            items[count++] = item;
        } else {
            System.out.println("Collection is full.");
        }
    }

    public void removeAtIndex(int index){
        if (index < 0  || index >= count){
            throw new IndexOutOfBoundsException("Index out of bounds.");
        }
        for ( int i = index -1 ; i < count - 1; i++){
            items[i] = items[i+1];
        }
        items[--count] = null; // Clear the last element
    }

    @Override
    public Iterator<String> iterator() {
        return new CustomIterator();
    }

    private class CustomIterator implements Iterator<String> {
        private int index = 0;

        @Override
        public boolean hasNext() {
            return index < count;
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[index++];
        }

        @Override
        public void remove() {
            if (index <= 0) {
                throw new IllegalStateException("Call next() before remove()");
            }
            for (int i = index - 1; i < count - 1; i++) {
                items[i] = items[i + 1];
            }
            items[--count] = null; // clear the last element
            index--;
        }
    }
}
