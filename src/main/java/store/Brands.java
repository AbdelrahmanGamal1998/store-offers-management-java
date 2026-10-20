package store;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Brands {

	private String brandname;
	private String brandcategory;
	Database_write_infile write_File = new Database_write_infile();

	public String getBrandname() {
		return brandname;
	}

	public void setBrandname(String brandname) {
		this.brandname = brandname;
	}

	public String getBrandcategory() {
		return brandcategory;
	}

	public void setBrandcategory(String brandcategory) {
		this.brandcategory = brandcategory;
	}

	public void addbrands(Scanner brand_Name, Scanner brand_Category) throws IOException {
		File file = new File("AdminBrands.txt");
		this.setBrandname(brand_Name.next());
		this.setBrandcategory(brand_Category.next().toLowerCase());
		String arr[] = { this.getBrandname(), this.getBrandcategory() };
		write_File.Write(file, arr);
		System.out.println("Brand Is Added Successfuly");

	}

}
