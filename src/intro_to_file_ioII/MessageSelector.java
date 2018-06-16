package intro_to_file_ioII;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MessageSelector 
{
	
	FileReader fr;
	JFileChooser jfc;
	
public static void main(String[] args) {
	MessageSelector ms = new MessageSelector();
	System.out.println(ms.selectMessage());
}

public String selectMessage()
{
		jfc = new JFileChooser();
		String message = null;
		
		int returnValue = jfc.showOpenDialog(null);
		if(returnValue == JFileChooser.APPROVE_OPTION)
		{
			try 
			{
				fr = new FileReader(jfc.getSelectedFile().getAbsolutePath());
				int c;
				try {
					c = fr.read();
					while(c != -1)
					{
						message = message + (char)c;
					}
					fr.close();
				} 
				catch (IOException e) 
				{
					e.printStackTrace();
				}
			} 
			catch (FileNotFoundException e) 
			{
				e.printStackTrace();
			}
		}
		return message;
}


public String decryptMessage(String message)
{
	String decrypt = null;
	for (char c : message.toCharArray()) 
		{
		   decrypt += Character.toString((char) (((c + 'a' + 1) % 26) - 'a'));
		}
	
	return decrypt;
}

}
