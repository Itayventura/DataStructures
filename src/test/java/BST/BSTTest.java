package BST;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import BST.BST.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BSTTest {

    private static BST<Integer> bst;

    @BeforeEach
    void setUp() {
        bst = new BST<Integer>(4);
        bst.insert(2);
        bst.insert(6);
    }

    @Test
    void insert() {
        bst.insert(6);
        bst.insert(1);
        bst.insert(3);
        bst.insert(5);
        bst.insert(7);
        assertInOrder();
    }

    private void assertInOrder() {
        List<Integer> inOrder = bst.inOrder();
        for(int i = 1; i < inOrder.size(); i++){
            assertTrue(inOrder.get(i-1) < inOrder.get(i));
        }

    }

    @Test
    void delete() {
        assertEquals(4, bst.getRoot().getValue());
        bst.delete(4);
        assertEquals(6, bst.getRoot().getValue());
        bst.delete(2);
        assertNull(bst.getRoot().getRight());
        assertNull(bst.getRoot().getLeft());
        bst.delete(13);
        bst.delete(6);
        assertNull(bst.getRoot());

    }

    @Test
    void search() {
        TreeNode<Integer> node = bst.search(4);
        assertEquals(4, node.getValue());
        assertEquals(2, node.getLeft().getValue());
        assertEquals(6, node.getRight().getValue());
        assertNull(bst.search(3));
    }
}