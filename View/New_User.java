package View;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Model.*;

/**
 *
 * @author saint
 */
public class New_User
{
	 	public static JFrame frame = new JFrame();
	    public JTextField username = new JTextField();
	    private JTextField password = new JTextField();
	    private JTextField CreditNum = new JTextField();
	    private static JTextField notify_user = new JTextField();
	    
	    private JRadioButton Seller = new JRadioButton("Seller");
	    private JRadioButton Buyer = new JRadioButton("Buyer");
	    private JRadioButton Both = new JRadioButton("Both");
	    
	    private int user_type;
	    Model Getuser;
	    
	    public New_User(Model temp) {
	    	Getuser = temp;
	    }
	    
	    private JButton Submit()
	    {
	        JButton submit = new JButton("Submit");
	        submit.addActionListener(new ActionListener() 
	        {
	            @Override
	            public void actionPerformed(ActionEvent arg0) 
	            {
	            	if(!username.getText().isBlank() && !password.getText().isBlank() && 
	            	(Seller.isSelected() || Buyer.isSelected() || Both.isSelected()))
	                {
	            	    if(Seller.isSelected()){
	                        if(Getuser.addAccount(new Seller(username.getText(), password.getText()))) {
	                        	Getuser.save();
	    	                   	frame.dispose();
	    	                  	Login relogin = new Login(Getuser);
	    	                   	relogin.Frame();
		                    }
	                    }
	                    else if(Buyer.isSelected()) {
	                        if(Getuser.addAccount(new Customer(username.getText(), password.getText() ) ) ) {
	                        	Getuser.save();
		    	                frame.dispose();
			                    Login relogin = new Login(Getuser);
			                    relogin.Frame();
		                    }
	                    }
	                    else{
	                        if(Getuser.addAccount(new Seller(username.getText(), password.getText(), 3) ) ) {
	                        	Getuser.save();
	    	                    frame.dispose();
		                    	Login relogin = new Login(Getuser);
		                    	relogin.Frame();
	                        }
	                    }
	            		//ADD NEW ACCOUNT RETRY TO LOGIN
	            		
	                }
	         }
	        });
	        return submit;
	    }
	    
	    private JButton Cancel()
	    {
	        JButton cancel = new JButton("Cancel");
	        cancel.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent arg0) 
	            {
	                frame.dispose();
	            }
	        });
	        
	        return cancel;
	    }
	    
	    public JPanel Panel()
	    {
	        JPanel panel = new JPanel();
	        JPanel panel2 = new JPanel();
	        panel.setLayout(new GridLayout(6, 2, 10, 10));
	        panel2.setLayout(new BorderLayout());
	        
	        notify_user.setEditable(false);
	        notify_user.setBorder(BorderFactory.createEmptyBorder());
	        panel2.add(notify_user);
	        
	        JTextField NO = new JTextField("No White Space In Password");
	        NO.setEditable(false);
	        NO.setBorder(BorderFactory.createEmptyBorder());
	        
	        ButtonGroup bg = new ButtonGroup();
	        bg.add(Seller);
	        bg.add(Buyer);
	        bg.add(Both);
	        
	        JLabel setname = new JLabel("Name:");
	        JLabel setusername = new JLabel("Username:");
	        JLabel setpassword = new JLabel("Password:");
	        
	        panel.add(setusername);
	        panel.add(username);
	        panel.add(setpassword);
	        panel.add(password);
	        
	        JTextField blank = new JTextField("Please Select Account Type");
	        blank.setEditable(false);
	        blank.setBorder(BorderFactory.createEmptyBorder());
	        
	        panel.add(Seller);
	        panel.add(Buyer);
	        panel.add(Both);
	        panel.add(blank);
	        
	        panel.add(panel2);
	        panel.add(NO);
	        panel.add(Submit());
	        panel.add(Cancel());
	        
	        return panel;
	    }

	    public void Display()
	    {
	        frame.setLayout(new BorderLayout());
	        frame.setPreferredSize(new Dimension(500, 400));
	        frame.add(new JLabel("NEW USER", SwingConstants.CENTER), BorderLayout.NORTH);
	        frame.setResizable(false);
	        frame.add(Panel(), BorderLayout.CENTER);
	        frame.setTitle("New User");
	        frame.pack();
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }
}
