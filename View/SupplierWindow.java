package views;

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
import Model.Item;

public class SupplierWindow extends ItemPanel
{
	JTextField getname;
	JTextField getprice;
	JTextField getstock;
	JTextArea getDetails;
	JButton remove;
	int i;
	
	public SupplierWindow(Item item, int j) {
		super(item);
		Price = new JLabel("Price:$ " + item.getPrice());
		Stock = new JLabel("Stock: " + item.getStock());
		name = new JButton(item.getName());
		Description = new JLabel(item.getDetails());
		submit = new JButton("Submit");
		Qty = new JTextField();
		Qty.setEditable(true);    	
		panel = new JPanel();
    	panel.setLayout(new GridLayout(3, 2, 10, 10));	
        panel.setBackground(Color.WHITE);
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        
		remove = new JButton("Remove");
		panel.add(name);
       	panel.add(Price);
       	panel.add(Stock);
       	panel.add(Description);
       	panel.add(remove);
       	
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
				Sellpanel.revalidate();
				Sellpanel.repaint();
			}
		});
	}
	
	@Override
	public void createItemWindow() 
	{
		JFrame Frame = new JFrame();
		JPanel Panel = new JPanel();
		
		Panel.setLayout(new GridLayout(6, 2, 10, 10));	
		JButton Submit = new JButton("Submit");
		JButton Cancel = new JButton("Cancel");
        
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
        
        getDetails = new JTextArea(Description.getText());
        getDetails.setLineWrap(true);
        getDetails.setSize(200, 50);
        getDetails.setEditable(true);
        
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
        Panel.add(getDetails);
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
        Panel.add(panel2, BorderLayout.SOUTH);
        
        Frame.add(Panel);
    	Frame.setPreferredSize(new Dimension(800, 400));
        Frame.setResizable(true);
        Frame.pack();
        Frame.setVisible(true);
        Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
