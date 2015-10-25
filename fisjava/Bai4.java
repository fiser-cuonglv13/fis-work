package fisjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * class Bai4
 * 
 * @version 1.0
 * @author Admin
 *
 */
public class Bai4 {

	private static Scanner scan;

	/**
	 * method countMatches()
	 *
	 * @param str
	 * @param str1
	 * @return int
	 */
	public int countMatches(String[] str, String str1) {
		int count = 0;
		StringBuffer s = new StringBuffer(str1);
		String str2 = s.reverse().toString();
		
		for (int j = 0; j < str.length; j++) {
			/* so sánh xâu mẫu với từng xâu có độ dài bằng xâu mẫu trong mảng */
			for (int i = 0; i <= str[j].length() - str1.length(); i++) {
				if (str[j].substring(i, str1.length() + i).equals(str1)) {
					count += 1;
				}
				if (str[j].substring(i, str2.length() + i).equals(str2)) {
					count += 1;
				}
			}
		}
		return count;
	}

	public static void main(String args[]) throws FileNotFoundException {

		File file = new File("input\\bai4.txt");
		FileInputStream fis = new FileInputStream(file);
		scan = new Scanner(fis);
		int n;
		int m;
		String nm = "";
		nm=scan.nextLine();
		String[] strNM =nm.split("[ .,!]");
		n = Integer.parseInt(strNM[0]);
		m = Integer.parseInt(strNM[1]);
		String strHorizontal[] = new String[n];
		String strVertical[] = new String[m];

		for (int i = 0; i < m; i++) {
			strVertical[i] = "";
		}
		char[][] ch = new char[n][m];

		/* read input */
		for (int i = 0; i < n; i++) {
			strHorizontal[i] = scan.nextLine();
		}

		String str = scan.nextLine();
		int lenght = 2 * (m + n - 1);
		String strDiagonal[] = new String[lenght];
		for (int i = 0; i < lenght; i++) {
			strDiagonal[i] = "";
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				ch[i] = strHorizontal[i].toCharArray();
			}
		}

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				strVertical[i] += ch[j][i];
			}
		}
		/* left-top, right-down */
		for (int i = 0; i < m; i++) {
			int a = i;
			for (int j = 0; j < n; j++) {
				if (a == m)
					break;
				strDiagonal[i] += ch[j][a];
				a++;
			}
		}

		for (int i = 1; i < n; i++) {
			int a = i;
			for (int j = 0; j < m; j++) {
				if (a == n)
					break;
				strDiagonal[m + i - 1] += ch[a][j];
				a++;
			}
		}
		/* left-down, right-top */
		for (int i = 0; i < m; i++) {
			int a = i;
			for (int j = n - 1; j >= 0; j--) {
				if (a == m)
					break;
				strDiagonal[m + n - 1 + i] += ch[j][a];
				a++;
			}
		}

		for (int i = n - 2; i >= 0; i--) {
			int a = i;
			for (int j = 0; j < m; j++) {
				if (a == n || a < 0)
					break;
				strDiagonal[2 * m + n - 1 + i] += ch[a][j];
				a--;
			}
		}

		Bai4 bai4 = new Bai4();
		System.out.println(bai4.countMatches(strHorizontal, str));
		System.out.println(bai4.countMatches(strVertical, str));
		System.out.println(bai4.countMatches(strDiagonal, str));
	}
}
