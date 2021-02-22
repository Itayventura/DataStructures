package Stack;

import LinkedList.*;

public class StackImpl<T> implements Stack<T>{
    private LinkedList<T> stack;

    public StackImpl(T value){
        this.stack = new LinkedListImpl(value);
    }

    @Override
    public T pop() {
        return this.stack.removeFirst();
    }

    @Override
    public void push(T value) {
        this.stack.addFirst(value);
    }

    @Override
    public int size() {
        return this.stack.size();
    }

    @Override
    public T peek() {
        return this.stack.getFirst();
    }
}
