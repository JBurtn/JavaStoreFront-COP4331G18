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
    private JPanel FullItemSet = new JPanel();
    private JPanel ItemSet = new JPanel();
    private JPanel Consumer = new JPanel();
    private JPanel Supplier = new JPanel();
    
    private Display display;
    private Account acct;


    View(Account acct, Model current)
    {	
    	this.acct = acct;
    	//this.current = current;
    	ItemStore = current.getFullItemList();
    	currentUserInV = acct.getItemList();
    	
    	FullItemSet.setLayout(new GridLayout(ItemStore.size(), 1, 10, 10));
    	ItemSet.setLayout(new GridLayout(ItemStore.size(), 1, 10, 10));
    	for(Item i: currentUserInV) {
        	ItemPanel ip = new ItemPanel(i);
        	
        	display.onItemLink(ip, ip.getOpenwindow());
        	display.onSubmit(ip, ip.getSubmit());
    		ItemSet.add(ip);
        }
        for(Item i: ItemStore) {
        	ItemPanel ip = new ItemPanel(i);
        	
        	display.onItemLink(ip, ip.getOpenwindow());
        	display.onSubmit(ip, ip.getSubmit());
    		ItemSet.add(ip);
        }      
    	CurrentView.addTab("Consumer", Consumer);    	
    	CurrentView.addTab("Supplier", Supplier);
    	
    	
        switch(acct.getUserType()){
		case 0:
	    	Consumer.add(new ConsumerView(acct));

	    	Consumer.add(FullItemSet);
	    	CurrentView.setEnabledAt(1, false);
			break;
		case 1:
	    	Supplier.add(new SupplierView(acct));
	    	Supplier.add(ItemSet);
			break;
		default:
			if(acct.getBoth()) {
	        	Supplier.add(new SupplierView(acct));
	        	Consumer.add(new ConsumerView(acct));

	        	Supplier.add(ItemSet);
	        	Consumer.add(FullItemSet);

			}
			break;
		}
        

    	Display();
    	
    	  Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

    	        public void run() {
    	            // Do what you want when the application is stopping
    	        	current.save();
    	        }
    	    }));
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
				if(acct.getBoth())
					acct = acct.swap();
				CurrentView.revalidate();
				CurrentView.repaint();
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