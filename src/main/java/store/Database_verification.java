package store;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Database_verification {

	String line1 = null;
	String line2 = null;
	String line3 = null;
	String line4 = null;

	public int verify(File file, String[] arr) throws FileNotFoundException {

		FileReader Freader = new FileReader(file);
		Scanner read = new Scanner(file);

		if (arr.length == 3) {

			while (read.hasNext()) {
				line1 = read.nextLine();
				line2 = read.nextLine();
				line3 = read.nextLine();
				if (line1.equals(arr[0]) && line2.equals(arr[1]) && line3.equals(arr[2])) {
					break;
				}
			}

			if (line1.equalsIgnoreCase(arr[0]) && line2.equals(arr[1]) && line3.equals(arr[2])) {

				return 1;

			}

			else {

				return 0;
			}

		}

		else if (arr.length == 1) {

			while (read.hasNext()) {
				line1 = read.nextLine();
				if (line1.equalsIgnoreCase(arr[0])) {
					break;
				}
			}

			if (line1.equalsIgnoreCase(arr[0])) {
				return 1;
			} else {
				return 0;
			}
		}
		return 0;

	}

}
