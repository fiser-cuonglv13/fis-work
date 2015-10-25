package fisjava;

/**
 * Bài này em mới làm được cộng và nhân,còn trừ và chia em nghĩ không ra
 */
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @version 1.0
 * @author Admin
 *
 */
public class Bai2 {
	private static Scanner scan;
	private static int n;
	private static int m;
	private static int add = 0;
	private static int multi = 1;
	private static int subtrac = 0;
	private static int division = 1;
	private static int countAdd = 0;
	private static int countMulti = 0;
	private static int countSub = 0;
	private static int countDiv = 0;

	/* Swap elements in array */
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("input\\bai2.txt");
		FileInputStream fis = new FileInputStream(file);
		scan = new Scanner(fis);
		n = scan.nextInt();

		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = scan.nextInt();
		}
		m = scan.nextInt();

		/* sort input array */
		for (int i = 0; i < array.length; i++) {
			int min = array[i]; // min element
			int index = i; // index of min element

			// find the index of min element
			for (int j = i + 1; j < array.length; j++) {
				if (min > array[j]) {
					min = array[j];
					index = j;
				}
			}

			if (index != i) {
				swap(array, i, index);
			}
		}

		for (int i = 0; i < n; i++) {
			System.out.print(array[i] + " ");
		}
		countAddition(array, 0, 0);
		countSubtraction(array, n - 1);
		countMultiplication(array, 0, 1);
		// countDivision(array, n - 1, 1);
		/* Display result */
		for (int i = 0; i < n; i++) {
			if (array[i] == m) {
				countAdd -= 1;
				countMulti -= 1;
			}
		}
//		System.out.println(countAdd);
		System.out.println(countSub);
//		System.out.println(countMulti);
//		System.out.println(countDiv);
	}

	/**
	 * Count number of addition combinations
	 * 
	 * @param arr
	 * @param i
	 * @param sum
	 */
	public static void countAddition(int[] arr, int i, int sum) {
		for (; i < n; i++) {
			add = sum + arr[i];
			if (add == m) {
				countAdd += 1;
			}
			if (add < m) {
				countAddition(arr, i + 1, add);
			}
		}
	}

	/**
	 * Count number of subtraction combinations
	 * 
	 * @param arr
	 * @param i
	 * @param sub
	 */
	public static void countSubtraction(int[] arr, int i) {
		for (; i >= 0; i--) {
			subtrac = arr[i];
			System.out.println(subtrac+"subtrac");
			int sub = 0;
			for (int j = i - 1; j >= 0; j--) {
				sub = subtrac - arr[j];

				 System.out.println(sub);
				if (sub == m) {
					countSub += 1;
				}
				// if (sub > m) {
				// countSubtraction(arr, i - 1, sub);
				// }
			}
		}
	}

	/**
	 * Count number of multiplication combinations
	 * 
	 * @param arr
	 * @param i
	 * @param mul
	 */
	public static void countMultiplication(int[] arr, int i, int mul) {
		for (; i < n; i++) {
			if (arr[i] <= m) {
				multi = mul * arr[i];
				if (multi == m) {
					countMulti += 1;
				}
				if (multi < m) {
					countMultiplication(arr, i + 1, multi);
				}
			}
		}
	}

	/**
	 * Count number of division combinations
	 * 
	 * @param arr
	 * @param i
	 * @param div
	 */
	public static void countDivision(int[] arr, int i, int div) {
		for (; i >= 0; i--) {
			if (arr[i] > m) {
				div = arr[i] / div;
				if (div == m) {
					countDiv += 1;
				}
				if (div > m) {
					countDivision(arr, i - 1, div);
				}
			}
		}
	}
}
