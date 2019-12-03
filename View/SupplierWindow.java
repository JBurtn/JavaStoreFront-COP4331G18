package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import Model.Item;

public class SupplierWindow extends ItemPanel
{
	JTextField getname;
	JTextField getprice;
	JTextField getstock;
	JTextArea getDetails;
	JButton remove;
	
	public SupplierWindow(Item item) {
		super(item);
		getDetails = new JTextArea(item.getDescription());
		JTextField Price = new JTextField("Price:$ " + item.getPrice());
		remove = new JButton("Remove");
		panel.add(name);
       	panel.add(Price);
       	panel.add(Stock);
       	panel.add(Description);
       	panel.add(remove);
       	panel.add(new JLabel());
       	panel.setBackground(Color.WHITE);
       	panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
		name.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createItemWindow();
			}
		});
		remove.addActionListener(new ActionListener() {	
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				Sellpanel.remove(panel);
				panel.setOpaque(false);
				panel.setBorder(new EmptyBorder(0, 0, 0, 0));
				Sellpanel.revalidate();
				Sellpanel.repaint();
			}
		});
	}
	
	@Override
	public void createItemWindow() 
	{
		panel.removeAll();
        panel.setLayout(new GridLayout(5, 2, 10, 10));
        
        
        getname = new JTextField(name.getText());
        getname.setEditable(true);
        getname.setBackground(Color.WHITE);
        
        String []p = Price.getText().split(" ");
        getprice = new JTextField(p[1]);
        getprice.setEditable(true);
        getprice.setBackground(Color.WHITE);
        
        String []s = Stock.getText().split(" ");
        getstock = new JTextField(s[1]);
        getstock.setEditable(true);
        getstock.setBackground(Color.WHITE);
        
        getDetails = new JTextArea();
        getDetails.setLineWrap(true);
        getDetails.setSize(200, 50);
        getDetails.setEditable(true);
        
        JLabel warning = new JLabel("test");
        warning.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        
        JLabel pname = new JLabel("Product Name:");
        pname.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        panel.add(pname);
        panel.add(getname);
        
        JLabel pprice = new JLabel("Product Price:");
        pprice.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        panel.add(pprice);
        panel.add(getprice);
        
        JLabel pstock = new JLabel("Product Stock:");
        pstock.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        panel.add(pstock);
        panel.add(getstock);

        JLabel pDetails = new JLabel("Product Details:");
        pDetails.setBorder(javax.swing.BorderFactory.createEmptyBorder());
        panel.add(pDetails);
        panel.add(getDetails);
        panel.add(warning);
        
        JButton Submit = new JButton("Submit");
        JButton Cancel = new JButton("Cancel");
        
        Cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.setLayout(new GridLayout(3, 2, 10, 10));	
				panel.add(name);
		       	panel.add(Price);
		       	panel.add(Stock);
		       	panel.add(Description);
		       	panel.add(remove);
		       	panel.add(new JLabel());
		       	panel.setBackground(Color.WHITE);
		       	panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
		       	panel.revalidate();
		       	panel.repaint();
			}
		});
        Submit.addActionListener(new ActionListener() {		
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();
				panel.setLayout(new GridLayout(3, 2, 10, 10));	
				name.setText(getname.getText());
				panel.add(name);
				Price.setText(p[0] + " " + getprice.getText());
				panel.add(Price);
				Stock.setText(s[0] + " " + getstock.getText());
		       	panel.add(Stock);
		       	Description.setText(getDetails.getText());
		       	panel.add(Description);
		       	panel.add(remove);
		       	panel.add(new JLabel());
		       	panel.setBackground(Color.WHITE);
		       	panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
		       	panel.revalidate();
		       	panel.repaint();
	
			}
		});
        
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2, 10, 10));
        panel2.add(Submit);
        panel2.add(Cancel);
        panel.add(panel2, BorderLayout.SOUTH);
	}
}
