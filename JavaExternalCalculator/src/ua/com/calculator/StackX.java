package ua.com.calculator;

public class StackX {
	private int maxSize;
	private char[] stackArray;
	private int top;

	public StackX(int s) {
		maxSize = s;
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

	public boolean isEmpty() // true, если стек пуст
	{
		return (top == -1);
	}

	// -------------------------------------------------------------
	public int size() // Текущий размер стека
	{
		return top + 1;
	}

	// --------------------------------------------------------------
	public char peekN(int n) // Чтение элемента с индексом n
	{
		return stackArray[n];
	}

	// --------------------------------------------------------------
	public void displayStack(String s)
	 {
	 System.out.print(s);
	 System.out.print("Stack (bottom-->top): ");
	 for(int j=0; j<size(); j++)
		 г 4.7 (продолжение)
		 {
		 System.out.print( peekN(j) );
		 System.out.print(' ');
		 }
		 System.out.println("");
		 }
}
