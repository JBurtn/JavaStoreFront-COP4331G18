package View;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.*;


public abstract class ItemPanel extends View
{
	JButton name;
	JLabel Stock;
	JButton submit;
	JTextField Qty;
	JLabel Description;
	JPanel panel;
	
	
	ItemPanel(Item item)
	{
		Stock = new JLabel("Stock: " + item.getStock());
		name = new JButton(item.getName());
		Description = new JLabel(item.getDescription());
		submit = new JButton("Submit");
		Qty = new JTextField();
		Qty.setEditable(true);    	
		panel = new JPanel();
    	panel.setLayout(new GridLayout(3, 2, 10, 10));	
        panel.setBackground(Color.WHITE);
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
	}
	
	public void createItemWindow(){}
	
	String readQty()
	{
		return Qty.getText();
	}

}
