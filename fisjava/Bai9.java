package fisjava;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * @version 1.0
 * @author Admin
 *
 */
public class Bai9 {
	private static Scanner scan;

	public static void main(String[] args) {
		Dictionary dict = new Dictionary();
		dict.loadDictOnFile();
		String exit = "";
		while (!exit.equals("Y")) {
			System.out.println("Dictionary Menu");
			System.out.println("1.Thêm từ");
			System.out.println("2.Tra từ");
			System.out.println("3.Chỉnh sửa");
			System.out.println("4.Thoát");
			int choice = 0;
			scan = new Scanner(System.in);
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				dict.addWord();
				break;
			case 2:
				dict.findWord();
				break;
			case 3:
				dict.editWord();
				break;
			case 4:
				System.out.println("Bạn có muốn thoát không(Y/N)");
				exit = scan.next().toString();
				break;
			default:
				System.out.println("Bạn chưa chọn chức năng nào!");
			}
		}
		dict.save();
		System.out.println("Cảm ơn đã sử dụng!Good Bye!!!");
	}
}

class Dictionary {
	Scanner scan;
	ArrayList<Words> dictionary = new ArrayList<Words>();

	/**
	 * Constructor
	 */
	public Dictionary() {

	}

	/**
	 * Load all words and mean from file
	 */
	public void loadDictOnFile() {
		File file = new File("input\\bai9.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			scan = new Scanner(fis, "UTF-16");
			while (scan.hasNextLine()) {
				String[] str = scan.nextLine().split(",");
				Words word = new Words(str[0], str[1]);
				dictionary.add(word);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Add word in dictionary if word and mean were exist ignore else add new
	 * word
	 */
	public void addWord() {
		Scanner input = new Scanner(System.in);
		System.out.println("Input Keyword: ");
		String keyWord = input.nextLine();
		System.out.println("Input Value: ");
		String mean = input.nextLine();
		for (Words w : dictionary) {
			if (w.getWord().equals(keyWord)) {
				if (!w.getMean().contains(mean)) {
					w.mean.add(mean);
					System.out.println("Thêm nghĩa mới cho từ!");
				} else {
					System.out.println("Từ đã tồn tại!");
				}
				break;
			} else {
				Words word = new Words(keyWord, mean);
				dictionary.add(word);
				System.out.println("Thêm thành công từ mới!");
				break;
			}
		}
	}

	/**
	 * find the input key word in the dictionary return the mean of word if
	 * exist
	 */
	public void findWord() {
		Scanner input = new Scanner(System.in);
		System.out.println("Input Keyword: ");
		String keyWord = input.nextLine();
		boolean isExist = false;
		for (Words w : dictionary) {
			if (w.getWord().equals(keyWord)) {
				isExist = true;
				System.out.println("Mean: ");
				String mean = "";
				for (String str : w.getMean()) {
					mean += str + "\n";
				}
				System.out.println(mean);
			}
		}
		if (!isExist) {
			System.out.println("Không tìm thấy từ");
		}
		System.out.println("Bấm Enter để trở lại menu.");
		input.nextLine();
	}

	/**
	 * Edit word with the new mean
	 */
	public void editWord() {
		Scanner input = new Scanner(System.in);
		System.out.println("Input Keyword: ");
		String keyWord = input.nextLine();
		System.out.println("Input Value: ");
		String mean = input.nextLine();
		for (Words word : dictionary) {
			if (word.getWord().equals(keyWord)) {
				for (int i = 0; i < word.mean.size(); i++) {
					word.mean.remove(i);
				}
				word.setMean(mean);
			}
		}
		System.out.println("Chỉnh sửa thành công");
	}

	public void save() {
		try {
			BufferedWriter file = new BufferedWriter(new FileWriter(
					"input\\bai9.txt"));
			for (Words word : dictionary) {
				String line = word.getWord() + ","
						+ word.getMean().get(0).toString();
				line += System.getProperty("line.separator");
				file.write(line);
			}
			file.close();
		} catch (IOException e) {
		}
	}
}

class Words {
	String word;
	ArrayList<String> mean = new ArrayList<String>();

	public Words() {

	}

	public Words(String word, String mean) {
		super();
		this.word = word;
		this.mean.add(mean);
	}

	public String getWord() {
		return word;
	}

	public void setWord(String word) {
		this.word = word;
	}

	public ArrayList<String> getMean() {
		return mean;
	}

	public void setMean(String mean) {
		this.mean.add(mean);
	}
}
