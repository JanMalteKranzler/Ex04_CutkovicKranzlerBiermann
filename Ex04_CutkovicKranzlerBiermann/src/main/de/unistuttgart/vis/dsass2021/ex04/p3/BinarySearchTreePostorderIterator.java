package de.unistuttgart.vis.dsass2021.ex04.p3;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTreePostorderIterator implements Iterator {

    private final Stack<IBinaryTreeNode> stack;

    public BinarySearchTreePostorderIterator(final IBinaryTreeNode root) {
        stack = new Stack<>();
        stack.push(root);
        IBinaryTreeNode node = root;
        while (node.getLeftChild() != null) {
            node = node.getLeftChild();
            stack.push(node);
        }
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Object next() {
        final IBinaryTreeNode currentNode = stack.pop();
        final Object object = currentNode.getValue();

        //prepare next next-operation
        final IBinaryTreeNode parentNode = stack.peek();
        if ((parentNode.getRightChild() != null) && (parentNode.getRightChild() != currentNode)) {
            IBinaryTreeNode node = parentNode.getRightChild();
            stack.push(node);
            while (node.getLeftChild() != null) {
                node = node.getLeftChild();
                stack.push(node);
            }
        }

        return object;
    }
}
