package views;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

import project.Inventory;

public class ConsumerView 
{
	JButton CheckoutBtn;
	JButton Remove;
	JList <String> list;
	CheckoutView checkOut;
	JFrame frame = new JFrame();
	public ConsumerView(Account acct)
	{
		//checkOut = new CheckoutView(new Inventory().getUserInventory("q"));
		checkOut = new CheckoutView(acct.getItemList());
		String [] names = new String [checkOut.ItemBox.size()];
		for(int i = 0; i < checkOut.ItemBox.size(); i++)
		{
			names[i] = checkOut.ItemBox.get(i).getName();
		}
		
		Remove = new JButton("Remove");
		Remove.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				acct.removeItem(checkOut.ItemBox.get(list.getSelectedIndex()));
				frame.dispose();
				ConsumerView refreshCart = new ConsumerView(acct);
				refreshCart.Display();
			}
		});
		list = new JList<>(names);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
	}
	//public ConsumerView() {}
	
	void createCheckout()
	{
		JFrame Frame = new JFrame();
		JPanel panel = new JPanel();
	    panel.setLayout(new GridLayout(8, 2, 10, 10));
	    checkOut.checkout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				Frame.setLayout(new BorderLayout());
				Frame.add(panel);
		    	Frame.setPreferredSize(new Dimension(600, 400));
		        Frame.setResizable(true);
		        Frame.pack();
		        Frame.setVisible(true);
		        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				
			}
		});
	    JButton Submit = new JButton("Finalize Order");
	    JButton Cancel = new JButton("Cancel");
	    Cancel.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.dispose();
			}
		});
	    Submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.setLayout(new GridLayout(1, 1));
				panel.add(new JLabel("Thank You For Shopping With Us."));
				panel.revalidate();
				panel.repaint();
				Frame.setSize(new Dimension(350, 200));
			}
		});
	    
	    JLabel name = new JLabel("Name:");
	    JLabel address = new JLabel("Address:");
	    JLabel city = new JLabel("City:");
	    JLabel state = new JLabel("State:");
	    JLabel country = new JLabel("Country:");
	    JLabel card = new JLabel("Card Number");
	    JLabel Cost = new JLabel("Total Cost: $");// + totalCost);//ADD MONEY VALUE HERE

		JTextField setName = new JTextField();
		JTextField setAddress = new JTextField();
        JTextField setCity = new JTextField();
        JTextField setState = new JTextField();
        JTextField setCountry = new JTextField();
        JTextField setCard = new JTextField();
        
        panel.add(Cost);
        panel.add(new JLabel());
        panel.add(name);
        panel.add(setName);
        
        panel.add(address);
        panel.add(setAddress);
        
        panel.add(city);
        panel.add(setCity);
       
        panel.add(state);
        panel.add(setState);
        
        panel.add(country);
        panel.add(setCountry);
        
        panel.add(card);
        panel.add(setCard);
        panel.add(Submit);
        panel.add(Cancel);
	}
	
	
	void Display()
	{
		createCheckout();
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 2));
		panel.add(checkOut.checkout);
		panel.add(Remove);
		
		frame.setLayout(new BorderLayout());
		frame.add(list, BorderLayout.CENTER);
		frame.add(panel, BorderLayout.SOUTH);
    	frame.setPreferredSize(new Dimension(800, 400));
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}