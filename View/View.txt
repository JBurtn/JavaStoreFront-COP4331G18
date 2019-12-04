package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;


public class View 
{   
	public static JFrame frame;
    public static JTabbedPane CurrentView;
    public ArrayList<Item> ItemStore;
    private Model current;
    private Account acct;
    JScrollPane scroll;

    View(Account acct, Model current)
    {	
    	frame = new JFrame();
    	this.acct = acct;
    	this.current = current;
    	ItemStore = acct.getItemList();
	
    	JPanel Panel = new JPanel();
    	Panel.setLayout(new GridLayout(ItemStore.size(), 1, 10, 10));
    	for(Item i : ItemStore)
        	{
    			new ItemPanel(i);
        		Panel.add(ItemPanel.panel);	
        		new ConsumerWindow(i);
        	}
	    scroll = new JScrollPane(Panel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);  
    	CurrentView.addTab("Consumer", scroll);
        switch(acct.getUserType()){
		case 0:
			CurrentView.setEnabledAt(0, false);
			break;
		case 1:
			CurrentView.setEnabledAt(1, false);
			break;
		default:
			break;
		}
    	
    	Display();
    }
    View(){}
    
    public static void Display()
    {
    	frame.add(CurrentView);
    	frame.setPreferredSize(new Dimension(800, 400));
        frame.setResizable(true);
        frame.pack();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}