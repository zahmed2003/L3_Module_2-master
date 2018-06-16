package intro_to_file_ioII;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class MessageSaver 
{

	
	public static void main(String[] args) {
		MessageSaver ms = new MessageSaver();
		ms.saveMessage(ms.getMessage());
		
	}
	
	public String getMessage()
	{
		String s = JOptionPane.showInputDialog("Insert a Message here");
		String s2 = "";
		
		for (char c : s.toCharArray()) {
			   s2 += Character.toString((char) (((c - 'a' + 1) % 26) + 'a'));
			}
		return s2;
	}
	
	public void saveMessage(String s)
	{
		try {
			FileWriter fw = new FileWriter("src/intro_to_file_ioII/message");
			fw.write(s);
			fw.close();
		} 
		catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
}
