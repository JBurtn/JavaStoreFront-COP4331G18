package View;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import project.Items;

public class ItemPanel extends JPanel
{
	JButton OpenItemWindow;
	JLabel Price;
	JLabel Stock;
	JButton submit;
	JTextField Qty;
	static JPanel panel;
	
	
	ItemPanel(Item item)
	{
		OpenItemWindow = new JButton(item.getName());
		Price = new JLabel("$" + item.getPrice());
		Stock = new JLabel("" + item.getStock());
		submit = new JButton("Submit");
		Qty = new JTextField("Add Amount");
		Qty.setEditable(true);
		
		panel = new JPanel();
		panel.setLayout(new GridLayout(3, 2, 10, 10));	
        panel.setBackground(Color.WHITE);
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK));
		panel.add(OpenItemWindow);
       	panel.add(Price);
       	panel.add(Stock);
       	panel.add(new JLabel());
       	panel.add(Qty);
       	panel.add(submit);
	}
	
	public void OnSubmitListener(ActionListener action)
	{
		
	}
	
	String readQty()
	{return Qty.getText();}

}
