package intro_to_file_ioII;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class MessageSelector 
{
public static void main(String[] args) {
	
}


public void selectMessage()
{
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader("src/intro_to_file_ioII/message"));
			
			String line;
			try {
				line = br.readLine();
				
				while(line != null)
				{
					System.out.println(line);
					line = br.readLine();
				}
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
}


}
