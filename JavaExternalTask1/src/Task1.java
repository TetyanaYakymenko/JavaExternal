import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
	static private ArrayList<Integer> interval = new ArrayList<>();
	static private ArrayList<Integer> fibonacciNums = new ArrayList<>();
	static public boolean isEven = true;
	static public boolean isOdd = true;
	static public boolean isReverse = true;

	public static void main(String[] args) {

		int begin = 0;
		int end = 0;

		Scanner in = new Scanner(System.in);

		System.out.println("Programm will build integer numbers from interval.\n");
		System.out.println("Please input begin of interval: ");
		begin = in.nextInt();

		System.out.println("Please input end of interval: ");
		end = in.nextInt();

		System.out.println("You put interval [ " + begin + " ; " + end + " ];");

		buildInterval(begin, end);

		isEven = true;
		isOdd = true;
		isReverse = false;

		printList(interval, isEven, isOdd, isReverse);
		System.out.println();

		System.out.println("All odd numbers from interval in direct direction :");
		isEven = false;
		isOdd = true;
		isReverse = false;
		printList(interval, isEven, isOdd, isReverse);
		System.out.println();

		System.out.println("All even numbers from interval in reverse direction :");
		isEven = true;
		isOdd = false;
		isReverse = true;
		printList(interval, isEven, isOdd, isReverse);
		System.out.println();

		isEven = true;
		isOdd = false;
		System.out.println("Sum of even numbers from interval: \n" + sumOfList(interval, isEven, isOdd) + "\n");

		isEven = false;
		isOdd = true;
		System.out.println("Sum of odd numbers from interval: \n" + sumOfList(interval, isEven, isOdd) + "\n");

		// ==============FINONACCI===============

		int sizeOfSet = 0;
		System.out.println("Programm will build set of Fibonacci numbers. Please input size of the set: \n");
		sizeOfSet = in.nextInt();

		buildFibonacciNumbers(sizeOfSet);
		isEven = true;
		isOdd = true;
		isReverse = false;
		printList(fibonacciNums, isEven, isOdd, isReverse);
		System.out.println();

		isEven = true;
		isOdd = false;
		System.out.println(
				"This is the biggest number of even Fibonacci set: \n" + maxNumber(fibonacciNums, isEven, isOdd));
		isEven = false;
		isOdd = true;
		System.out.println(
				"This is the biggest number of odd Fibonacci set: \n" + maxNumber(fibonacciNums, isEven, isOdd));
		isEven = true;
		System.out.println("Percent of even numbers in Fibonacci set is:\n " + findPercente(fibonacciNums, isEven));
		isEven = false;
		System.out.println("Percent of odd numbers in Fibonacci set is:\n " + findPercente(fibonacciNums, isEven));

		in.close();
	}

	static private void buildInterval(int begin, int end) {
		int length = end - begin;
		
		if (length <= 0) {
			System.out.println("Incorrect data of begin and end of interval!");
			return;
		}
		if ((begin < 0) && (end > 0)) length += 1;
		for (int i = 0; i < length; i++) {
			interval.add(begin + i);
		}
	}

	static private void printList(ArrayList<Integer> list, boolean isEven, boolean isOdd, boolean isReverse) {
		if (!isReverse) {
			for (int num : list) {
				if (((isEven) && (num % 2 == 0)) || ((isOdd) && (num % 2 != 0)) || (!isEven && !isOdd)) {
					System.out.print(num + " ");
				}
			}

		} else {
			for (int i = list.size() - 1; i >= 0; i--) {
				int num = list.get(i);
				if (((isEven) && (num % 2 == 0)) || ((isOdd) && (num % 2 != 0)) || (!isEven && !isOdd)) {
					System.out.print(num + " ");
				}

			}
		}
	};

	static private int sumOfList(ArrayList<Integer> list, boolean isEven, boolean isOdd) {
		int result = 0;
		for (int num : list) {
			if (((isEven) && (num % 2 == 0)) || ((isOdd) && (num % 2 != 0)) || (!isEven && !isOdd)) {
				result += num;
			}
		}
		return result;
	}

	static private void buildFibonacciNumbers(int size) {
		int prevprevNum = 1;
		int prevNum = 1;

		fibonacciNums.add(1);
		fibonacciNums.add(1);
		int temp;
		for (int i = 2; i < size; i++) {
			temp = prevprevNum + prevNum;
			fibonacciNums.add(temp);
			prevprevNum = prevNum;
			prevNum = temp;

		}

	}

	static private int maxNumber(ArrayList<Integer> list, boolean isEven, boolean isOdd) {
		int result = 0;
		for (int num : list) {
			if (((isEven) && (num % 2 == 0)) || ((isOdd) && (num % 2 != 0)) || (!isEven && !isOdd)) {
				result = Math.max(result, num);
			}

		}
		return result;
	}

	static private double findPercente(ArrayList<Integer> list, boolean isEven) {
		int count = 0;
		for (int num : list) {
			if (((isEven) && (num % 2 == 0)) || ((!isEven) && (num % 2 != 0))) {
				count += 1;
			}
		}

		return (double) count * 100 / (double) list.size();
	}
}
