package store;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Database_write_infile {

	public void Write(File file, String[] arr) throws IOException {

		FileWriter Writer = new FileWriter(file, true);
		for (String i : arr) {
			Writer.write(i);
			Writer.write("\n");
		}
		Writer.close();
	}

	
}
