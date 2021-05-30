package de.unistuttgart.vis.dsass2021.ex04.p2;

public class CircularLinkedList<T extends Comparable<T>> implements ICircularLinkedList<T> {

    final private ILinkedListNode<T> head;

    public CircularLinkedList() {
        head = new LinkedListNode();
        head.setNext(head);
        head.setPrev(head);
    }

	@Override
	public void append(T element) {
	    final ILinkedListNode newNode = new LinkedListNode();
	    newNode.setElement(element);
	    newNode.setNext(head);
		head.getPrev().setNext(newNode);
	}

	@Override
	public T get(int index) {
	    ILinkedListNode<T> node = head.getNext();
	    for(int i=0; i<index; i++) {
	        if (node.getNext() == head) {
                node = node.getNext();
            }
            node = node.getNext();
	    }
		return node.getElement();
	}

	@Override
	public int size() {
	    int size = 0;
	    ILinkedListNode<T> node = head.getNext();
	    while(node != head) {
	        size++;
	        node = node.getNext();
	    }
		return size;
	}

	@Override
	public ILinkedListNode<T> getHead() {
		return head;
	}
}
