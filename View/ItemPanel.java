package View;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Model.*;

public class ItemPanel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5948683944629330449L;
	private JButton OpenItemWindow;
	private JLabel Price;
	private JLabel Stock;
	private JButton submit;
	private JTextField Qty;
	private Item item;
	
	ItemPanel(Item item)
	{
		this.item = item;
		OpenItemWindow = new JButton(item.getName());
		Price = new JLabel("$" + item.getPrice());
		Stock = new JLabel("" + item.getStock());
		submit = new JButton("Submit");
		Qty = new JTextField("Add Amount");
		
		this.setLayout(new GridLayout(3, 2, 10, 10));	
        this.setBackground(Color.WHITE);
        this.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
        
		this.add(OpenItemWindow);
       	this.add(Price);
       	this.add(Stock);
       	this.add(new JLabel());
       	this.add(Qty);
       	this.add(submit);
	}
	public Item getItem() {
		return item;
	}
	public JButton getOpenwindow() {
		return OpenItemWindow;
	}
	public JButton getSubmit() {
		return submit;
	}
	String readQty()
	{return Qty.getText();}

}
