package Array;

import java.util.Random;

public abstract class AbstractArray<T extends Comparable<T>> implements Array<T>, Sortable {

    private T[] arr;
    private int length;

    AbstractArray(T[] arr){
        this.arr = arr;
        this.length = arr.length;
    }

    @Override
    public T[] getArr(){
        return this.arr;
    }

    @Override
    public boolean isSorted(){
        for(int i = 0; i < this.length-1; i++){
            if (this.arr[i+1].compareTo(this.arr[i]) < 0){
                return false;
            }
        }
        return true;
    }

    @Override
    public int length(){
        return this.length;
    }

    @Override
    public void heapSort(){
        arrayToHeap();
        for(int i = 0; i < this.length-1; i++) {
            swap(0, this.length - 1 - i);
            heapifyDownAfterHeaped(0,i);
        }
        if (this.length > 1 && (this.arr[1].compareTo(this.arr[0])) < 0) {
            swap(0, 1);
        }
    }

    private void heapifyDownAfterHeaped(int start, int i) {
        if (start < this.length/2) {
            int maxChild = getMaxChild(start);
            if (maxChild < this.length - 1 - i && this.arr[start].compareTo(this.arr[maxChild]) < 0) {
                swap(start, maxChild);
                heapifyDownAfterHeaped(maxChild, i);
            }
        }
    }

    private void arrayToHeap() {
        for(int i = length-1; i > 0; i--){
            heapifyUp(i);
        }
    }

    private void heapifyDown(int i) {
        if (i < length/2) {
            int maxChild = getMaxChild(i);
            if (this.arr[i].compareTo(this.arr[maxChild]) < 0) {
                swap(i, maxChild);
                heapifyDown(maxChild);
            }
        }
    }

    private int getMaxChild(int i) {
        return ((this.length&1) == 0 && i == this.length/2 - 1) ||
                ((this.arr[2*i+1].compareTo(this.arr[2*i+2])) >= 0)? 2*i+1: 2*i+2;
    }

    private void heapifyUp(int i) {
        int parent = getParent(i);
        if (this.arr[parent].compareTo(this.arr[i]) < 0){
            swap(parent, i);
            heapifyDown(i);

        }
    }

    private int getParent(int i){
        return (i&1) == 0? i/2 - 1: i/2;
    }


    @Override
    public void mergeSort(){
        T []merged = mergeSort(0, this.length);
        if (length >= 0) {
            System.arraycopy(merged, 0, this.arr, 0, this.length);
        }
    }

    private T[] mergeSort(int start, int end) {
        int middle = (start + end)/2;
        if (start+1 == end){
            return (T[]) new Comparable[]{this.arr[start]};
        } else if (start +1 < end){
            return merge(mergeSort(start, middle), mergeSort(middle, end));
        } else{
            return (T[]) new Comparable[]{};
        }
    }

    private T[] merge(T[] first, T[] second) {

        int m = 0;
        int f = 0;
        int s = 0;
        T[] merged = (T[]) new Comparable[first.length + second.length];

        while(f < first.length && s < second.length){
            merged[m++] = (second[s].compareTo(first[f]) >= 0)? first[f++]:second[s++];
        }

        while(f < first.length){
            merged[m++] = first[f++];
        }

        while(s < second.length){
            merged[m++] = second[s++];
        }

        return merged;

    }

    @Override
    public void insertionSort(){
        for(int i = 1; i < this.length; i++){
            insertIIntoSortedArray(i);
        }
    }

    private void insertIIntoSortedArray(int i){
        for(int j = i; j > 0; j--){
            if(this.arr[j].compareTo(this.arr[j-1]) < 0){
                swap(j-1, j);
            }
        }
    }

    @Override
    public void quickSort(){
        quickSort(0, length);
    }

    private void quickSort(int start, int end) {
        if (end - start <= 1){
            return;
        }
        int range = end - start;
        int pivot = new Random().nextInt(range) + start;
        if(start != pivot) {
            swap(start, pivot);
        }
        pivot = start;
        for(int i = start + 1; i < end; i++){
            if (this.arr[i].compareTo(this.arr[pivot]) < 0){
                if (pivot+1 != i) {
                    swap(pivot + 1, i);
                }
                swap(pivot, pivot+1);
                pivot++;
            }
        }
        quickSort(start, pivot);
        quickSort(pivot+1, end);

    }

    private void swap(int i, int j){
        T temp = this.arr[i];
        this.arr[i] = this.arr[j];
        this.arr[j] = temp;
    }


    @Override
    public boolean isEmpty(){
        return this.length == 0;
    }

    @Override
    public String toString(){
        StringBuilder stringBuilder = new StringBuilder("[");
        for(int i = 0; i < this.length-1; i++){
            stringBuilder.append(this.arr[i] + ", ");
        }
        if (this.length > 0){
            stringBuilder.append(this.arr[this.length-1]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public void set(T value, int index){
        if (index < this.length) {
            this.arr[index] = value;
        }
    }

    @Override
    public T get(int i){
        return this.arr[i];
    }

}

