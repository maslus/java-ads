package lesson3;

public class HomeDeque<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 20;
    private int begin = 0;
    private int end = 0;

    public HomeDeque(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Длина дека не может составлять " + capacity + " элементов");
        }
        list = (T[]) new Object[capacity];
    }

    public HomeDeque() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void insertRight(T item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        list[end] = item;
        end = nextIndex(end);
    }

    public void insertLeft(T item) {
        if (isFull()) {
            throw new StackOverflowError();
        }
        size++;
        for (int i = end; i > begin; i--) {
            list[i] = list[i - 1];
        }
        list[begin] = item;
        end = nextIndex(end);
    }

    public T removeLeft() {
        T value = peek();
        size--;
        list[begin] = null;
        begin = nextIndex(begin);
        return value;
    }

   public T removeRight() {
        if (isEmpty()) {
            throw new StackOverflowError("Дек пустой, нет элементов");
        }
       T temp = peekRight();
       size--;
       list[size] = null;
       return temp;
    }

    public T peek() {
        if (isEmpty()) {
            throw new StackOverflowError("Дек пуст, элементы отсутствуют");
        }
        return list[begin];
    }

    public T peekRight() {
        if (isEmpty()) {
            throw new StackOverflowError("Дек пуст, элементы отсутствуют");
        }
        return list[end];
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

    private int nextIndex(int index) {
        return (index + 1) % list.length;
    }

    @Override
    public String toString() {
        String s = "";
        for (int i = 0; i < list.length; i++) {
            s += list[i] + " ";
        }
        return s;
    }
}
