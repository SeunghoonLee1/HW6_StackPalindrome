package edu.miracosta.cs113;

/**
 * ArrayQueue.java : This class checks for palindromes by storing the characters of the string being checked in a stack
 * and then remove half of the characters, pushing them onto a second stack. When you are finished, if the two stacks are equal,
 * then the string is a palindrome. This works fine if the string has an even number of characters.
 * If the string has an odd number of characters, an additional character should be removed from the original stack
 * before the two stacks are compared. It doesn’t matter what this character is because it doesn’t have to be matched.
 *
 * @author Danny Lee
 * @version 1.0
 *
 */

import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<E> implements StackInterface<E> {

    private ArrayList<E> theData;
    private int topOfStack;

    /**
     * Default Constructor
     */
    public ArrayListStack(){
        theData = new ArrayList<E>();
        topOfStack = -1;
    }

    /**
     * Returns true if the stack is empty; otherwise, returns false.
     * @return true or false.
     */
    public boolean empty() {
        return (topOfStack == -1);
    }

    /**
     * Returns the object at the top of the stack without removing it.
     * @return Object of type E.
     */
    public E peek() {
        if(empty()){
            throw new EmptyStackException();
        }
        return theData.get(topOfStack);
    }

    /**
     * Returns the object at the top of the stack and removes it.
     * @return Object of type E
     */
    public E pop() {
        E popValue;
        if(empty()){
            throw new EmptyStackException();
        }
        popValue = theData.get(topOfStack);
        topOfStack--;
        return popValue;
    }

    /**
     * Pushes an item onto the top of the stack and return the item pushed.
     * @param obj object to push onto top of stack
     * @return Object of type E.
     */
    public E push(E obj) {
        topOfStack++;
        theData.add(obj);
        return obj;
    }
}