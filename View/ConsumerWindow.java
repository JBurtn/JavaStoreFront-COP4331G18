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

public class ConsumerWindow extends ItemPanel
{
	int Quantity;
	int i;
	
	ConsumerWindow(Item item, int j) {
		super(item);
		i = j;
		Price = new JLabel("Price:$ " + item.getPrice());
		Stock = new JLabel("Stock: " + item.getStock());
		name = new JButton(item.getName());
		Description = new JLabel(item.getDetails());
		submit = new JButton("Submit");
		Qty = new JTextField("1");
		Qty.setEditable(true);    	
		panel = new JPanel();
    	panel.setLayout(new GridLayout(3, 2, 10, 10));	
        panel.setBackground(Color.WHITE);
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
		
		
		panel.add(name);
        panel.add(Price);
        panel.add(Qty);
        panel.add(submit);

        /***
         *Not Sure If an object of Consumer is created here or 
         */
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
				Quantity = Integer.parseInt(readQty());
				if(Quantity > item.getStock())
				{
					Qty.setText("Invalid Amount");
					Qty.setEditable(true);
				}else 
				{
					//Consumer.addItem(Quantity, item);
					//Consumer.save();
				}
				
			}
		});
	}
	
	@Override
	public void createItemWindow() 
	{
		JFrame Frame = new JFrame();
		JPanel Panel = new JPanel();
		JLabel price = Price;
		JLabel stock = Stock;
		JLabel Name = new JLabel(name.getText());
		JLabel description = Description;
		JTextField qty = new JTextField("1");
		qty.setEditable(true);
		Panel.setLayout(new GridLayout(4, 2, 10, 10));	
		JButton Submit = new JButton("Submit");
		JButton Cancel = new JButton("Cancel");
		
		Submit.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String []temp = Stock.getText().split(" ");
				Quantity = Integer.parseInt(qty.getText());
				if(Quantity > Integer.parseInt(temp[1]))
				{
					qty.setText("Invalid Amount");
					qty.setEditable(true);
				}else 
				{
					Frame.dispose();
					Price = price;
					Stock = stock;
					Description = description;
					panel.removeAll();
					panel.add(name);
					panel.add(Price);
					panel.add(Qty);
					panel.add(submit);
					panel.revalidate();
					panel.repaint();
					//Consumer.addItem(Quantity, item);
					//Comsumer.save();
				}
			}
		});
		
		Cancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Frame.dispose();
				Price = price;
				Stock = stock;
				Description = description;
				
				panel.removeAll();
				panel.add(name);
		        	panel.add(Price);
		        	panel.add(Qty);
		        	panel.add(submit);
		        	panel.revalidate();
		        	panel.repaint();
			}
		});
		
		Panel.add(Name);
        Panel.add(price);
        Panel.add(new JLabel("Description: "));
        Panel.add(description);
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
