package Stack;

public interface Stack<T> {
    T pop();
    void push(T value);
    int size();
    T peek();
}
