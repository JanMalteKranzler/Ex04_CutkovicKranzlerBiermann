package de.unistuttgart.vis.dsass2021.ex04.p3;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;
import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTreePreorderIterator implements Iterator {

    private final Stack<IBinaryTreeNode> stack;

    public BinarySearchTreePreorderIterator(BinaryTreeNode root) throws OperationNotSupportedException {
        stack = new Stack();
        stack.push(root);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Object next() {
        final IBinaryTreeNode node = stack.pop();
        final Object object = node.getValue();
        if (node.getRightChild() != null) {
            stack.push(node.getRightChild());
        }
        if (node.getLeftChild() != null) {
            stack.push(node.getLeftChild());
        }
        return object;
    }
}
