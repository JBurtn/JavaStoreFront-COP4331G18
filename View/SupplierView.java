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
	
	private JLabel warning = new JLabel();
	private JLabel pDetails = new JLabel("Product Details:");
	private JLabel pname = new JLabel("Product Name:");
	private JLabel pprice = new JLabel("Product Price:");	
	private JLabel pstock = new JLabel("Product Stock:");
	
	Account acct;
	Model current;
	
	public SupplierView(Account acct, Model current) {
		this.acct = acct;
		this.current = current;
	}
	public void Display() 
	{	
		
		
        this.setLayout(new GridLayout(7, 2, 10, 10));
                
		getname.setBackground(Color.WHITE);
		getprice.setBackground(Color.WHITE);
		getstock.setBackground(Color.WHITE);


		getDetails.setLineWrap(true);
		getDetails.setSize(200, 50);
	
		warning.setBorder(javax.swing.BorderFactory.createEmptyBorder());


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
		this.add(warning);

	}

	@Override
	public void Frame() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSubmit(Item item, JButton But) {
		// TODO Auto-generated method stub
		But.addActionListener(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent arg0) 
		    {
			Item newItem = new Item(getname.getText(), Integer.parseInt(getstock.getText()), 
			Double.parseDouble(getprice.getText()), getDetails.getText(), acct.getName());
			acct.addItem(newItem);

			View complete = new View(acct, current);
			complete.Display();
		    }
		});
	}

	@Override
	public void onItemLink(Item item, JButton but) {
		// TODO Auto-generated method stub
		
	}
}
