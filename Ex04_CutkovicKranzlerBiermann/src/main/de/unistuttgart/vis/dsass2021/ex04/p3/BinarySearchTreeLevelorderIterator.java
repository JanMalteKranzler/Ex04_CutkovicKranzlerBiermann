package de.unistuttgart.vis.dsass2021.ex04.p3;

import java.util.Iterator;
import java.util.Stack;

public class BinarySearchTreeLevelorderIterator implements Iterator {

    final Stack<IBinaryTreeNode> stack;
    int currentLevel;

    public BinarySearchTreeLevelorderIterator(final IBinaryTreeNode root) {
        stack = new Stack<>();
        stack.push(root);
        currentLevel = 0;
        //TODO set up
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Object next() {
        //TODO
        return null;
    }
}
