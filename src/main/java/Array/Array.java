package Array;

public interface Array<T> {

    boolean isSorted();
    boolean isEmpty();
    String toString();
    int length();
    void set(T value, int index);
    void copy(T[] other, int size);
    T get(int i);
    T[] getArr();

}
