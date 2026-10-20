package store;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Products {

	private String Name;
	private String Price;
	private String Brand;
	private String Category;
	Database_write_infile File_write = new Database_write_infile();

	public Products(String name, String price, String brand, String category) {
		super();
		Name = name;
		Price = price;
		Brand = brand;
		Category = category;
	}

	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		this.Name = name;
	}

	public String getPrice() {
		return Price;
	}

	public void setPrice(String price) {
		this.Price = price;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		this.Category = category;
	}

	public String addProduct(String name, String price, String brand, String category, String file_Name)throws IOException {
		Admin Approve_products = new Admin();
		File file = new File(file_Name);
		setName(name);
		setPrice(price);
		setBrand(brand);
		setCategory(category.toLowerCase());
		if ("StoreProducts.txt".equals(file_Name)) {
			if (Approve_products.approveProduct(getName()) == true) {
				String arr[] = { getName(), getPrice(), getBrand(), getCategory() };
				File_write.Write(file, arr);
				System.out.println("Product Is Added Successfuly");
				String product_Name = getName();
				return product_Name;
			} else {
				System.out.println("Product Is Not Approved");
				return null;
			}
		} else if ("AdminProducts.txt".equals(file_Name)) {
			String arr1[] = { getName(), getPrice(), getBrand(), getCategory() };
			File_write.Write(file, arr1);
			System.out.println("Product Is Added Successfuly");
		} else
			System.out.println("Sorry,Can't Add Product");
		return null;
	}

}