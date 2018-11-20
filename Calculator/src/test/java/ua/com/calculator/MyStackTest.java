package ua.com.calculator;

import static org.junit.Assert.assertEquals;

public class MyStackTest {

    @org.junit.Test(expected = IndexOutOfBoundsException.class)
    public void push_OverSize_Exception() {
        MyStack myStack = new MyStack(2);
        myStack.push('1');
        myStack.push('2');
        myStack.push('3');
    }

    @org.junit.Test
    public void pop_RightValue() {
        MyStack myStack = new MyStack(1);
        myStack.push('1');
        char extected = '1';
        assertEquals(extected, myStack.pop());
    }

    @org.junit.Test
    public void peek_RightValue() {
        MyStack myStack = new MyStack(1);
        myStack.push('1');
        char expected = '1';
        assertEquals(expected, myStack.peek());
    }

    @org.junit.Test
    public void peek_NotChangeSize() {
        MyStack myStack = new MyStack(1);
        myStack.push('1');
        int expected = 1;
        myStack.peek();
        assertEquals(expected, myStack.size());
    }

    @org.junit.Test
    public void isEmpty_Empty_True() {
        MyStack myStack = new MyStack(1);
        boolean empty = true;
        assertEquals(empty, myStack.isEmpty());
    }

    @org.junit.Test
    public void isEmpty_NotEmpty_False() {
        MyStack myStack = new MyStack(3);
        myStack.push('2');
        boolean empty = false;
        assertEquals(empty, myStack.isEmpty());
    }

    @org.junit.Test
    public void isFull_Full_True() {
        MyStack myStack = new MyStack(1);
        myStack.push('2');
        boolean full = true;
        assertEquals(full, myStack.isFull());
    }

    @org.junit.Test
    public void isFull_NotFull_False() {
        MyStack myStack = new MyStack(3);
        myStack.push('2');
        boolean full = false;
        assertEquals(full, myStack.isFull());
    }

    @org.junit.Test
    public void size_One_One() {
        MyStack myStack = new MyStack(3);
        myStack.push('2');
        int expected = 1;
        assertEquals(expected, myStack.size());
    }
}