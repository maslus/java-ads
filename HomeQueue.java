package lesson4;

import java.util.Iterator;

public class HomeQueue<T> {
    private HomeQueue first;

    private HomeLinkedList<T> homeQueue = new HomeLinkedList<>();

    public void enQueue(T value){
        homeQueue.insertFirst(value);
    }

    public T deQueue(){
        return homeQueue.deleteLast();
    }

    public T peek(){
        return homeQueue.getFirst();
    }

    public int size(){
        return homeQueue.size();
    }

    public boolean isEmpty(){
        return homeQueue.isEmpty();
    }


}