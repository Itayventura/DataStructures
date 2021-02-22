package Queue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueImplTest {

    private QueueImpl<Integer> queue;

    @BeforeEach
    void setUp() {
        this.queue = new QueueImpl<>(1);
    }

    @Test
    void enqueueDequeue() {
        assertEquals(1, this.queue.peek());
        this.queue.dequeue();
        assertNull(this.queue.peek());
        this.queue.enqueue(2);
        assertEquals(2, this.queue.peek());
        this.queue.enqueue(3);
        assertEquals(2, this.queue.peek());
        this.queue.dequeue();
        assertEquals(3, this.queue.peek());
        this.queue.dequeue();
        assertNull(this.queue.peek());

        this.queue.dequeue();
        assertNull(this.queue.peek());
    }

    @Test
    void size() {
        assertEquals(1, this.queue.size());

        this.queue.enqueue(2);
        assertEquals(2, this.queue.size());

        this.queue.dequeue();
        assertEquals(1, this.queue.size());

        this.queue.dequeue();
        assertEquals(0, this.queue.size());
        
        this.queue.dequeue();
        assertEquals(0, this.queue.size());
    }
}