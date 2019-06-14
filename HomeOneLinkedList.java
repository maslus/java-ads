package lesson4;

public class HomeOneLinkedList<T> {
    private HomeNode first;
    private int size = 0;

    public HomeOneLinkedList() {
        this.first = null;
    }

    public void insertFirst(T item) {
        HomeNode newHomeNode = new HomeNode(item);
        newHomeNode.setNext(first);
        first = newHomeNode;
        size++;
    }

    public T deleteFirst() {
        if (isEmpty()) {
            return null;
        }
        HomeNode oldFirst = first;
        first = first.getNext();
        size--;
        return (T) oldFirst.getValue();
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

    public void insert(int index, T item){
        if(index <= 0){
            insertFirst(item);
            return;
        }
        HomeNode current = first;
        int i = 0;
        if(index>size){
            index = size;
        }
        while(i < index -1){
            current = current.getNext();
            i++;
        }
        HomeNode newHomeNode = new HomeNode(item);
        newHomeNode.setNext(current.getNext());
        current.setNext(newHomeNode);
        size++;
    }

    public boolean delete(T item){
        if(isEmpty()){
            return false;
        }
        if(first.getValue().equals(item)){
            deleteFirst();
            return true;
        }
        HomeNode current = first;
        while(current.getNext() != null &&
                !current.getNext().getValue().equals(item)){
            current = current.getNext();
        }
        if(current.getNext() == null){
            return false;
        }
        current.setNext(current.getNext().getNext());
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
