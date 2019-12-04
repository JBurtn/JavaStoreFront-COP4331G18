package View;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

import Model.*;
public class CheckoutView extends JPanel
{
	private JButton checkout;
	private JButton remove;
 	private JList<Item> list;
 	private JLabel subTotal;
 	private final  DefaultListModel<Item> ItemBox;
	
	public CheckoutView(Account acct) 
	{
 		ItemBox = new DefaultListModel<>();
		remove = new JButton("Delete");
		checkout = new JButton("Checkout");
		
		for(Item i: acct.getItemList())
			ItemBox.addElement(i);
		
		checkout = new JButton("Checkout");
		checkout.setActionCommand("Open");
		list = new JList<Item>(ItemBox);
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		
		
		remove.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			    int index = list.getSelectedIndex();
			    ItemBox.remove(index);

			    int size = ItemBox.getSize();

			    if (size == 0) { //No items left, disable button.
			        remove.setEnabled(false);

			    } else { //Select an index.
			        if (index == ItemBox.getSize()) {
			            //removed item in last position
			            index--;
			        }

			        list.setSelectedIndex(index);
			        list.ensureIndexIsVisible(index);
			    }
			}
		});
		checkout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				switch(e.getActionCommand()) {
				case "Ready":
					acct.getItemList().clear();
					break;
				case "Open":
					CheckoutWindow open = new CheckoutWindow(new CheckoutView(acct));
					break;
				}
			}
			
		});
	}
	private class CheckoutWindow extends JFrame{
		JTextField CN = new JTextField();
		JLabel Credit = new JLabel("Enter Credit Card");
		JPanel Pane = new JPanel();
		
		public CheckoutWindow(JPanel pane) {
			
			Credit.setLabelFor(CN);
			checkout.setActionCommand("Ready");
			this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
			Pane.add(Credit);
			Pane.add(CN);
			
			this.add(pane);
			this.add(Pane);
	    	this.setPreferredSize(new Dimension(800, 400));
	        this.setResizable(true);
	        this.pack();
	        this.setVisible(true);
	        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}
	}

}
