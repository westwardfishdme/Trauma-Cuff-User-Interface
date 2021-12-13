package userinterface;

import java.awt.GridLayout;
import java.io.FileWriter;
import java.io.IOException;
import java.awt.event.*;
import javax.swing.BorderFactory;
import javax.swing.event.MenuKeyEvent;
import java.awt.KeyboardFocusManager;
import java.awt.BorderLayout;
import java.awt.Dimension;
import org.json.simple.*;
import javax.swing.*;
import java.awt.Window.getFocusOwner;



z

	public class userinterface 
	{
		
		//all called upon objects in frame
		
		private JFrame frame = new JFrame();
		private JPanel panel = new JPanel();
		private JTextField address= new JTextField();
		private JTextField firm= new JTextField();
		private JTextField owner= new JTextField();
		private JLabel laddress = new JLabel();
		private JLabel lownername = new JLabel();
		private JLabel lfirmname = new JLabel();
		private JLabel label1= new JLabel("Address:");
		private JLabel label2= new JLabel("Owner Name:");
		private JLabel label3= new JLabel("Firm name:");
		private JLabel label4= new JLabel("MAKE SURE ALL INFO IS CORRECT BEFORE CLICKING SUBMIT!!!");
		private JButton submit = new JButton("Submit info");
	
		//
		
		//JSON file creator
		@SuppressWarnings("unchecked")
		public void jsonfilecreator(){
			JSONObject obj = new JSONObject();
			String Address = address.getText();
			String Name = owner.getText();
			String FirmName = firm.getText();
			obj.put("Address", Address);
			obj.put("Name", Name);
			obj.put("Firm Name", FirmName);
		
			try(FileWriter file = new FileWriter("userinfo.json"))
			{
				file.write(obj.toString());
				file.flush();
			}
			catch(IOException x)
			{
			x.printStackTrace();
			}
			System.out.print("\n" + obj);
		}
		//
		
		//User Interface creator
		public userinterface() 
		{
		label1.setSize(10,20);
		//
		
		//Title
		frame.setTitle("Trauma GUI");
		//
		panel.setLayout(new GridLayout(20,3,0,1));
		panel.add(label1);
		panel.add(address);
		panel.setBorder(null);
		panel.add(label2);
		panel.add(owner);
		panel.add(label3);
		panel.add(firm);
		panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
		//
		frame.add(panel, BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		System.out.print("INFO:" + "\n");
		
		//Address inputs
		
		address.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			String firm_address = address.getText();
			laddress.setText("Address: "+ firm_address);
			System.out.print( "Firm Address: " + firm_address + "\n");
			}
		});
		
		address.addFocusListener
		
		//Firm inputs
		firm.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			String firmname = firm.getText();
			lfirmname.setText("Firm Name: " + firmname);
			System.out.print( "Firm Name: " + firmname + "\n");
			}
			
		});
		
		
		owner.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
			String name = owner.getText();
			lownername.setText("Owner's Name: " + name);
			System.out.print( "Owner's Name: " + name + "\n");
			
			}
		});
		
		
		submit.addActionListener(new ActionListener()
				{ 
					public void actionPerformed(ActionEvent e) 
					{
						if(address.getText().isBlank() || owner.getText().isBlank() || firm.getText().isBlank()) 
						{
							System.out.print("\n" + "ERROR MISSING INFORMATION");
							submit.setText("ERROR: Missing Info");
						}
						else if(address.getText().isEmpty() || owner.getText().isEmpty() || firm.getText().isEmpty()) 
						{
							System.out.print("\n" + "ERROR MISSING INFORMATION");
							submit.setText("ERROR: Missing Info");
						}
						else
						{
						submit.setText("Submit");
						jsonfilecreator();
						}
					}
				});
		
		
		panel.add(laddress);
		panel.add(lownername);
		panel.add(lfirmname);
		frame.setSize(new Dimension(500,500));
		frame.validate();
		frame.setVisible(true);
		panel.add(label4);
		panel.add(submit);
		
		//makes Enter Key go to next line:
		Action enter = new AbstractAction()
				{

					@Override
					public void actionPerformed(ActionEvent e) {
					KeyboardFocusManager KeyChecker = KeyboardFocusManager.getCurrentKeyboardFocusManager();
					KeyChecker.getFocusOwner.transferFocus();
					}
				
				}
		

	}
//

//calls interface to frame.
		public static void main(String[] args) throws Exception
		{
		new userinterface();
		
		}
//
			
}



