package edu.miracosta.cs113;

/**
 * ArrayQueue.java : This class represents implementation of a circular array using the java.util.Queue interface.
 * @author Danny Lee
 * @version 1.0
 *
 */
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArrayQueue<E> implements Queue<E> {

    private E[] theCircularList;
    private int front;
    private int rear;
    private int size;
    private int capacity;

    /**
     * Constructor
     * @param initialCapacity represents the initial capacity of the circular list.
     */
    public ArrayQueue(int initialCapacity){
        capacity = initialCapacity;
        theCircularList = (E[])new Object[capacity];
        front = 0;
        rear = capacity - 1;
        size = 0;
    }

    /**
     * Default Constructor
     */
    public ArrayQueue() {
        capacity = 10;
        theCircularList = (E[])new Object[capacity];
        front = 0;
        rear = capacity - 1;
        size =0;
    }

    /**
     * Inserts the specified element into this queue if it is possible to do so immediately without violating capacity
     * restrictions, returning true upon success and throwing an IllegalStateException if no space is currently available.
     * @param item
     * @return true or false.
     */
    @Override
    public boolean add(E item) {
        if(offer(item)){
            return true;
        }
        else{
            throw new IllegalStateException("Failed to add.");
        }
    }

    /**
     * Returns the entry at the front of the queue without removing it. If the queue is empty, throw a NoSuchElementException.
     * @return Object of type E
     */
    @Override
    public E element() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        E result = theCircularList[front];
        return result;
    }

    /**
     * Inserts item at the rear of the queue. Returns true if successful; returns false if the item could not be inserted.
     * @param item to add on to the queue.
     * @return true or false.
     */
    @Override
    public boolean offer(E item){
        if(size == capacity){
            reallocate();
        }
        size++;
        rear = (rear + 1) % capacity;
        theCircularList[rear] = item;
        return true;
    }

    /**
     * Returns the entry at the front of the queue without removing it; returns null if the queue is empty.
     * @return null or an object type of E.
     */
    @Override
    public E peek() {
        if(size == 0){
            return null;
        }
        E result = theCircularList[front];
        return result;
    }

    /**
     * Removes the entry at the front of the queue and returns it; returns null if the queue is empty.
     * @return
     */
    @Override
    public E poll() {
        if(size == 0){
            return null;
        }
        E result = theCircularList[front];
        front = (front + 1) % capacity;
        size --;
        return result;
    }

    /**
     * Removes the entry at the front of the queue and returns it if the queue is not empty. If the queue is empty,
     * throws a NoSuchElementException.
     * @return an object of type E.
     */
    @Override
    public E remove() {
        if(size == 0){
            throw new NoSuchElementException();
        }
        E result = theCircularList[front];
        front = (front + 1) % capacity;
        size --;
        return result;
    }

    /**
     * When the array is full, it crates a new array that is twice as big as the original array and reallocates the
     * elements in the original array.
     */
    private void reallocate(){
        int newCapacity = 2 * capacity;
        E[] newList = (E[])new Object[newCapacity];
        int j = front;
        for(int i = 0; i < size; i++){
            newList[i] = theCircularList[j];//copying the data from theCircularList to the newList one by one
            j = (j + 1) % capacity;
        }
        front = 0;
        rear = size - 1;
        capacity = newCapacity;
        theCircularList = newList;
    }

    //================================================

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }


    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }


}