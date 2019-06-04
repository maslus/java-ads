package lesson2;

public class MyHomeArr {
    private int[] arr;
    private int size;

    public MyHomeArr(int size) {
        this.size = 0;
        this.arr = new int[size];
    }

    public void delete(int value){
        int i=0;
        for (i = 0; i < this.size; i++) {
            if (this.arr[i]==value){
                break;
            }
            
        }
        for (int j = i; j < this.size-1; j++) {
            this.arr[j]=this.arr[j+1];
        }
        this.arr[this.size-1]=0;
        this.size--;
    }

    public void insert (int value){
        this.arr[this.size]=value;
        this.size++;
    }

    public void find (int value){  // не учтена вероятность того, что искомое число встречается несколько раз
        for (int i = 0; i < this.size; i++) {
            if (this.arr[i]==value){
                System.out.println("Искомое число " + value+ " имеет индекс " + i);
                break;
            }
        }
        System.out.println("Числа " + value+" нет в массиве");;
    }

    public void display(){
        for(int i=0;i<this.size;i++){
            System.out.print(this.arr[i]+" ");
        }
    }

    private boolean less(int a, int b) {
        return (a<b);
    }

    private void swap(int index1, int index2) {
        int temp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = temp;
    }

    public void selectionSort() {
        for (int i = 0; i < size - 1; i++) {
            int iMin = i;
            for (int j = i + 1; j < size; j++) {
                if (less(arr[j], arr[iMin])) {
                    iMin = j;
                }
            }
            swap(i, iMin);
        }
    }

    public void insertionSort() {
        int key;
        for (int i = 0; i < size; i++) {
            int j = i;
            key = arr[i];
            while (j > 0 && less(key, arr[j - 1])) {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = key;
        }
    }

    public void bubbleSort() {
        boolean isSwap;
        for (int i = size - 1; i > 0; i--) {
            isSwap = false;
            for (int j = 0; j < i; j++) {
                if (less(arr[j + 1], arr[j])) {
                    swap(j, j + 1);
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
        }
    }

}
