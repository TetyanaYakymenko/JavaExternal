import java.util.ArrayList;
import java.util.Scanner;

public class Task1 {
	static private ArrayList<Integer> interval = new ArrayList<>();
	static private ArrayList<Integer> fibonacciNums = new ArrayList<>();

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
		printList(interval, true, true, false);
		System.out.println();

		System.out.println("All odd numbers from interval in direct direction :");
		printList(interval, false, true, false);
		System.out.println();

		System.out.println("All even numbers from interval in reverse direction :");
		printList(interval, true, false, true);
		System.out.println();

		System.out.println("Sum of even numbers from interval: \n" + sumOfList(interval, true, false) + "\n");

		System.out.println("Sum of odd numbers from interval: \n" + sumOfList(interval, false, true) + "\n");
		
		// ==============FINONACCI===============
		
		int sizeOfSet = 0;
		System.out.println("Programm will build set of Fibonacci numbers. Please input size of the set: \n");
		sizeOfSet = in.nextInt();

		buildFibonacciNumbers(sizeOfSet);
		printList(fibonacciNums, true, true, false);
		System.out.println();
		
		System.out.println("This is the biggest number of enen Fibonacci set: \n" + maxNumber(fibonacciNums, true, false));
		System.out.println("This is the biggest number of odd Fibonacci set: \n" + maxNumber(fibonacciNums, false, true));
		System.out.println("Percent of even numbers in Fibonacci set is:\n " + findPercente(fibonacciNums, true));
		System.out.println("Percent of even numbers in Fibonacci set is:\n " + findPercente(fibonacciNums, false));

		in.close();
	}

	static private void buildInterval(int begin, int end) {
		int length = end - begin;
		if (length <= 0) {
			System.out.println("Incorrect data of begin and end of interval!");
			return;
		}

		for (int i = 0; i < length; i++) {
			interval.add(begin + i);
		}
	}

	static private void printList(ArrayList<Integer> list, boolean isEven, boolean isOdd, boolean isReverse) {
		if (!isReverse) {
			for (int num : list) {
				if ((isEven) && (num % 2 == 0)) {
					System.out.print(num + " ");
				}
				if ((isOdd) && (num % 2 != 0)) {
					System.out.print(num + " ");
				}
				if (!isEven && !isOdd) {
					System.out.print(num + " ");
				}
			}
		} else {
			for (int i = list.size() - 1; i >= 0; i--) {
				int num = list.get(i);
				if ((isEven) && (num % 2 == 0)) {
					System.out.print(num + " ");
				}
				if ((isOdd) && (num % 2 != 0)) {
					System.out.print(num + " ");
				}
				if (!isEven && !isOdd) {
					System.out.print(num + " ");
				}
			}
		}
	};

	static private int sumOfList(ArrayList<Integer> list, boolean isEven, boolean isOdd) {
		int result = 0;
		for (int num : list) {
			if ((isEven) && (num % 2 == 0)) {
				result += num;
			}
			if ((isOdd) && (num % 2 != 0)) {
				result += num;
			}
			if (!isEven && !isOdd) {
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
			if ((isEven) && (num % 2 == 0)) {
				result = Math.max(result, num);
			}
			if ((isOdd) && (num % 2 != 0)) {
				result = Math.max(result, num);
			}
			if (!isEven && !isOdd) {
				result = Math.max(result, num);
			}
		}
		return result;
	}

	static private double findPercente(ArrayList<Integer> list, boolean isEven) {
		int count = 0;
		for (int num : list) {
			if ((isEven) && (num % 2 == 0)) {
				count += 1;
			}
			if ((!isEven) && (num % 2 != 0)) {
				count += 1;
			}
		}

		return (double) count * 100 / (double) list.size();
	}
}
