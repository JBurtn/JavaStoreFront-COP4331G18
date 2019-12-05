package View;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.*;

public class ConsumerWindow
{
	JLabel Description;
	JLabel Lname;
	Item item;
	int Quantity;
	ConsumerWindow(Item i) {
		item = i;
	}
	
	public void createItemWindow() 
	{
		JFrame Frame = new JFrame();
		JPanel Panel = new JPanel();
		JLabel price = new JLabel("Price: $" + item.getPrice());
		JLabel stock = new JLabel("Stock: " + item.getStock());
		JLabel Name = new JLabel("" + item.getName());
		Description = new JLabel("Description: " + item.getDescription());
		JTextField qty = new JTextField("1");
		qty.setEditable(true);
		Panel.setLayout(new GridLayout(4, 2, 10, 10));	
		JButton Submit = new JButton("Submit");
		JButton Cancel = new JButton("Cancel");
		
		
		Submit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Quantity = Integer.parseInt(qty.getText());
				if(Quantity > item.getStock())
				{
					qty.setText("Invalid Amount");
					qty.setEditable(true);
				}
				else 
				{
					Frame.dispose();
					//Consumer.addItem(Quantity, item);
					//Comsumer.save();
				}
			}
		});
		
		Cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.dispose();
			}
		});
		
		Panel.add(Name);
        Panel.add(price);
        Panel.add(new JLabel("Description: "));
        Panel.add(Description);
        Panel.add(stock);
        Panel.add(qty);
        Panel.add(Submit);
        Panel.add(Cancel);
        Panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        
        Frame.add(Panel);
    	Frame.setPreferredSize(new Dimension(800, 200));
        Frame.setResizable(true);
        Frame.pack();
        Frame.setVisible(true);
        Frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}

}
