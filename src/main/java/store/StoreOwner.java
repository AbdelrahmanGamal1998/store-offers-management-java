package store;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Handler;
import java.util.Random;
import java.awt.List;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StoreOwner extends User {

	private String product_Name;
	Store Add_store = new Store();
	Products StoreOwner_Add = new Products();
	Database_write_infile File_write = new Database_write_infile();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();
	User StoreOwn = new User();
	StoreOwner_Delete item = new StoreOwner_Delete();
	StoreOwner_Edit update = new StoreOwner_Edit();
	History hist = new History();
	Buy_Offer buuy = new Buy_Offer();

	public String getProduct_Name() {
		return product_Name;
	}

	public void setProduct_Name(String product_Name) {
		this.product_Name = product_Name;
	}

	public void Buy_Product(User user) throws IOException {
		buuy.BuyProduct(user);
	}

	public void add_Collaborator(String Collaborator_name, String Store_Name) throws IOException {
		File file = new File("Collaborator.txt");
		System.out.println(" Collaborator Added Successfuly");
		String arr[] = { Collaborator_name, Store_Name };
		File_write.Write(file, arr);
	}

	public void addStore() throws IOException {
		Add_store.IsOnline();
	}

	public void StoreOwner_addProduct(String name, String price, String brand, String category) throws IOException {
		String file_Name = "StoreProducts.txt";
		setProduct_Name(StoreOwner_Add.addProduct(name, price, brand, category, file_Name));
		String str[] = { "Product added is " + getProduct_Name(), dtf.format(now) };
		hist.write_Historyfile(str);
	}
	
	public void StoreOwner_Deleteproduct() throws IOException {
		item.deleteProduct();
	}

	public void StoreOwner_Updateproduct() throws IOException {
		update.UpdatedProductPrice();
	}

	public void StoreOwner_login() throws IOException {
		StoreOwn.login();
	}

	public void View_History() throws IOException {
		hist.Check_History();
	}
	
}