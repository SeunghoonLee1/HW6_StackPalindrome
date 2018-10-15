package edu.miracosta.cs113;

import org.junit.Before;
import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class ArrayQueueTester {

    private ArrayQueue<Integer> queue;

    @Before
    public void setup() {
        queue = new ArrayQueue<Integer>(5);
    }

    @Test
    public void testAddToEmptyQueue(){
        assertTrue("Adding to an empty queue should be successful", queue.add(1));
    }

    @Test
    public void testAddManyToQueue(){
        for(int i = 0; i < 3; i ++){
            assertTrue("Adding many data to the queue should be succssful",queue.add(i));
            assertEquals("Should add multiple data to the front of the queue ", (long)i, (long)queue.poll());
        }
    }

    @Test
    public void testAddMoreThanQueueCapacity(){
        for(int i = 0; i < 11; i ++){
            assertTrue("Adding many data to the queue should be succssful",queue.add(i));
        }
        for(int j = 0; j < 11; j++){
            assertEquals("Should add multiple data to the front of the queue ", (long)j, (long)queue.poll());
        }

    }

    @Test
    public void testRemoveError(){
        try{
            queue.remove();
        }catch(NoSuchElementException nce){
            //Test Passed
        }
    }

    @Test
    public void testRemoveOnce(){
        queue.add(1);
        assertEquals("Expected and actual don't match, somethings wrong with removing or adding one value?",
        1L, (long)queue.remove());
    }

    @Test
    public void testRemoveMany(){
        for(int i = 50; i <= 63; i++) {
            queue.add(i);
        }

        //values come out in reverse order!
        for(int i = 50; i <= 63; i++) {
            assertEquals("Expected and actual don't match, somethings wrong with removing or adding multiple values?",
                    (long)i, (long)queue.remove());
        }
    }

    @Test
    public void testPollError(){
        assertEquals("Expected and actual don't match, it should return null.",null, queue.poll());
    }

    @Test
    public void testPollOnce(){
        queue.add(1);
        assertEquals("Expected and actual don't match, somethings wrong with removing or adding one value?",
                1L, (long)queue.poll());
    }

    @Test
    public void testPollMany(){
        for(int i = 50; i <= 63; i++) {
            queue.add(i);
        }

        for(int i = 50; i <= 63; i++) {
            assertEquals("Expected and actual don't match, somethings wrong with removing or adding multiple values?",
                    (long)i, (long)queue.poll());
        }
    }

    @Test
    public void testPeekError() {
        assertEquals("Expected and actual don't match, it should return null.", null, queue.peek());
    }

    @Test
    public void testPeekOnce(){
        queue.add(1);
        assertEquals("Expected and actual don't match, somethings wrong with removing or adding one value?",
                1L, (long)queue.peek());
    }

    @Test
    public void testPeekMany(){
        for(int i = 0; i <= 15; i++) {
            queue.add(i);
        }
        for(int i = 0; i <= 15; i++) {
            assertEquals("Expected and actual don't match, somethings wrong with removing or adding multiple values?",
                    (long)i, (long)queue.peek());
            queue.remove();
        }
    }

    @Test
    public void testElementError() {
        try{
            queue.element();
        }catch(NoSuchElementException nce){
            //Test Passed
        }
    }


    @Test
    public void testElementOnce(){
        queue.add(1);
        assertEquals("Expected and actual don't match, somethings wrong with removing or adding one value?",
                1L, (long)queue.element());
    }

    @Test
    public void testElementMany(){
        for(int i = 0; i <= 15; i++) {
            queue.add(i);
        }
        for(int i = 0; i <= 15; i++) {
            assertEquals("Expected and actual don't match, somethings wrong with removing or adding multiple values?",
                    (long)i, (long)queue.element());
            queue.remove();
        }
    }

}
