package store;

import java.io.IOException;

public class UndoAddedProductCommand  implements Command {
	 private StoreOwner StoreOwner;
	public UndoAddedProductCommand(StoreOwner storeOwner) {
		super();
		StoreOwner = storeOwner;
	}
	@Override
	public void execute() throws IOException {
		StoreOwner.StoreOwner_Deleteproduct();
		
	}

}
