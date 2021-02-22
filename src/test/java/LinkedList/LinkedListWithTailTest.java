package LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListWithTailTest {

    private static LinkedListWithTail<Integer> linkedList;

    @BeforeEach
    void setUp() {
        linkedList = new LinkedListWithTail<>(1);
    }

    @Test
    void addFirst() {
        assertEquals(1, linkedList.getFirst());

        linkedList.addFirst(2);
        assertEquals(2, linkedList.getFirst());

    }

    @Test
    void removeFirst() {
        assertEquals(1, linkedList.getFirst());

        linkedList.removeFirst();
        assertNull(linkedList.getFirst());

        linkedList.removeFirst();
        assertNull(linkedList.getFirst());
    }

    @Test
    void size() {
        assertEquals(1, linkedList.size());
        linkedList.addFirst(2);
        assertEquals(2, linkedList.size());
        linkedList.removeFirst();
        assertEquals(1, linkedList.size());
        linkedList.removeFirst();
        assertEquals(0, linkedList.size());
        linkedList.removeFirst();
        assertEquals(0, linkedList.size());

    }

    @Test
    void getLast() {
        assertEquals(1, linkedList.getLast());
        linkedList.removeFirst();
        assertNull(linkedList.getLast());
    }

    @Test
    void addLast() {
        assertEquals(1, linkedList.getLast());
        linkedList.addLast(2);
        assertEquals(2, linkedList.getLast());
        linkedList.removeFirst();
        assertEquals(2, linkedList.getLast());
        linkedList.removeFirst();
        assertNull(linkedList.getLast());
        linkedList.removeFirst();
        assertNull(linkedList.getLast());
    }
}