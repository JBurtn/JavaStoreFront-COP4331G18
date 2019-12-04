package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import Model.*;


public class View extends JFrame
{   
    public static JTabbedPane CurrentView;
    
    private ArrayList<Item> ItemStore;
    private ArrayList<Item> currentUserInV;
    //private Model current;
    private JPanel ItemSet = new JPanel();
    private JPanel Consumer = new JPanel();
    private JPanel Supplier = new JPanel();
    private Display display;
    //private Account acct;


    View(Account acct, Model current)
    {	
    	//this.acct = acct;
    	//this.current = current;
    	ItemStore = current.getFullItemList();
    	currentUserInV = acct.getItemList();
    	
    	
    	ItemSet.setLayout(new GridLayout(ItemStore.size(), 1, 10, 10));    
    	CurrentView.addTab("Consumer", Consumer);    	
    	CurrentView.addTab("Supplier", Supplier);
    	
    	
        switch(acct.getUserType()){
		case 0:
	    	Consumer.add(new ConsumerView(acct));
	    	
	    	CurrentView.setEnabledAt(1, false);
			break;
		case 1:
	    	Supplier.add(new SupplierView(acct,current));
			break;
		default:
	    	Supplier.add(new SupplierView(acct, current));
	    	Consumer.add(new ConsumerView(acct));
	    	JPanel p = new JPanel();
	    	for(Item i : ItemStore) {
	    		
	    	}
	    	
			break;
		}
        for(Item i: currentUserInV) {
        	ItemPanel ip = new ItemPanel(i);
        	
        	display.onItemLink(i, ip.getOpenwindow());
        	display.onSubmit(i, ip.getSubmit());
    		ItemSet.add(ip);
        }    
    	Display();
    }
    View(){}
    
    public void Display()
    {
    	CurrentView.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				if(CurrentView.getSelectedIndex() == CurrentView.indexOfComponent(Supplier))
					display = (SupplierView) CurrentView.getSelectedComponent();
				else
					display = (ConsumerView) CurrentView.getSelectedComponent();
			}
    	});
    	this.add(CurrentView);
    	this.setPreferredSize(new Dimension(800, 400));
        this.setResizable(true);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
