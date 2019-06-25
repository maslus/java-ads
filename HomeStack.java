package lesson4;

public class HomeStack<T> {
    private HomeLinkedList<T> homeStack = new HomeLinkedList<>();

    public void push(T value){
        homeStack.insertFirst(value);
    }

    public T pop(){
        return homeStack.deleteFirst();
    }

    public T peek(){
        return homeStack.getFirst();
    }

    public int size(){
        return homeStack.size();
    }

    public boolean isEmpty(){
        return homeStack.isEmpty();
    }


}

