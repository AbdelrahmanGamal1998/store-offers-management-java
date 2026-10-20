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

public class Admin {

	StoreController Admin_controller = new StoreController();
	User Admin_log = new User();
	ProductController AdminProd_Controller = new ProductController();
	UsersStatistics user = new UsersStatistics();
	ProductsStatistics products = new ProductsStatistics();
	Brands brand = new Brands();
	Offer offer = new Offer();

	public void Add_offer(String name, String price) throws IOException {
		offer.add_Offers(name, price);
	}

	public void Delete_offer() throws IOException {
		offer.deleteOffer();
	}

	public void Update_offer() throws IOException {
		offer.UpdatedOfferPrice();
	}

	public void Admin_brands(Scanner brand_Name, Scanner brand_Category) throws IOException {
		brand.addbrands(brand_Name, brand_Category);
	}

	public void Admin_addProduct(String name, String price, String brand, String category) throws IOException {
		Products Add_product = new Products();
		String file_Name = "AdminProducts.txt";
		Add_product.addProduct(name, price, brand, category, file_Name);
	}

	public boolean approveStore(String check_storetype) throws IOException {
		return Admin_controller.VerifyStore(check_storetype);
	}

	public boolean approveProduct(String approve) throws IOException {
		return AdminProd_Controller.VerifyProduct(approve);
	}

	public void Admin_login() throws IOException {
		Admin_log.login();
	}

	public void Sum_User__product_statistics() throws IOException {
		System.out.println(user.sum_users());
	}

	public void Maxiumum_User_statistics() throws IOException {
		user.max();
	}

	public void Average_User_product_Statistics() throws IOException {
		System.out.println(user.avg_users());
	}

	public void Min_User_statistics() throws IOException {
		user.min();
	}

	public void min_Products_statistics() throws IOException {
		products.minproduct();
	}

	public void max_Products_statistics() throws IOException {
		products.maxproduct();
	}

}
