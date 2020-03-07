package customers;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class AgeIterator<T> implements Iterator<T>{
	private final List<T> list;
    private int position;
    private Comparator comparator;

    public AgeIterator(List<T> list, Comparator<T> comparator) {
            this.list = list;
            this.position = 0;
            this.comparator = comparator;
    }

    public Iterator<T> iterator() {
        return this;
    }

    @Override
    public boolean hasNext() {
        return list.size() > 0;
    }

    @Override
    public T next() {
        T lowest = (T) list.stream().sorted(comparator).findFirst().get();
        list.remove(lowest);
        return lowest;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
