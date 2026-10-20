package store;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class StoreController {
	
	Database_verification Databaseverify = new Database_verification();
	
public boolean VerifyStore(String check_storetype) throws IOException {
		File file = new File("Types.txt");
		String storetype[]= {check_storetype};
		int value=Databaseverify.verify(file, storetype);
		
		if(value==1) {
			
			return true;
		}
		else  
			return false;		
		
		
}
}