package Array;

import java.util.Random;

public abstract class SortableArray<T extends Comparable<T>> extends AbstractArray<T> implements Sortable {
    static class ArrayFactory<T extends Comparable<T>> {

        public T[] getArray(int size)
        {
            return  (T[]) new Comparable[size];
        }

        public T[] getArrayWithValue(T value){
            T[] arr = getArray(1);
            arr[0] = value;
            return arr;
        }
    }

    SortableArray(T[] arr) {
        super(arr);
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
        T []merged = mergeSort(0, this.length, new ArrayFactory<T>());
        if (length >= 0) {
            System.arraycopy(merged, 0, this.arr, 0, this.length);
        }
    }

    private T[] mergeSort(int start, int end, ArrayFactory<T> factory) {
        int middle = (start + end)/2;
        if (start+1 == end){
            return factory.getArrayWithValue(this.arr[start]);
        } else if (start +1 < end){
            return merge(mergeSort(start, middle, factory), mergeSort(middle, end, factory), factory);
        } else{
            return factory.getArray(0);
        }
    }

    private T[] merge(T[] first, T[] second, ArrayFactory<T> factory) {

        int m = 0;
        int f = 0;
        int s = 0;
        T[] merged = factory.getArray(first.length + second.length);

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



}
