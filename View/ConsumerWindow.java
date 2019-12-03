package View;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import Model.*;

public class ConsumerWindow extends ItemPanel
{
	String Quantity;
	JButton cancel = new JButton("Cancel");

	ConsumerWindow(Item item) {
		super(item);
		JLabel Price = new JLabel("Price:$ " + item.getPrice());
		
		panel.add(name);
        panel.add(Price);
        panel.add(Stock);
        panel.add(Qty);
        panel.add(new JLabel(""));
        panel.add(submit);

        
		name.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				createItemWindow();
			}
		});
		
		submit.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e)
			{
				Quantity = readQty();
				
				panel.removeAll();	
		        panel.add(name);
		        panel.add(Price);
		        panel.add(Stock);
		        panel.add(Qty);
		        panel.add(new JLabel(""));
		        panel.add(submit);
		        panel.setBackground(Color.WHITE);
		        panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
		        panel.revalidate();
		        panel.repaint();
			}
		});
		
		cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				panel.removeAll();	
		        panel.add(name);
		        panel.add(Price);
		        panel.add(Stock);
		        panel.add(Qty);
		        panel.add(new JLabel(""));
		        panel.add(submit);
		        panel.setBackground(Color.WHITE);
		        panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
		        panel.revalidate();
		        panel.repaint();
			}
		});
	}
	
	@Override
	public void createItemWindow() 
	{
		panel.removeAll();
		panel.setLayout(new GridLayout(3, 2, 10, 10));	
        panel.add(name);
        panel.add(Price);
        panel.add(new JLabel("Description: "));
        panel.add(Description);
        panel.add(Stock);
        panel.add(Qty);
        panel.add(submit);
        panel.add(cancel);
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        panel.revalidate();
        panel.repaint();
        

	}

}
