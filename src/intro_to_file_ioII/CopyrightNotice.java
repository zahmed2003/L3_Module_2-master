//Copyright © 2018 by Zahir Ahmed

package intro_to_file_ioII;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class CopyrightNotice 
{
	JFileChooser jfc;
	BufferedReader br;
	FileWriter fw;
	String text = "//Copyright © 2018 by Zahir Ahmed" + System.lineSeparator();
	
	ArrayList<String> file = new ArrayList<String>();
	
	public static void main(String[] args) 
	{
		
		CopyrightNotice cn = new CopyrightNotice();
		cn.addNotice();
		
	}
	
	
	public void addNotice()
	{
		jfc = new JFileChooser();
		int returnValue = jfc.showOpenDialog(null);
		if(returnValue == JFileChooser.APPROVE_OPTION)
		{
			try
			{
				br = new BufferedReader(new FileReader(jfc.getSelectedFile().getAbsolutePath()));
				try 
				{
					String c = br.readLine();
					
					while(c != null)
					{
						file.add(c);
						c = br.readLine();
					}
					
					for(int i = 0; i < file.size(); i++)
					{
						text = text + System.lineSeparator() + file.get(i);
					}
					
					
					fw = new FileWriter(jfc.getSelectedFile().getAbsolutePath());
					fw.write(text);
					fw.close();
								
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
	}
}