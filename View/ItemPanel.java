package View;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Model.*;

public abstract class ItemPanel extends View
{
	JButton name;
	JLabel Price;
	JLabel Stock;
	JButton submit;
	JTextField Qty;
	JLabel Description;
	JPanel panel = new JPanel();
	
	
	ItemPanel(Item item){}
	
	public abstract void createItemWindow();
	
	String readQty()
	{return Qty.getText();}

}
