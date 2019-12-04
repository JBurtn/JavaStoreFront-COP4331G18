package views;

import java.util.ArrayList;
import javax.swing.JButton;
public class CheckoutView 
{
	public JButton checkout;
	public ArrayList<Item> ItemBox;
	public CheckoutView(ArrayList<Item> items) 
	{
		ItemBox = new ArrayList<Item>();
		ItemBox.addAll(items);
		checkout = new JButton("Checkout");
	}
	
}
