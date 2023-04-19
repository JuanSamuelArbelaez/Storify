package Model.Structures.BinaryTree;

import Model.Structures.LinkedList.LinkedList;
import Model.Structures.Nodes.BinaryNode;

import java.util.function.Consumer;

public class BinaryTree<E extends Comparable<E>> implements BinaryTree_Interface<E> {
    private BinaryNode<E> root;
    private int size;

    public BinaryTree() {
        this.root = null;
        this.size = 0;
    }

    @Override public void add(E value) {
        if (root == null) {
            root = new BinaryNode<>(value);
        } else {
            addRecursive(root, value);
        }
        size++;
    }

    private void addRecursive(BinaryNode<E> node, E value) {
        if (value.compareTo(node.getValue()) < 0) {
            if (node.getLeft() == null) node.setLeft(new BinaryNode<>(value));
            else addRecursive(node.getLeft(), value);
        } else {
            if (node.getRight() == null) node.setRight(new BinaryNode<>(value));
            else addRecursive(node.getRight(), value);
        }
    }

    @Override public boolean contains(E value) {
        return containsRecursive(root, value);
    }

    private boolean containsRecursive(BinaryNode<E> node, E value) {
        if (node == null) return false;
        else if (node.getValue().equals(value)) return true;
        else if (value.compareTo(node.getValue()) < 0) return containsRecursive(node.getLeft(), value);
        else return containsRecursive(node.getRight(), value);
    }


    @Override public void remove(E value) {
        root = removeRecursive(root, value);
        if (root != null) size--;
    }

    private BinaryNode<E> removeRecursive(BinaryNode<E> node, E value) {
        if (node == null) return null;
        else if (value.compareTo(node.getValue()) < 0) node.setLeft(removeRecursive(node.getLeft(), value));
        else if (value.compareTo(node.getValue()) > 0) node.setRight(removeRecursive(node.getRight(), value));
        else {
            if (node.getLeft() == null) return node.getRight();
            else if (node.getRight() == null) return node.getLeft();
            else {
                BinaryNode<E> minNode = findMin(node.getRight());
                node.setValue(minNode.getValue());
                node.setRight(removeRecursive(node.getRight(), minNode.getValue()));
            }
        }
        return node;
    }

    private BinaryNode<E> findMin(BinaryNode<E> node) {
        if (node.getLeft() == null) return node;
        return findMin(node.getLeft());
    }

    @Override
    public int size() {
        return size;
    }

    @Override public boolean isEmpty() {
        return size == 0;
    }

    @Override public void clear() {
        root = null;
        size = 0;
    }

    @Override public void preOrderTraversal(Consumer<E> consumer) {
        preOrderTraversalRecursive(root, consumer);
    }
    private void preOrderTraversalRecursive(BinaryNode<E> node, Consumer<E> consumer) {
        if (node != null) {
            consumer.accept(node.getValue());
            preOrderTraversalRecursive(node.getLeft(), consumer);
            preOrderTraversalRecursive(node.getRight(), consumer);
        }
    }

    @Override public void inOrderTraversal(Consumer<E> consumer) {
        inOrderTraversalRecursive(root, consumer);
    }

    private void inOrderTraversalRecursive(BinaryNode<E> node, Consumer<E> consumer) {
        if (node != null) {
            inOrderTraversalRecursive(node.getLeft(), consumer);
            consumer.accept(node.getValue());
            inOrderTraversalRecursive(node.getRight(), consumer);
        }
    }

    @Override public void postOrderTraversal(Consumer<E> consumer) {
        postOrderTraversalRecursive(root, consumer);
    }

    private void postOrderTraversalRecursive(BinaryNode<E> node, Consumer<E> consumer) {
        if (node != null) {
            postOrderTraversalRecursive(node.getLeft(), consumer);
            postOrderTraversalRecursive(node.getRight(), consumer);
            consumer.accept(node.getValue());
        }
    }

    @Override public int height() {
        return heightRecursive(root);
    }

    private int heightRecursive(BinaryNode<E> node) {
        if (node == null) return -1;
        else {
            int leftHeight = heightRecursive(node.getLeft());
            int rightHeight = heightRecursive(node.getRight());
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    @Override public void balance() {
        LinkedList<E> nodes = new LinkedList<>();
        inOrderTraversal(nodes::add);
        root = balanceHelper(nodes, 0, nodes.size() - 1);
    }

    private BinaryNode<E> balanceHelper(LinkedList<E> nodes, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryNode<E> node = new BinaryNode<>(nodes.get(mid));
        node.setLeft(balanceHelper(nodes, start, mid - 1));
        node.setRight(balanceHelper(nodes, mid + 1, end));
        return node;
    }
}