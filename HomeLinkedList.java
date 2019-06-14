package lesson4;

import java.util.Iterator;

public class HomeLinkedList<T> implements Iterable<HomeNode<T>>{
    private HomeNode first;
    private HomeNode last;
    private int size = 0;

    public HomeLinkedList() {
        first = null;
        last = null;
    }

    @Override
    public Iterator<HomeNode<T>> iterator() {
        return new Iter();
    }

    private class Iter implements Iterator<HomeNode<T>>{
        HomeNode current = new HomeNode(null,first);

        @Override
        public boolean hasNext() {
            return current.getNext() != null;
        }

        @Override
        public HomeNode<T> next() {
            current = current.getNext();
            return current;
        }
    }

    public void insertFirst(T item) {
        HomeNode newHomeNode = new HomeNode(item);
        newHomeNode.setNext(first);
        if (isEmpty()) {
            last = newHomeNode;
        } else {
            first.setPrevious(newHomeNode);
        }
        first = newHomeNode;
        size++;
    }

    public void insertLast(T item) {
        HomeNode newHomeNode = new HomeNode(item);
        if (isEmpty()) {
            first = newHomeNode;
        } else {
            newHomeNode.setPrevious(last);
            last.setNext(newHomeNode);
        }
        last = newHomeNode;
        size++;
    }

    public T deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        HomeNode oldFirst = first;
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        } else {
            first.setPrevious(null);
        }
        size--;
        return (T) oldFirst.getValue();
    }

    public T deleteLast() {
        if (isEmpty()) {
            return null;
        }
        HomeNode oldLast = last;
        if (last.getPrevious() != null) {
            last.getPrevious().setNext(null);
        } else {
            first = null;
        }
        last = last.getPrevious();
        size--;
        return (T) oldLast.getValue();
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int size() {
        return size;
    }

    public T getFirst() {
        if (isEmpty()) {
            return null;
        }
        return (T) first.getValue();
    }

    public T getLast() {
        if (isEmpty()) {
            return null;
        }
        return (T) last.getValue();
    }

    public int indexOf(T item) {
        HomeNode current = first;
        int index = 0;
        while (current != null) {
            if (item.equals(current.getValue())) {
                return index;
            }
            current = current.getNext();
            index++;
        }
        return -1;
    }

    public boolean contains(T item) {
        return indexOf(item) > -1;
    }

    public void insert(int index, T item) {
        if (index <= 0) {
            insertFirst(item);
            return;
        }
        if (index >= size) {
            insertLast(item);
            return;
        }

        HomeNode current = first;
        int i = 0;
        while (i < index - 1) {
            current = current.getNext();
            i++;
        }
        HomeNode newHomeNode = new HomeNode(item);
        newHomeNode.setNext(current.getNext());
        newHomeNode.setPrevious(current);
        newHomeNode.getNext().setPrevious(newHomeNode);
        current.setNext(newHomeNode);
        size++;
    }

    public boolean delete(T item) {
        if (isEmpty()) {
            return false;
        }
        if (first.getValue().equals(item)) {
            deleteFirst();
            return true;
        }
        HomeNode current = first;
        while (current != null &&
                !current.getValue().equals(item)) {
            current = current.getNext();
        }
        if (current == null) {
            return false;
        }
        if (current == last) {
            deleteLast();
            return true;
        }

        current.getPrevious().setNext(current.getNext());
        current.getNext().setPrevious(current.getPrevious());
        size--;
        return true;

    }

    @Override
    public String toString() {
        HomeNode current = first;
        String s = "";
        while (current != null) {
            s += current.getValue() + " ";
            current = current.getNext();
        }
        return s;
    }
}

