package lesson3;

public class HomePriorityQueue<T extends Comparable> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 15;

    public HomePriorityQueue(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Длина очереди не может составлять "+ capacity +" элементов");
        }
        list = (T[]) new Comparable[capacity];
    }

    public HomePriorityQueue() {
        list = (T[]) new Comparable[DEFAULT_CAPACITY];
    }

    public void insert(T item) {
        if (isFull()) {
            throw new StackOverflowError("Очередь переполнена, добавление новых элементов невозможно");
        }
        list[size] = item;
        size++;
        int i = size - 1;
        while (i > 0 && list[i].compareTo(list[i - 1]) < 0) {
            swap(i, i - 1);
            i--;
        }
    }

    public T remove() {
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    public T peek() {
        if (isEmpty()) {
            throw new StackOverflowError("В очереди нет ни одного элемента");
        }
        return list[size - 1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == list.length;
    }

    private void resize(int newSize) {
        T[] tempArr = (T[]) new Object[newSize];
        System.arraycopy(list, 0, tempArr, 0, list.length);
        list = tempArr;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < size ; i++) {
            s+= list[i] +" ";
        }
        return s;
    }

}
