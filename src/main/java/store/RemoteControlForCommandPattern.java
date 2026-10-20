package store;

import java.io.IOException;

public class RemoteControlForCommandPattern {
	Command Button;

	public RemoteControlForCommandPattern(Command button) {
		super();
		Button = button;
	}

	public RemoteControlForCommandPattern() {
		// TODO Auto-generated constructor stub
	}

	public Command getButton() {
		return Button;
	}


	public void setButton(Command button) {
		Button = button;
	}
	
	

	
	public void ButtonPressed() throws IOException{
		Button.execute();
	}

}
