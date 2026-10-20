package store;

import java.util.Scanner;
import java.io.*;
import java.nio.file.FileSystems;
import java.nio.file.Path;
public class User {
	private String name;
	private String pass;
	private String email;
	private String username;
	private String Type;
	private String phoneno;
	public String Username_verify ;
	public String Password_verify ;
	public String type_verify ;
	User_Controller User_verify = new User_Controller();
	Database_write_infile write = new Database_write_infile();

public String getName() {
		return name;
}
	
public void setName(String name) {
		this.name = name;
}

public void setPass(String pass) {
	this.pass = pass;
}

public String getPass() {
		return pass;
}
	
public String getEmail() {
		return email;
}
	
public void setEmail(String email) {
		this.email = email;
}
	
public void setUsername(String username) {
	this.username = username;
}

public String getUsername() {
		return username;
}
	
public String getPhoneno() {
		return phoneno;
}
	
public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
}
public String getType() {
	return Type;
}

public void setType(String type) {
	Type = type;
}

public User login() throws IOException {
	    User user=new User();
		Scanner input1 = Input.scanner();
		System.out.println("Enter Username : ");
		Username_verify = input1.next();
		Scanner input2 = Input.scanner();
	    System.out.println("Enter Password : ");	    
	    Password_verify = input2.next();
	    Scanner input3 = Input.scanner();
		System.out.println("Enter Your type Customer? / StoreOwner? ");
		type_verify = input3.next().toLowerCase();
		user=User_verify.verify(type_verify,Username_verify,Password_verify);
		if(user!=null) {
			return user;
		}
		return null;
}
	 
public void createaccount() throws IOException{		
		File file = new File("Users.txt");
		System.out.println("Enter username");
		Scanner username = Input.scanner();
		this.setUsername(username.next());
		System.out.println("Enter password");
		Scanner password = Input.scanner();
		this.setPass(password.next());
		System.out.println("Enter Your type Customer? / StoreOwner? ");
		Scanner type = Input.scanner();
		this.setType(type.next().toLowerCase());
		System.out.println("Enter email");
		Scanner email = Input.scanner();
		this.setEmail(email.next());
		System.out.println("Enter phoneno");
		Scanner phoneno = Input.scanner();
		this.setPhoneno(phoneno.next());
		if(User_verify.verify_Account(getType(),getUsername(),getPass())==true) {
		String arr[]= {this.getType(), this.getUsername(), this.getPass()};
		write.Write(file, arr);
		System.out.println("Account Created Successfuly");
		System.out.println("Now You Can Login To Our Stores");
		}
		else
			System.out.println("Account Can't Be Created");
}
	
}