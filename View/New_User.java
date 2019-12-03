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
public class New_User implements Display
{
	 public static JFrame frame = new JFrame();
	    public JTextField username = new JTextField();
	    private JTextField password = new JTextField();
	    private static JTextField notify_user = new JTextField();
	    
	    private ButtonGroup AcctType = new ButtonGroup();
	    private JRadioButton Seller = new JRadioButton("Seller", true);
	    private JRadioButton Buyer = new JRadioButton("Buyer", false);
	    private JRadioButton Both = new JRadioButton("Both", false);
	    
	    
	    
	    private int user_type;
	    Model User;
	    
	    public New_User(Model User) 
	    {
	    	this.User = User;
	    	AcctType.add(Seller);
	    	AcctType.add(Buyer);
	    	AcctType.add(Both);
	    }
	    
	    private JButton Submit()
	    {
	        JButton submit = new JButton("Submit");
	        submit.addActionListener(new ActionListener() 
	        {
	            @Override
	            public void actionPerformed(ActionEvent arg0) 
	            {
	            	if(!username.getText().isBlank() && !password.getText().isBlank() )
	                {
	            		if(Seller.isSelected()) 
	            			user_type = 0;
	                    else if(Buyer.isSelected())
	                        user_type = 1;
	                    else
	                        user_type = 2;
	            		//ADD NEW ACCOUNT RETRY TO LOGIN
	            		if ()
	                    	frame.dispose();
	                    	Login relogin = new Login();
	                    	relogin.Frame();
	                }
	                else
	                {
	                    	
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
	    
	    @Override
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
	        
	        JTextField setname = new JTextField("Name:");
	        JTextField setusername = new JTextField("Username:");
	        JTextField setpassword = new JTextField("Password:");
	        
	        setname.setEditable(false);
	        setusername.setEditable(false);
	        setpassword.setEditable(false);
	        
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
	    
	    @Override
	    public void Frame()
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
