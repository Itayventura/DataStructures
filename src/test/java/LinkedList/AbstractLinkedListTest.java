package LinkedList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class AbstractLinkedListTest {

    private static LinkedListImpl<Integer> linkedList;

    @BeforeEach
    void setUp() {

        linkedList = new LinkedListImpl(1);
    }

    @Test
    void addFirst() {
        assertEquals(1, linkedList.getFirst());

        linkedList.addFirst(2);
        assertEquals(2, linkedList.getFirst());

        linkedList.addFirst(3);
        assertEquals(3, linkedList.getFirst());

        linkedList.addFirst(4);
        assertEquals(4, linkedList.getFirst());

        linkedList.addFirst(5);
        assertEquals(5, linkedList.getFirst());

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

        linkedList.addFirst(1);
        assertEquals(2, linkedList.size());

        linkedList.removeFirst();
        assertEquals(1, linkedList.size());

        linkedList.removeFirst();
        assertEquals(0, linkedList.size());


        linkedList.removeFirst();
        assertEquals(0, linkedList.size());
    }

    @Test void removeAdd(){
        assertEquals(1, linkedList.getFirst());

        linkedList.removeFirst();
        assertNull(linkedList.getFirst());

        linkedList.addFirst(1);
        assertEquals(1, linkedList.getFirst());
    }
}