package lesson4;

public class HomeNode<T> {
    private T value;
    private HomeNode next;
    private HomeNode previous;

    public HomeNode(T value) {
        this.value = value;
    }

    public HomeNode(T value, HomeNode next) {
        this.value = value;
        this.next = next;
    }

    public HomeNode getPrevious() {
        return previous;
    }

    public void setPrevious(HomeNode previous) {
        this.previous = previous;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public HomeNode getNext() {
        return next;
    }

    public void setNext(HomeNode next) {
        this.next = next;
    }
}
