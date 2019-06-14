package lesson2;

//1. Создать массив большого размера (миллион элементов).
//        2. Написать методы удаления, добавления, поиска элемента массива.
//        3. Заполнить массив случайными числами.
//        4. Написать методы, реализующие рассмотренные виды сортировок, и проверить скорость выполнения каждой.

import java.util.Random;

public class MyHomeWork2 {

    public static void main(String[] args) {
        Random rand = new Random();
        int homeSize = 1000000;
        MyHomeArr myBigArr = new MyHomeArr(homeSize);

        for (int i = 0; i < homeSize-1; i++) {
            myBigArr.insert(rand.nextInt(50000));
        }

//        myBigArr.display();

        System.out.println();

        double timeBegin = System.nanoTime();
        myBigArr.selectionSort();
//        myBigArr.insertionSort();
//        myBigArr.bubbleSort();
        double timeEnd = System.nanoTime();

        System.out.println("Числа отсортированы по возрастанию");
        System.out.println("Время сортировки: "+ (timeEnd-timeBegin));
//        myBigArr.display();
    }


}
