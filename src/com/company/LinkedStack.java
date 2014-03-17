package com.company;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<E> implements Iterable<E> {

    private int size; //stack size
    private Node<E> first; //top of stack

    private class Node<E> {
        private E item;
        private Node next;
        public Node(E data) {
            this(data, null);
        }
        public Node(E data, Node<E> next) {
            this.item = data;
            this.next = next;
        }
    }

    public LinkedStack() {
        this(null, 0);
    }
    
    public LinkedStack(E node) {
        this(null, 1);
    }
    public LinkedStack(E node, int i) {
        this.first = new Node<E>(node);
        this.size = i;
    }
    public Iterator<E> iterator() {
        return new LinkedIterator<E>();
    }
    /**
     * Is this stack empty?
     * @return true if this stack is empty; false otherwise
     */
    public boolean empty() {
        return first == null;
    }
    /**
     * Returns the node last added to this stack.
     * @return the node most recently added to this stack.
     * @throws java.util.NoSuchElementException if this stack is empty, with the warning that the stack is empty.
     */
    public E peek() {
        if (empty()) {
            throw new NoSuchElementException("Stack is empty");
        } else {
            return first.item;
        }
    }
    /**
     * Removes and returns the node most last added to this stack.
     * @return the last node recently added
     * @throws java.util.NoSuchElementException if this stack is empty
     */
    public E pop() {
        if (empty()) {
            throw new NoSuchElementException("Stack is empty");
        }
        E item = first.item;
        first = first.next;
        size--;
        return item;
    }

    /**
     * Adds a node to the top of the stack.
     * @param item
     * @return
     */
    public E push(E item) {
        if (first == null) {
            Node<E> node = new Node<E>(item);
            first = node;
            size++;
            return item;
        } else {
            Node<E> node = new Node<E>(item, first);
            first = node;
            size++;
            return item;
        }
    }

    private class LinkedIterator<O> implements Iterator<E>{
        private Node<E> current; //return current value of node
        private Node<E> prev;
        private Node<E> prev2;
        boolean removeOK;

        public LinkedIterator() {
            current = first;
            prev = null;
            prev2 = null;
            removeOK = false;
        }

        //checks to see if there is a next value in the list
        public boolean hasNext() {
            if (current != null) {
                return true;
            } else {
                return false;
            }
        }
        //returns the next element in the stack if there is one
        public E next(){
            if(!hasNext()){
                throw new NoSuchElementException();
            }
            prev2 = prev;
            prev = current;
            E result = current.item;
            current = current.next;
            removeOK = true;
            return result;
        }
        public void remove(){
            if(!removeOK){
                throw new IllegalStateException();
            }
            if (prev2 == null) {
                prev2 = null;
                prev = null;
                first = current;
                size--;
                removeOK = false;
            } else {
                prev2.next = current;
                prev = prev2;
                size--;
                removeOK = false;
            }
        }
    }

}
