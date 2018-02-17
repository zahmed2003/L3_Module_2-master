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
				fw = new FileWriter(fileName, true);
				fw.write("//Copyright © 2018 by Zahir Ahmed");
				fw.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
					
		}
	}
	
	}

