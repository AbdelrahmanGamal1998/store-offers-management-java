package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class StoreOwner_Delete {

	Database_write_infile File = new Database_write_infile();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	History delete_History = new History();
	Delete_view Delete_view = new Delete_view();

	public void deleteProduct() throws IOException {
		File inputFile = new File("StoreProducts.txt");
		File tempFile = new File("newFile.txt");

		BufferedReader reader = new BufferedReader(new FileReader(inputFile));
		BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

		String lineToRemove = Delete_view.Delete();
		String line0;
		String line1;
		String line2;
		String line3;

		while ((line0 = reader.readLine()) != null & (line1 = reader.readLine()) != null
				& (line2 = reader.readLine()) != null & (line3 = reader.readLine()) != null) {
			// trim newline when comparing with lineToRemove
			String trimmedLine0 = line0.trim();
			String trimmedLine1 = line1.trim();
			String trimmedLine2 = line2.trim();
			String trimmedLine3 = line3.trim();
			if (trimmedLine0.equals(lineToRemove))
				continue;
			String arr[] = { line0, line1, line2, line3 };
			File.Write(tempFile, arr);

		}
		writer.close();
		reader.close();
		inputFile.delete();
		boolean successful = tempFile.renameTo(inputFile);
		delete_History.Deleted_Prtoduct_History(lineToRemove);
		System.out.println("Product Is deleted  Successfuly");
	}

}