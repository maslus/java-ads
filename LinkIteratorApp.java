package lesson4;

import java.util.Iterator;

public class LinkIteratorApp {
    public static void main(String[] args) {
        HomeLinkedList<Integer> hll = new HomeLinkedList<>();

        hll.insertFirst(111);
        hll.insertFirst(222);
        hll.insertFirst(333);
        System.out.println(hll);

        hll.insert(0, 444);
//        System.out.println(hll);
//
//        System.out.println(hll.delete(111));
//        System.out.println(hll);
//
//        System.out.println(hll.indexOf(222));
//        System.out.println(hll.contains(444));
//
//        System.out.println(hll.deleteFirst());
//        System.out.println(hll);
//        System.out.println(hll.deleteLast());
        System.out.println(hll);

        hll.insertFirst(555);
        hll.insertFirst(666);

        for (HomeNode node : hll) {
            System.out.print(node.getValue() + ", ");
        }

        System.out.println();

        Iterator<HomeNode<Integer>> iterator = hll.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next().getValue() + ", ");
        }

        System.out.println("\n");

        HomeStack<Integer> homeStack = new HomeStack<>();
        for (int i = 0; i < 20; i++) {
            homeStack.push(i + 1);
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(homeStack.pop() + " ");
        }
//
        System.out.println("\n\nhomeQueue");
        HomeQueue<Integer> homeQueue = new HomeQueue<>();
        for (int i = 0; i < 20; i++) {
            homeQueue.enQueue(i + 1);
        }
        for (int i = 0; i < 20; i++) {
            System.out.print(homeQueue.deQueue() + " ");
        }
        
    }
}
