package LinkedList;

public class LinkedListImpl<T> extends AbstractLinkedList<T> {

    public LinkedListImpl(T value) {
        super(value);
    }

    public void remove(T value){
        if(this.head != null){
            Node<T> node = this.head;
            while(node.next != null){
                if(node.next.value == value){
                    node.next = node.next.next;
                    size--;
                    return;
                }
                node = node.next;
            }
        }
    }
}
