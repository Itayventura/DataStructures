package DynamicArray;

import Array.Array;

public interface DynamicArray<T extends Comparable<T>> {

    void push(T value);
    T pop();
    int size();
    T get(int i);
    void set(T value, int index);
    Array<T> getArr();
}