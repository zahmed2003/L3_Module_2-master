//Copyright © 2018 by Zahir Ahmed

package intro_to_file_ioII;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class ListTracker implements ActionListener
{
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton add = new JButton();
	JButton remove = new JButton();
	JButton save = new JButton();
	JButton load = new JButton();
	
	ArrayList<String> tasks = new ArrayList<String>();
	
	public static void main(String[] args) {
		ListTracker lt = new ListTracker();
		lt.UI();
	}
	
	
	
	
	public void UI()
	{
		frame.add(panel);
		panel.add(add);
		panel.add(load);
		panel.add(remove);
		panel.add(save);
		
		
		add.setText("Add Task");
		add.addActionListener(this);
		
		load.setText("Load");
		load.addActionListener(this);
		
		remove.setText("Remove Task");
		remove.addActionListener(this);
		
		save.setText("Save");
		save.addActionListener(this);
		
		frame.setVisible(true);
		panel.setVisible(true);
		add.setVisible(true);
		remove.setVisible(true);
		save.setVisible(true);
		load.setVisible(true);
		
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}




	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add)
		{
			tasks.add(JOptionPane.showInputDialog("Input a task"));
		}
		
		if(e.getSource() == remove)
		{
			String s = JOptionPane.showInputDialog("Enter the task you wish to delete");
			for(String y: tasks)
			{
				if(s.equalsIgnoreCase(y))
				{
					tasks.remove(y);
				}
			}
			JOptionPane.showMessageDialog(null, "Operation Complete");
		}
		
		if(e.getSource() == save)
		{
			try {
				
				FileWriter fw = new FileWriter("src/intro_to_file_ioII/List");
				
				String currentList = null;
				for(String s: tasks)
				{
					currentList = currentList + System.lineSeparator() + s;
				}
				
				fw.write(currentList);
				
				fw.close();
				
				
			} catch (IOException e1) {
				e1.printStackTrace();
			}
				
		}
		if(e.getSource() == load)
		{
			
			String loadedText = null;
			
			try {
				
				BufferedReader br = new BufferedReader(new FileReader("src/intro_to_file_ioII/List"));
				
				String line;
				
				try {
					line = br.readLine();
					
					while(line != null)
					{
					loadedText = loadedText + System.lineSeparator() + line;	
					br.readLine();
					}
					
				br.close();
				JOptionPane.showMessageDialog(null, loadedText);
					
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
					
		}
		
		
	}
	
	
	
	
}