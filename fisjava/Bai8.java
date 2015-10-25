package fisjava;

import java.io.IOException;
import java.util.Scanner;

/**
 * @version 1.0
 * @author Admin
 *
 */
public class Bai8 {
	private static Scanner scan;

	public static void main(String args[]) throws IOException {
		String isExit = "";
		while (!isExit.equals("Y")) {
			printMenu();
			scan = new Scanner(System.in);
			int choice = 0;
			choice = Integer.parseInt(scan.next(), Character.MAX_RADIX);

			switch (choice) {
			case 1:
				System.out.println("1.Reverse");
				reverseInput();
				break;
			case 2:
				System.out.println("2.UpperCase First");
				upperCaseFirst();
				break;
			case 3:
				System.out.println("3.UpperCase First of Word");
				upperCaseFirstOfWord();
				break;
			case 4:
				System.out.println("4.Print UpperCase");
				printUpperCase();
				break;
			case 5:
				System.out.println("5.Shift Right");
				shiftRight();
				break;
			case 6:
				System.out.println("6.Exit");
				System.out.println("Bạn có muốn thoát không(Y/N)");
				isExit=scan.next().toString();
				break;
			default:
				System.out.println("Bạn đã không chọn chức năng nào!!!");
			}
		}
		System.out.println("Goodbye!");
	}

	/* Menu */
	public static void printMenu() {
		System.out.println("<=============Menu=============>");
		System.out.println("1.Reverse");
		System.out.println("2.UpperCase First");
		System.out.println("3.UpperCase First of Word");
		System.out.println("4.Print UpperCase");
		System.out.println("5.Shift Right");
		System.out.println("6.Exit");
		System.out.println("--------------------------------");
	}

	/**
	 * Print a string reversed
	 */
	public static void reverseInput() {
		String isExit = "";
		while (!isExit.equals("N")) {
			StringBuffer bf = readInput();
			bf.reverse();
			System.out.println("Chuỗi ngược: " + bf);
			System.out.println("Bạn có muốn nhập tiếp không(Y/N):");
			isExit  = scan.next().toString();
		}
	}

	/**
	 * Print a string with uppercase letter of first word
	 */
	public static void upperCaseFirst() {
		String isExit = "";
		while (!isExit.equals("N")) {
			StringBuffer bf = readInput();
			String str = bf.toString();
			// str=String.valueOf(str.charAt(0)).toUpperCase()+str.substring(1,
			// str.length());
			System.out.println("Chuỗi có chữ đầu viết hoa:\n"
					+ String.valueOf(str.charAt(0)).toUpperCase()
					+ str.substring(1, str.length()));
			System.out.println("Bạn có muốn nhập tiếp không(0/1):");
			isExit = scan.next().toString();
		}
	}

	/**
	 * 
	 * Print a string with uppercase letter of words
	 *
	 */
	public static void upperCaseFirstOfWord() {
		String isExit = "";
		while (!isExit.equals("N")) {
			StringBuffer bf = readInput();
			StringBuffer result = new StringBuffer();
			String str = bf.toString();
			String char_prev = "";
			String char_current = "";
			String key = " ,.!?:\"";
			result.append(String.valueOf(str.charAt(0)).toUpperCase());
			for (int i = 1; i < str.length(); i++) {
				char_prev = String.valueOf(str.charAt(i - 1));
				char_current = String.valueOf(str.charAt(i));
				if (key.contains(char_prev)) {
					char_current = char_current.toUpperCase();//uppercase first letter each word
				}
				result.append(char_current);
			}
			System.out.println("Chuỗi có chữ cái đầu viết hoa: \n" + result);
			System.out.println("Bạn có muốn nhập tiếp không(0/1):");
			isExit=  scan.next().toString();
		}
	}

	/**
	 * Print a string with all uppercase letter in the string
	 */
	public static void printUpperCase() {
		String isExit= "";
		while (!isExit.equals("N")) {
			StringBuffer bf = readInput();
			StringBuffer result = new StringBuffer();
			String str = bf.toString();
			for (int i = 0; i < str.length(); i++) {
				if (Character.isUpperCase(str.charAt(i))) {
					result.append(String.valueOf(str.charAt(i)));
				}
			}
			System.out.println("Chuỗi chữ hoa: " + result);
			System.out.println("Bạn có muốn nhập tiếp không(0/1):");
			isExit = scan.next().toString();
		}
	}

	/**
	 * Print next string
	 */
	public static void shiftRight() {
		String isExit = "";
		while (!isExit.equals("N")) {
			StringBuffer bf = readInput();
			StringBuffer result = new StringBuffer();
			String str = bf.toString();
			char[] ch = new char[str.length()];
			ch = str.toCharArray();
			for (int i = 0; i < ch.length; i++) {
				ch[i]++;
				result.append(String.valueOf(ch[i]));
			}
			System.out.println("Chuỗi mã hóa lệch 1 kí tự:\n " + result);
			System.out.println("Bạn có muốn nhập tiếp không(Y/N):");
			isExit = scan.next().toString();
		}
	}

	/**
	 * read input values
	 * @return
	 */
	public static StringBuffer readInput() {
		scan = new Scanner(System.in, "UTF-8");
		System.out.print("Nhập chuỗi: ");
		StringBuffer bf = new StringBuffer(scan.nextLine());
		return bf;
	}
}
