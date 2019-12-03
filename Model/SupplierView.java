package views;

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

public class SupplierView extends View
{	

	public void Display(JFrame frame, int Type) 
	{	
		
		frame.dispose();
		JFrame Frame = new JFrame();
		JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2, 10, 10));
                
        JTextField getname = new JTextField();
        getname.setEditable(true);
        getname.setBackground(Color.WHITE);
        
        JTextField getprice = new JTextField();
        getprice.setEditable(true);
        getprice.setBackground(Color.WHITE);
        
        JTextField getstock = new JTextField();
        getstock.setEditable(true);
        getstock.setBackground(Color.WHITE);
        
        JTextArea getDetails = new JTextArea();
        getDetails.setLineWrap(true);
        getDetails.setSize(200, 50);
        getDetails.setEditable(true);
        
        JLabel warning = new JLabel();
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
            public void actionPerformed(ActionEvent arg0) 
            {
            	Frame.dispose();
            	frame.dispose();
            	View test = new View(Type);
            	test.Display();
            }
        });
        
        Submit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent arg0) 
            {
            	Item newItem = new Item(getname.getText(), Integer.parseInt(getstock.getText()), Double.parseDouble(getprice.getText()), getDetails.getText());
            	//Supplier.addItem(newItem);
            	Frame.dispose();
                frame.dispose();
                View test = new View(Type);
                test.Display();
            }
        });
       
        JPanel panel2 = new JPanel();
        panel2.setLayout(new GridLayout(1, 2, 10, 10));
        panel2.add(Submit);
        panel2.add(Cancel);
        panel.add(panel2, BorderLayout.SOUTH);
		
		Frame.add(panel);
		Frame.setPreferredSize(new Dimension(800, 400));
		Frame.setResizable(true);
		Frame.pack();
		Frame.setVisible(true);
        Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
