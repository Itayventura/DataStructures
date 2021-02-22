package Queue;

import LinkedList.LinkedListWithTail;

public class QueueImpl<T> implements Queue<T>{

    private LinkedListWithTail<T> queue;

    public QueueImpl(T value){
        this.queue = new LinkedListWithTail<>(value);
    }

    @Override
    public void enqueue(T value) {
        this.queue.addLast(value);
    }

    @Override
    public T dequeue() {
        return this.queue.removeFirst();
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public T peek() {
        return this.queue.getFirst();
    }
}
