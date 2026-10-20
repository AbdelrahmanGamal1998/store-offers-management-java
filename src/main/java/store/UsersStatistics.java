package store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;

public class UsersStatistics  {
	
	Database_map_file databasemap=new Database_map_file();
	
public int sum_users() throws IOException {
		File file = new File("SoldProducts.txt"); 
	 
		BufferedReader Breader = new BufferedReader(new FileReader(file)); 
		 String user; 
		 String productname;
		 String price;
		 String Breaderand;
		 String category;
		 int  sum_users=0;
		while((user = Breader.readLine()) != null&(productname = Breader.readLine()) != null&(price = Breader.readLine()) != null &(Breaderand = Breader.readLine()) != null&(category = Breader.readLine()) != null) {
			sum_users++;
	}
		
		return sum_users;
		
	}


public int avg_users() throws IOException {
		int sum = sum_users();
		return sum/2 ;
		
	}

public void max() throws IOException {
	File file=new File("SoldProducts.txt");
	System.out.println("Max Users : \n " + databasemap.Sort(0, file, "MAX"));	
}
	
public void min() throws IOException {
	File file=new File("SoldProducts.txt");
	System.out.println("Min Users : \n " + databasemap.Sort(0, file, "min"));
}

}
