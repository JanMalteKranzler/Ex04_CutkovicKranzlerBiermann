package de.unistuttgart.vis.dsass2021.ex04.p2;

public class LinkedListNode<T extends Comparable<T>> implements ILinkedListNode<T>{

    private LinkedListNode<T> previous;
    private LinkedListNode<T> next;
    private T element;

    public LinkedListNode() {
        this.previous = new LinkedListNode<T>();
		this.next = new LinkedListNode<T>();
    }

    @Override
    public T getElement() {
        return element;
    }

    @Override
    public void setElement(T element) {
        this.element = element;
    }

    @Override
    public ILinkedListNode<T> getNext() {
        return next;
    }

    @Override
    public void setNext(ILinkedListNode<T> next) {
        this.next = (LinkedListNode<T>) next;
    }

    @Override
    public ILinkedListNode<T> getPrev() {
        return previous;
    }

    @Override
    public void setPrev(ILinkedListNode<T> prev) {
        this.previous = (LinkedListNode<T>) prev;
    }
}
