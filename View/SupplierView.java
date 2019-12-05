package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Model.*;

public class SupplierView extends JPanel implements Display
{	
	private JTextField getname = new JTextField();
	private JTextField getprice = new JTextField();
	private JTextField getstock = new JTextField();	
	private JTextArea getDetails = new JTextArea();
	private JButton submit = new JButton();
	
	private JLabel warning = new JLabel();
	private JLabel pDetails = new JLabel("Product Details:");
	private JLabel pname = new JLabel("Product Name:");
	private JLabel pprice = new JLabel("Product Price:");	
	private JLabel pstock = new JLabel("Product Stock:");
	
	Account acct;
	
	public SupplierView(Account acct) {
		this.acct = acct;
	}
	public void Display(Account acct, Model current) 
	{	
		
		GridLayout grid = new GridLayout(7,2, 10, 10);
        this.setLayout(grid);
                
		getname.setBackground(Color.WHITE);
		getprice.setBackground(Color.WHITE);
		getstock.setBackground(Color.WHITE);


		getDetails.setLineWrap(true);
		getDetails.setSize(200, 50);
	
		warning.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		submit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
		    	Item newItem = new Item(getname.getText(), Integer.parseInt(getstock.getText()), 
		    	Double.parseDouble(getprice.getText()), getDetails.getText(), acct.getName());
		    	acct.addItem(newItem);
			}
			
		});

		pname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.add(pname);
		this.add(getname);


		pprice.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.add(pprice);
		this.add(getprice);

		pstock.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.add(pstock);
		this.add(getstock);

		pDetails.setBorder(javax.swing.BorderFactory.createEmptyBorder());
		this.add(pDetails);
		this.add(getDetails);
		
		this.add(submit);
		
		this.add(warning);

	}

	@Override
	public void onSubmit(ItemPanel it, JButton But) {
		// TODO Auto-generated method stub
		
		But.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) 
		    {
		    	Item replacement = it.getItem().clone();
		    	replacement.setStock(Integer.parseInt(it.readQty()));
		    	acct.setItem(it.getItem(),  replacement);
		    }
		});
	}

	@Override
	public void onItemLink(ItemPanel it, JButton but) {
		// TODO Auto-generated method stub
		but.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) 
		    {
		    	SupplierWindow itemWindow = new SupplierWindow(acct, it.getItem());
		    	itemWindow.createItemWindow();
		    }
		});
	}
}
