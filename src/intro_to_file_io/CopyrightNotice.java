package intro_to_file_io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class CopyrightNotice 
{

	FileWriter fw;
	JFileChooser jfc;
	String fileName;
	BufferedReader br;
	
	public static void main(String[] args) 
	{
		CopyrightNotice cn = new CopyrightNotice();
		cn.copyright();
	}
	
	public void copyright()
	{
		jfc = new JFileChooser();
		int returnVal = jfc.showOpenDialog(null);
		if (returnVal == JFileChooser.APPROVE_OPTION) {
			fileName = jfc.getSelectedFile().getAbsolutePath();
			
			try {
				fw = new FileWriter(fileName);
				
				br = new BufferedReader(new FileReader(fileName));
				
				try {
					BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_io/test.txt"));
					
					String line = br.readLine();
					while(line != null){
						System.out.println(line);
						line = br.readLine();
					}
					
					br.close();
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				fw.close();
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}
	
}
