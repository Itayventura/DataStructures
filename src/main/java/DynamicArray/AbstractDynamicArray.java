package DynamicArray;

import Array.Array;

public abstract class AbstractDynamicArray<T extends Comparable<T>> implements DynamicArray<T> {

    Array<T> arr;
    int size;

    AbstractDynamicArray(Array<T> arr){
        this.arr = arr;
        this.size = arr.length();
    }

    @Override
    public void push(T value) {
        if(this.size >= this.arr.length()){
            reSizeArray(this.arr.length() * 2, false);
        }
        this.arr.set(value, size);
        this.size++;
    }

    @Override
    public T pop() {
        if (this.size > 0) {
            T value = this.arr.get(this.size-1);
            this.arr.set(null, --this.size);
            if (this.size < this.arr.length() / 4) {
                reSizeArray(this.arr.length() / 2, true);
            }
            return value;
        }
        return null;
    }

    @Override
    public int size(){
        return this.size;
    }


    protected abstract void reSizeArray(int size, boolean shrink);

    @Override
    public T get(int i){
        return this.arr.get(i);
    }

    @Override
    public void set(T value, int i){
        this.arr.set(value, i);
    }

}
