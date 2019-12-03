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
    ArrayList<Item> items = new ArrayList<Item>();
    public static JFrame frame = new JFrame();
    //Model model;
    JPanel Conpanel;
    JPanel Sellpanel;
    static JTabbedPane users;
    JScrollPane scroll;
    SupplierWindow sup;
    
    View()
    {	
    	//items.addAll(new Inventory().getUserInventory("q"));
    	Conpanel = new JPanel();
    	Conpanel.setLayout(new GridLayout(items.size(), 1, 10, 10));
    	Sellpanel = new JPanel();
    	Sellpanel.setLayout(new GridLayout(items.size(), 1, 10, 10));
    	//frame = new JFrame();
    	//Home();
    }
    
    void Home()
    {	
    	JButton add = new JButton("Add");
    	add.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) 
			{
				new SupplierView().Display();
			}
		});
    	
    	JPanel panelbuttons = new JPanel();
    	panelbuttons.setLayout(new GridLayout(1, 2, 10, 0));
    	panelbuttons.setSize(50, 50);
    	panelbuttons.add(new JLabel("")); panelbuttons.add(add);
    	
    	
    	users = new JTabbedPane();
    	Sellpanel.setLayout(new GridLayout(items.size() + 2, 1, 10, 10));
    	Sellpanel.add(panelbuttons, BorderLayout.NORTH);
    	
    	for(Item i : items)
    	{
    		ConsumerWindow con = new ConsumerWindow(i);
    		Conpanel.add(con.panel);
    		sup = new SupplierWindow(i);
    		Sellpanel.add(sup.panel);
    	}
    	scroll = new JScrollPane(Conpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	users.addTab("Consumer", scroll);
    	scroll = new JScrollPane(Sellpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    	users.addTab("Seller", scroll);
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
