package BST;

import java.util.ArrayList;
import java.util.List;

public class BST<T extends Comparable<T>> {

    public static class TreeNode<T extends Comparable<T>>{
        private T value;
        private TreeNode<T> left;
        private TreeNode<T> right;

        private TreeNode(T value){
            this.value = value;
            this.left = null;
            this.right = null;
        }

        public T getValue(){
            return this.value;
        }

        public TreeNode<T> getLeft(){
            return this.left;
        }

        public TreeNode<T> getRight() {
            return this.right;
        }

        public boolean isLeaf(){
            return this.left == null && this.right == null;
        }
    }

    private TreeNode<T> root;

    public BST(T value){
        this.root = new TreeNode<T>(value);
    }

    public TreeNode<T> getRoot(){
        return this.root;
    }

    public List<T> inOrder(){
        List<T> list = new ArrayList<>();
        return inOrder(root, list);
    }

    public List<T> inOrder(TreeNode<T> ptr, List<T> list){
        if (ptr != null){
            inOrder(ptr.left, list);
            list.add(ptr.value);
            inOrder(ptr.right, list);
        }
        return list;
    }

    public void insert(T value){
        if(this.root == null){
            this.root = new TreeNode<T>(value);
        } else{
            TreeNode<T> ptr = root;
            TreeNode<T> node = new TreeNode<>(value);
            while(true){
                if (value.compareTo(ptr.value) < 0){
                    if(ptr.left == null){
                        ptr.left = node;
                        return;
                    }
                    ptr = ptr.left;
                } else if (value.compareTo(ptr.value) == 0){
                    return;
                } else{
                    if(ptr.right == null){
                        ptr.right = node;
                        return;
                    }
                    ptr = ptr.right;
                }
            }
        }

    }

    public void delete(T value){
        TreeNode<T> nodeToDelete = search(value);
        if (nodeToDelete != null){
            TreeNode<T> parent = getParent(nodeToDelete);
            if (nodeToDelete.isLeaf()){
                if (parent != null){
                    updateParent(parent, nodeToDelete);
                } else{
                    this.root = null;
                }

            } else if(nodeToDelete.right == null){
                parent.left = nodeToDelete.left;
            } else if(nodeToDelete.left == null){
                parent.right = nodeToDelete.right;
            } else{
                TreeNode<T> successor = getSuccessor(nodeToDelete);
                nodeToDelete.value = successor.value;
                parent = getParent(successor);
                updateParent(parent, successor);
            }
        }

    }

    private void updateParent(TreeNode<T> parent, TreeNode<T> nodeToDelete) {
        if(parent.right == nodeToDelete){
            parent.right = null;
        } else{
            parent.left = null;
        }
    }

    private TreeNode<T> getParent(TreeNode<T> nodeToDelete) {
        TreeNode<T> ptr = this.root;
        if(ptr == nodeToDelete){
            return null;
        } else{
            while(true){
                if(nodeToDelete.value .compareTo(ptr.value) < 0){
                    if (ptr.left == nodeToDelete){
                        return ptr;
                    } else{
                        ptr = ptr.left;
                    }
                } else{
                    if(ptr.right == nodeToDelete){
                        return ptr;
                    } else{
                        ptr = ptr.right;
                    }
                }
            }
        }
    }

    private TreeNode<T> getSuccessor(TreeNode<T> node){
        TreeNode<T> right = node.right;
        while(right.left != null){
            right = right.left;
        }
        return right;
    }

    public TreeNode<T> search(T value){
        TreeNode<T> ptr = root;
        while(ptr != null){
            if (value.compareTo(ptr.value) < 0){
                ptr = ptr.left;
            } else if (value.compareTo(ptr.value) == 0){
                 return ptr;
            } else{
                ptr = ptr.right;
            }
        }
        return null;
    }
}
