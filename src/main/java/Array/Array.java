package Array;

public interface Array<T> {

    boolean isEmpty();
    String toString();
    int length();
    void set(T value, int index);
    T get(int i);
    T[] getArr();

}
