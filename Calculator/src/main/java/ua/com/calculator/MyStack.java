package ua.com.calculator;

import org.apache.log4j.Logger;

class MyStack {
    private int maxSize;
    private char[] stackArray;
    private int top;

    public MyStack(int size) {
        maxSize = size;
        stackArray = new char[maxSize];
        top = -1;
    }

    public void push(char j) {
        stackArray[++top] = j;
    }

    public char pop() {
        return stackArray[top--];
    }

    public char peek() {
        return stackArray[top];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public boolean isFull() {
        return (top == maxSize - 1);
    }

    public int size() {
        return top + 1;
    }

    public char peekN(int n) {
        return stackArray[n];
    }

    public void displayStack(String s, Logger log) {
        log.info(s);
        System.out.print("Stack (bottom-->top): ");
        for (int j = 0; j < size(); j++) {
            log.info(peekN(j));
            log.info(' ');
        }
        log.info("\n");
    }
}
