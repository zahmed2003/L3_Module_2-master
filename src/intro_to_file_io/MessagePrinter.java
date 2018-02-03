package intro_to_file_io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;

public class MessagePrinter {
	
	JFileChooser jfc;
	FileReader fr;

	public static void main(String[] args) 
	{
		MessagePrinter mp = new MessagePrinter();
		try {
			mp.UI();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}
	
	public void UI() throws IOException
	{
		jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			
		}
			String fileName = jfc.getSelectedFile().getAbsolutePath();
			
			try {
				fr = new FileReader(fileName);
				
				int c = fr.read();
				while(c != -1){
					System.out.print((char)c);
					c = fr.read();
					
				}
				fr.close();
				
			} catch (FileNotFoundException e) {
				
				e.printStackTrace();
			}
			
	}
	
}