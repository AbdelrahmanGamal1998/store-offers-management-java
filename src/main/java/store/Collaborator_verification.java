package store;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Collaborator_verification {
	
	public int check_collaborator_database(File file1, String[] arr1) throws FileNotFoundException {

		FileReader FReader = new FileReader(file1);
		Scanner read = new Scanner(file1);
		String line1 = null;
		String x, y, line2 = null;
		while (read.hasNext()) {

			line1 = read.nextLine();
			line2 = read.nextLine();
			if (line1.equals(arr1[0]) && line2.equals(arr1[1])) {
				break;
			}
		}
		y = line1;
		x = line2;
		if (y.equals(arr1[0]) && x.equals(arr1[1])) {

			return 1;

		}

		else if (y.equals(arr1[0])) {
			return 0;
		} else if (x.equals(arr1[1])) {
			return 2;

		} else {
			return 4;
		}
	}

}
