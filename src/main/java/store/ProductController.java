package store;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ProductController {
	
	Database_verification Databaseverify = new Database_verification();

	public boolean VerifyProduct(String i) throws IOException {
		File file = new File("AdminProducts.txt");
		String arr[] = { i };
		int value = Databaseverify.verify(file, arr);

		if (value == 1) {

			return true;
		} else
			return false;
	}
}