package LinkedList;

public interface LinkedList<T> {
    class Node<T>{
        T value;
        Node<T> next;

        Node(T value){
            this.value = value;
            this.next = null;
        }
    }

    void addFirst(T value);
    T removeFirst();
    T getFirst();
    int size();
}
