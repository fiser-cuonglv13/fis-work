package fisjava;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * class Bai1
 * 
 * @version 1.0
 * @author Admin
 *
 */
public class Bai1 {

	/**
	 * Constructor
	 */
	public Bai1() {

	}

	/**
	 * method swap()
	 * 
	 * @param array
	 * @return void
	 */
	public static void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
	}

	/**
	 * method sort()
	 * 
	 * @param array
	 * @return void
	 */
	public static void sort(int[] array) {
		for (int i = 0; i < array.length; i++) {
			int max = array[i]; // max element
			int index = i; // index of max element

			/* find the index of max element */
			for (int j = i + 1; j < array.length; j++) {
				if (max < array[j]) {
					max = array[j];
					index = j;
				}
			}

			if (index != i) {
				swap(array, i, index);// swap max element to the first
			}
		}
	}

	/**
	 * method display()
	 * 
	 * @param array
	 */

	public static void display(int[] array) {

		sort(array);
		/* Display min max elements */
		System.out.println(array[0] + " " + array[array.length - 1]);
		/* Display the sorted array */
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		for (int i = array.length - 1; i >= 0; i--) {
			System.out.print(array[i] + " ");
		}
	}


	public static void main(String args[]) throws IOException {

		FileInputStream file = new FileInputStream("input\\bai1.txt");
		Scanner scan = new Scanner(file);
		int n = scan.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scan.nextInt();
		}
		scan.close();
		display(arr);
	}
}
