package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import Model.*;

public class SupplierWindow{
	private JTextField getname;
	private JTextField getprice;
	private JTextField getstock;
	private JTextArea Description;

	private JFrame Frame;
	private JPanel panel;
	private Item item;
	private Account acct;
	
	public SupplierWindow(Account acct, Item item) {

		this.item = item;
		this.acct = acct;
		
		Frame = new JFrame();
		panel = new JPanel();
		
		panel = new JPanel();
    	panel.setLayout(new GridLayout(3, 2, 10, 10));	
        panel.setBackground(Color.WHITE);
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
              	

	}
	
	public void createItemWindow() 
	{
		JFrame Frame = new JFrame();
		JPanel Panel = new JPanel();
		
		Panel.setLayout(new GridLayout(6, 2, 10, 10));	
		JButton Submit = new JButton("Submit");
		JButton Cancel = new JButton("Cancel");
        
        getname = new JTextField(item.getName());
        getname.setEditable(true);
        getname.setBackground(Color.WHITE);
        
        getprice = new JTextField(Double.toString(item.getPrice()) );
        getprice.setEditable(true);
        getprice.setBackground(Color.WHITE);
        
        getstock = new JTextField();
        getstock.setEditable(true);
        getstock.setBackground(Color.WHITE);
        
        Description = new JTextArea(Description.getText());
        Description.setLineWrap(true);
        Description.setSize(200, 50);
        Description.setEditable(true);
        
        JLabel warning = new JLabel("");
        warning.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        JLabel pname = new JLabel("Product Name:");
        pname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Panel.add(pname);
        Panel.add(getname);
        
        JLabel pprice = new JLabel("Product Price:");
        pprice.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Panel.add(pprice);
        Panel.add(getprice);
        
        JLabel pstock = new JLabel("Product Stock:");
        pstock.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Panel.add(pstock);
        Panel.add(getstock);

        JLabel pDetails = new JLabel("Product Details:");
        pDetails.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        Panel.add(pDetails);
        Panel.add(Description);
        Panel.add(warning);
        
        Cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.dispose();
			}
		});
        
        Submit.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.dispose();

				Item newItem = new Item(getname.getText(), Integer.parseInt(getstock.getText()), 
				Double.parseDouble(getprice.getText()), Description.getText(), acct.getName());
				acct.addItem(newItem);
			}
		});
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2, 10, 10));
        panel2.add(Submit);
        panel2.add(Cancel);
        Panel.add(panel2, BorderLayout.SOUTH);
        
        Frame.add(Panel);
    	Frame.setPreferredSize(new Dimension(800, 400));
        Frame.setResizable(true);
        Frame.pack();
        Frame.setVisible(true);
        Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
