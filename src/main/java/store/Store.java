package store;


import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.TimerTask;

public class Store {

	private String storeName;
	private String storeType;
	private String storeAddress;
	Admin Approve_store = new Admin();
	Database_write_infile File_Writer = new Database_write_infile();

	public String getStoreType() {
		return storeType;
	}

	public void setStoreType(String storeType) {
		this.storeType = storeType;
	}

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getStoreAddress() {
		return storeAddress;
	}

	public void setStoreAddress(String storeAddress) {
		this.storeAddress = storeAddress;
	}

	public void IsOnline() throws IOException {
		File file = new File("Store.txt");
		System.out.println("Online? if yes press 1");
		Scanner input1 = Input.scanner();
		int choice = input1.nextInt();
		if (choice == 1) {
			System.out.println("Enter store name");
			Scanner Sname = Input.scanner();
			this.setStoreName(Sname.next());
			System.out.println("Enter store Type");
			Scanner Stype = Input.scanner();
			this.setStoreType(Stype.next());
			Approve_store.approveStore(this.getStoreType());
			if (Approve_store.approveStore(this.getStoreType()) == true) {
				String Store_info[] = { this.getStoreName(), this.getStoreType() };
				File_Writer.Write(file, Store_info);

				System.out.println("Store Created!");

			} else
				System.out.println("Store doesn't meet criteria!");
		} else {
			System.out.println("Enter store name");
			Scanner SName = Input.scanner();
			this.setStoreName(SName.next());
			System.out.println("Enter store Type");
			Scanner SType = Input.scanner();
			this.setStoreType(SType.next());
			System.out.println("Enter store address");
			Scanner SAddress = Input.scanner();
			this.setStoreAddress(SAddress.next());

			Approve_store.approveStore(this.getStoreType());
			if (Approve_store.approveStore(this.getStoreType()) == true) {
				String Store_info[] = { this.getStoreName(), this.getStoreType(), this.getStoreAddress() };
				File_Writer.Write(file, Store_info);

				System.out.println("Store Created!");

			} else
				System.out.println("Store doesn't meet criteria!");
		}

	}

}