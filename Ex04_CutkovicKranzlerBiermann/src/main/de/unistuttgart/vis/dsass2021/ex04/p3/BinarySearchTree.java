package de.unistuttgart.vis.dsass2021.ex04.p3;

import javax.naming.OperationNotSupportedException;
import javax.swing.*;
import java.util.Iterator;

public class BinarySearchTree<T extends Comparable<T>> implements
		IBinarySearchTreeIterable<T> { 

	private volatile IBinaryTreeNode<T> root;

	public BinarySearchTree() {
		this.root = null;
	}

	@Override
	public void insert(T t) {
		this.root = this.insert(this.root, t);
	}

	private IBinaryTreeNode<T> insert(IBinaryTreeNode<T> node, T t) {
		if (node == null) {
			IBinaryTreeNode<T> newNode = new BinaryTreeNode<>();
			newNode.setValue(t);
			return newNode;
		}
		if (t.compareTo(node.getValue()) < 0) {
			node.setLeftChild(this.insert(node.getLeftChild(), t));
		} else if (t.compareTo(node.getValue()) > 0) {
			node.setRightChild(this.insert(node.getRightChild(), t));
		}
		return node;
	}

	@Override
	public IBinaryTreeNode<T> getRootNode() {
		return this.root;
	}

	//TODO implement method
	@Override
	public Iterator<T> iterator(TreeTraversalType traversalType) throws OperationNotSupportedException {
		switch (traversalType) {
			case PREORDER -> {
				return new BinarySearchTreePreorderIterator((BinaryTreeNode) root);
			}
			case INORDER -> {
				return new BinarySearchTreeInorderIterator((BinaryTreeNode) root);
			}
			case POSTORDER -> {
				return new BinarySearchTreePostorderIterator((BinaryTreeNode) root);
			}
			case LEVELORDER -> {
				return new BinarySearchTreeLevelorderIterator((BinaryTreeNode) root);
			}
		}
		return null;
	}

	private void inOrderTraversal(BinaryTreeNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal((BinaryTreeNode) node.getLeftChild());
		System.out.println(node.getValue()+ " ");
		inOrderTraversal((BinaryTreeNode) node.getRightChild());
	}
}
