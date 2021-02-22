package LinkedList;

public class LinkedListWithTail<T> implements LinkedList<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedListWithTail(T value) {
        this.head = new Node(value);
        this.tail = this.head;
        this.size = 1;
    }

    @Override
    public void addFirst(T value) {
        Node<T> node = new Node(value);
        node.next = this.head;
        this.head = node;
        if(this.tail == null){
            this.tail = this.head;
        }
         this.size++;
    }

    @Override
    public T removeFirst() {
        if(this.head == null){
            return null;
        } else{
            Node<T> node = this.head;
            this.head = this.head.next;
            if(this.head == null){
                this.tail = null;
            }
            size--;
            return node.value;
        }
    }

    @Override
    public T getFirst() {
        return this.head == null? null: this.head.value;
    }

    @Override
    public int size() {
        return this.size;
    }

    public T getLast(){
        return this.tail == null? null: this.tail.value;
    }

    public void addLast(T value){
        if (this.tail == null){
            addFirst(value);
        } else{
            Node<T> node = new Node(value);
            this.tail.next = node;
            this.tail = this.tail.next;
            size++;
        }
    }
}
