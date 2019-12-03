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
    public ArrayList<Item> Item = new ArrayList<Item>();
    public JFrame frame;
    //Model model;
    public JPanel Conpanel;
    public static JPanel Sellpanel;
    static JTabbedPane users;
    JScrollPane scroll;
    int UserType;
    //Consumer Con;
    //Seller Sell;
    
    View(int i)
    {	
    	frame = new JFrame();
    	UserType = i;
    	
    	//Item.addAll(new Supplier().getItemList);
    	Item.addAll(new Inventory().getUserInventory("q"));
    	Conpanel = new JPanel();
    	Conpanel.setLayout(new GridLayout(Item.size(), 1, 10, 10));
    	Sellpanel = new JPanel();
    	Sellpanel.setLayout(new GridLayout(Item.size(), 1, 10, 10));
    }
    View(){}
    
    
    /***
     * Sets the Home Screen Depending on the User Type
     */
    void Home()
    {	
    	JButton add = new JButton("Add");
    	add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new SupplierView().Display(frame, UserType);
			}
		});
    	
    	JButton Cart = new JButton("Cart");
    	Cart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				frame.dispose();
			}
		});
    	
    	JPanel panelbutton1 = new JPanel();
    	panelbutton1.setLayout(new GridLayout(1, 2, 10, 0));
    	panelbutton1.add(new JLabel("")); panelbutton1.add(add);
    	JPanel panelbutton2 = new JPanel();
    	panelbutton2.setLayout(new GridLayout(1, 2, 10, 0));
    	panelbutton2.add(new JLabel("")); panelbutton2.add(Cart);
    	
    	users = new JTabbedPane();
    	Sellpanel.setLayout(new GridLayout(Item.size() + 2, 1, 10, 10));
    	Sellpanel.add(panelbutton1, BorderLayout.NORTH);
    	Conpanel.setLayout(new GridLayout(Item.size() + 2, 1, 10, 10));
    	Conpanel.add(panelbutton2, BorderLayout.NORTH);
    	
    	
    	int j = 1;
    	for(Item i : Item)
    	{
    		ConsumerWindow con = new ConsumerWindow(i, j);
    		Conpanel.add(con.panel);
    		SupplierWindow sup = new SupplierWindow(i, j);
    		Sellpanel.add(sup.panel);
    		j++;
    	}
    	if(UserType == 0)//Seller
    	{
    		//Sell = new Seller();
    		scroll = new JScrollPane(Sellpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    		users.addTab("Seller", scroll);
    	}
    	else if(UserType == 1)//Consumer
    	{
    		//Con = new Consumer();
    		scroll = new JScrollPane(Conpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    		users.addTab("Consumer", scroll);
    	}
    	else if(UserType == 2)//Both
    	{
    		//Sell = new Seller();
    		//Con = new Consumer();
    		scroll = new JScrollPane(Sellpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    		users.addTab("Seller", scroll);
    		scroll = new JScrollPane(Conpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    		users.addTab("Consumer", scroll);
    	}
    }
    
    public void Display()
    {
    	Home();
    	frame.add(users);
    	frame.setPreferredSize(new Dimension(800, 400));
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    }
}
