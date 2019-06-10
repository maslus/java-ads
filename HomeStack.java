package lesson3;

public class HomeStack<T> {
    private T[] list;
    private int size = 0;
    private final int DEFAULT_CAPACITY = 15;

    public HomeStack(int capacity) {
        if(capacity <=0 ){
            throw new IllegalArgumentException("Длина стека не может равняться "+ capacity);
        }
        list = (T[]) new Object[capacity];
    }

    public HomeStack() {
        list = (T[]) new Object[DEFAULT_CAPACITY];
    }

    public void push(T item){
        if(isFull()){
            throw new StackOverflowError("Стек переполнен, добавление невозможно");
        }
        list[size] = item;
        size++;
    }

    public T pop(){
        T temp = peek();
        size--;
        list[size] = null;
        return temp;
    }

    public T peek(){
        if (isEmpty()){
            throw new StackOverflowError("Пустой стек, нет элементов для работы с ними");
        }
        return list[size-1];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == list.length;
    }

    private void resize(int newSize){
        T[] tempArr = (T[]) new Object[newSize];
        System.arraycopy(list,0,tempArr,0,list.length);
        list = tempArr;
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

