package intro_to_file_io;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class MessageSaver {
	
	String message;
	FileWriter fw;

	public static void main(String[] args) {
		
		MessageSaver ms = new MessageSaver();
		ms.UI();
		ms.messageSaver();

	}
	
	public void UI()
	{
		message = JOptionPane.showInputDialog("Insert Message Here");
	}
	
	public void messageSaver() {
		try {
			fw = new FileWriter("src/intro_to_file_io/message.txt");  
			
			fw.write(message);
			
			fw.close();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	{
		
				
	}


}
