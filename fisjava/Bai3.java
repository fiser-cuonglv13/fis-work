package fisjava;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;


/**
 * class Bai3
 * 
 * @version 1.0
 * @author Admin
 *
 */
public class Bai3 {

	public static void main(String[] args) {

		Map<String, Integer> hashMap = new HashMap<String, Integer>();
		String input = null;
		/* Read input */
		try {
			File file = new File("input\\bai3.txt");
			FileInputStream fis = new FileInputStream(file);
			InputStreamReader isr = new InputStreamReader(fis,
					StandardCharsets.UTF_16);
			Scanner scan = new Scanner(isr);
			while(scan.hasNextLine()){
				input += scan.nextLine();// read input by line 
			}
			scan.close();

		} catch (IOException e) {
			System.err.println("Unexpected IO ERROR: " + e);
		}
		
		/* split input */
		String[] words = input.split("[ .,!]");
		/* store word to hashMap */
		for (int i = 0; i < words.length; i++) {
			if (words[i].length() > 1) {
				if (hashMap.get(words[i]) != null) {
					int value = hashMap.get(words[i]).intValue();
					value++;
					hashMap.put(words[i], value);
				} else
					hashMap.put(words[i], 1);
			}
		}

		/* convert Map to List */
		List<HashMap.Entry<String, Integer>> list = new LinkedList<HashMap.Entry<String, Integer>>(
				hashMap.entrySet());
		/* sort Map by key and value */
		Collections.sort(list,
				new Comparator<HashMap.Entry<String, Integer>>() {
					public int compare(HashMap.Entry<String, Integer> o1,
							HashMap.Entry<String, Integer> o2) {

						int value = o2.getValue() - o1.getValue();
						if (value != 0) {
							return value;
						}
						value = o1.getKey().compareTo(o2.getKey());
						return value;
					}
				});

		/* convert List to Map */
		HashMap<String, Integer> sortedMap = new LinkedHashMap<String, Integer>();
		for (Iterator<HashMap.Entry<String, Integer>> it = list.iterator(); it
				.hasNext();) {
			HashMap.Entry<String, Integer> entry = it.next();
			sortedMap.put(entry.getKey(), entry.getValue());
		}

		/* print result */
		for (HashMap.Entry<String, Integer> entry : sortedMap.entrySet()) {
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
	}
}
