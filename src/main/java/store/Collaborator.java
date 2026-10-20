package store;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.TimerTask;
import java.time.format.DateTimeFormatter;
import java.time.LocalDateTime;
import java.util.Scanner;

public class Collaborator extends TimerTask {
	StoreOwner_Statistics Collaborator_stat = new StoreOwner_Statistics();
	StoreOwner collaborator = new StoreOwner();
	Collaborator_controller Collaborator_cont = new Collaborator_controller();
	History history = new History();
	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
	LocalDateTime now = LocalDateTime.now();

	public void addProduct_bycollaborator(String name, String price, String brand, String category)
			throws IOException {
		collaborator.StoreOwner_addProduct(name, price, brand, category);
	}

	public void Statistics_bycollaborator_writeinhistory() throws IOException {
		String arr[] = { "Statistacs viewed by collaborator", dtf.format(now) };
		history.write_Historyfile(arr);

	}

	public void Updateproduct_by_collaborator() throws IOException {
		collaborator.StoreOwner_Updateproduct();
	}

	public void Deleteproduct_by_collaborator() throws IOException {
		collaborator.StoreOwner_Deleteproduct();
	}

	@Override
	public void run() {
		try {
			Statistics_bycollaborator_writeinhistory();
		} catch (IOException exception) {
			// TODO Auto-generated catch block
			exception.printStackTrace();
		}

		System.out.println("the sold products Statistics by Collaborator");
		try {
			Collaborator_stat.view_Sold_Products_by_StoreOwner();
			// System.out.println(Collaborator_stat.sum_users());
		} catch (IOException excp) {
			// TODO Auto-generated catch block
			excp.printStackTrace();
		}
		System.out.println("the  Most Ordered Product Statistics  by Collaborator");
		try {
			Collaborator_stat.Most_Ordered_Product_by_StoreOwner();

		} catch (IOException excpp) {
			// TODO Auto-generated catch block
			excpp.printStackTrace();
		}
		System.out.println(" Average  Ordered products  in our websites Statistics");
		try {
			Collaborator_stat.average_Ordered_Product_by_StoreOwner();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void Collabrorator_login(String username, String store_Name) throws IOException {
		Collaborator_cont.verify_Collaborator(username, store_Name);
	}

}