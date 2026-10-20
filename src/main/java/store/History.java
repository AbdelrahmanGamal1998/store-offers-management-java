package store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class History {

	Database_write_infile fileWrite = new Database_write_infile();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();

	public void write_Historyfile(String arr[]) throws IOException {
		File file = new File("History.txt");
		fileWrite.Write(file, arr);

	}

	public void Edited_Prtoduct_History(String ProductEdited) throws IOException {
		String productedited_in_history_file[] = { "Product Edited is " + ProductEdited,
				dtf.format(now) };
		write_Historyfile(productedited_in_history_file);
	}

	public void Deleted_Prtoduct_History(String linetoremove) throws IOException {
		String productdeleted_in_history_file[] = { "Product Deleted is " + linetoremove,
				dtf.format(now) };
		write_Historyfile(productdeleted_in_history_file);
	}

	public void Check_History() throws IOException {
		File file = new File("History.txt");
		String ReadLineInFile;
		BufferedReader bReader = new BufferedReader(new FileReader(file));
		while ((ReadLineInFile = bReader.readLine()) != null) {
			System.out.println(ReadLineInFile);
		}

	}
}
