package LinkedList;

public abstract class AbstractLinkedList<T> implements LinkedList<T> {


    protected Node<T> head;
    protected int size;

    public AbstractLinkedList(T value){
        this.head = new Node<>(value);
        this.size = 1;
    }

    @Override
    public T getFirst(){
        return this.head == null? null: this.head.value;
    }

    @Override
    public void addFirst(T value){
        Node<T> node = new Node<>(value);
        node.next = this.head;
        this.head = node;
        this.size++;
    }

    @Override
    public T removeFirst(){
        Node<T> node = this.head;
        if (this.head != null) {
            this.head = this.head.next;
            this.size--;
        }
        return node == null? null: node.value;
    }

    @Override
    public int size(){
        return this.size;
    }
}
