package tech.insight.set;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class HistorySet<E> implements Set<E> {


    public HistorySet(Set<E> hashSet) {
        this.delegate = hashSet;
    }

    List<E> removeList = new ArrayList<>();

    private final Set<E> delegate;


    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return delegate.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return delegate.add(e);
    }

    @Override
    public boolean remove(Object o) {
        if (delegate.remove(o)) {
            removeList.add((E) o);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    @Override
    public String toString() {
        return delegate.toString() + " remove list : " + removeList;
    }
}
