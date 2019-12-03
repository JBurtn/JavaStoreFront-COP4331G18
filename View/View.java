package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;

import Model.*;

public class View 
{
    public View Currentview;
    public ArrayList<Item> Item;
    public JFrame frame;
    private Model current;
    private Account acct;
    public static JPanel Conpanel;
    public static JPanel Sellpanel;
    public static JTabbedPane users;
    JScrollPane scroll;


    View(Account acct, Model current)
    {	
    	frame = new JFrame();
    	this.acct = acct;
    	this.current = current;
    	item = acct.getItemList();
	
    	Conpanel = new JPanel();
    	Conpanel.setLayout(new GridLayout(Item.size(), 1, 10, 10));
    	Sellpanel = new JPanel();
    	Sellpanel.setLayout(new GridLayout(Item.size(), 1, 10, 10));
	
	setConsumerPanel();
	users.addTab("Consumer", scroll);
	setSellerPanel();
	users.addTab("Seller", scroll);
	
	switch(acct.getUserType()){
		case 0:
			users.setEnabledAt(0, false);
			break;
		case 1:
			users.setEnabledAt(1, false);
			break;
		default:
			break;
	}
    }
    View(){}
    
    
    /***
     * Sets the Home Screen Depending on the User Type
     */
    private void setConsumerPanel()
    {
    	JButton Cart = new JButton("Cart");//move to Consumer
    	Cart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
				//Show Cart, proceed to checkout
			}
		});
	JPanel panelbutton2 = new JPanel();
    	panelbutton2.setLayout(new GridLayout(1, 2, 10, 0));
    	panelbutton2.add(new JLabel("")); panelbutton2.add(Cart);
	Conpanel.setLayout(new GridLayout(Item.size() + 2, 1, 10, 10));
    	Conpanel.add(panelbutton2, BorderLayout.NORTH);
	int j = 1;
	    for(Item i : Item)
        	{
        		ConsumerWindow con = new ConsumerWindow(i, j);
        		Conpanel.add(con.panel);
        		j++;
        	}
    		//Con = new Consumer();
    		scroll = new JScrollPane(Conpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
    }// move consumer Panel setup here
    
    private void setSellerPanel()
    {
    	JButton add = new JButton("Add");
    	add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new SupplierView().Display(frame, acct, current);
			}
		});
    	JPanel panelbutton1 = new JPanel();
    	panelbutton1.setLayout(new GridLayout(1, 2, 10, 0));
    	panelbutton1.add(new JLabel("")); panelbutton1.add(add);
    	
    	
    	users = new JTabbedPane();
    	Sellpanel.setLayout(new GridLayout(Item.size() + 2, 1, 10, 10));
    	Sellpanel.add(panelbutton1, BorderLayout.NORTH);
    
    	int j = 1;   	
    	for(Item i : SellerItems)
    	{
    		SupplierWindow sup = new SupplierWindow(i, j);
    		Sellpanel.add(sup.panel);
    		j++;
    	}
    	scroll = new JScrollPane(Sellpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    }//move seller panel setup here
    
  
    public void Display()
    {
    	frame.add(users);
    	frame.setPreferredSize(new Dimension(800, 400));
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
