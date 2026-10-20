package store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.TimerTask;

public class User_Controller  {
	
public User verify(String type ,String uName,String upassword) throws IOException {
		File file = new File("Users.txt");
		Database_verification Databaseverify = new Database_verification();
			String arr[]= { type,uName,upassword };
		int value=Databaseverify.verify(file, arr);
		User user=new User();
		user.setName(uName);
		
		if(value==1) {		
			 System.out.println("Access Granted! Welcome!");
			 return user;		
		}
		else {
			System.out.println("Invalid Username & Password!");
			System.exit(0);
			 return null;
		}
	     
}

public boolean verify_Account(String type,String username,String password) throws IOException {
	File check = new File("Users.txt");
	BufferedReader reader = new BufferedReader(new FileReader(check));
	String Type_line,UserName_line,Password_line;
	while((Type_line = reader.readLine())!=null & (UserName_line = reader.readLine())!=null & (Password_line = reader.readLine())!=null) {
		if(UserName_line.equals(username)) {
			System.out.println("UserName Is Used");
			return false;
		}
	}
	return true;
}
			  
}