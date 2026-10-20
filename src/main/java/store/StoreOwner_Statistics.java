package store;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.TimerTask;

public class StoreOwner_Statistics extends TimerTask {
	
	private int products_views;
	private int sold_products;
	private int orderd_Product;
	Admin StoreOwner_View_Statisitcs = new Admin();

	public int getOrderd_Product() {
		return orderd_Product;
	}

	public void setOrderd_Product(int orderd_Product) {
		this.orderd_Product = 0;
	}

	public int getProducts_views() {
		return products_views;
	}

	public void setProducts_views(int products_views) {
		this.products_views = 0;
	}

	public int getSold_products() {
		return sold_products;
	}

	public void setSold_products(int sold_products) {
		this.sold_products = 0;
	}

	public void view_Sold_Products_by_StoreOwner() throws IOException {
		StoreOwner_View_Statisitcs.Sum_User__product_statistics();
	}

	public void Most_Ordered_Product_by_StoreOwner() throws IOException {
		StoreOwner_View_Statisitcs.max_Products_statistics();
	}

	public void average_Ordered_Product_by_StoreOwner() throws IOException {
		StoreOwner_View_Statisitcs.Average_User_product_Statistics();
	}

	@Override
	public void run() {

		System.out.println("the sold products Statistics");
		try {
			view_Sold_Products_by_StoreOwner();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("the Most Ordered Product Statistics");
		try {
			Most_Ordered_Product_by_StoreOwner();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			System.out.println("Average  Ordered products  in our websites Statistics");
			average_Ordered_Product_by_StoreOwner();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
