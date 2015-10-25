package fisjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * @version 1.0
 * @author Admin
 *
 */
public class Bai10 {
	public static void main(String[] args) {

		/**
		 * Mảng có độ dài là giá trị lớn nhất của kiểu dữ liệu char giá trị tại
		 * phần tử của mảng chính là số lần xuất hiện kí tự đấy trong văn bản
		 */
		int[] countChar = new int[Character.MAX_VALUE];
		String str = null;
		try {
			File file = new File("input\\bai10.txt");
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis);
			Scanner scan = new Scanner(isr);
			while (scan.hasNextLine()) {
				str += scan.nextLine();
			}
			scan.close();
		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}
		/**
		 * Kiểm tra nếu kí tự thứ có giá trị kiểu nguyên là i thì tăng giá trị
		 * phần tử thứ i của mảng lên 1.
		 */
		int n = str.length();
		for (int i = 0; i < n; i++) {
			try {
				countChar[str.charAt(i)]++;
			} catch (StringIndexOutOfBoundsException e) {
				System.out.println("index over limit");
			}
		}
		for (int i = 0; i < countChar.length; i++) {
			if (countChar[i] != 0) {
				System.out.println("Kí tự: " + (char) i + ":" + countChar[i]);
			}

		}
	}
}
