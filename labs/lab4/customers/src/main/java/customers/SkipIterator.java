package customers;

import java.util.Iterator;
import java.util.List;

public class SkipIterator<T> implements Iterator<T>{
	private final List<T> list;
    private int position;

    public SkipIterator(List<T> list) {
        this.list = list;
        this.position = 0;
    }

    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return position <= list.size();
    }

    @Override
    public T next() {
        int currentPosition = position;
        position += 2;
        return list.get(currentPosition);
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
