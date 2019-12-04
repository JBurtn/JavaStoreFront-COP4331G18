package View;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;

import Model.*;

public class Login implements Display
{
	    Model Getuser;
	    public static JFrame frame = new JFrame();
	    private JLabel incorrect;
	    private JTextField user;
	    private JTextField pass;
	    
	    Login(Model GetUser)
	    {
	    	this.Getuser = GetUser;
	    	Getuser.load();
	    }
	    
	    private JButton login(JTextField user, JTextField pass, JLabel incorrect)
	    {
	        JButton Login = new JButton("Login");
	        Login.addActionListener(new ActionListener() {
	            @Override
		   
	            public void actionPerformed(ActionEvent arg0) 
	            { 
		    	final Account verify;
		    	verify = Getuser.confirm(user.getText(), pass.getText());
	                if(verify == null){
	                    incorrect.setText("Incorrect Username And/Or Password");
	                }
	                else
	                {
	                    frame.dispose();
	                    //GET ACCOUNT AND USERTYPE!!!!!!!!!!!!!!
	                    View Welcome = new View(verify, Getuser);//CHANGE VALUE TO USERTYPE
	                	Welcome.Display();
	                }
	            }
	            });
	        return Login;
	    }
	    
	    private JButton Newuser()
	    {
	        JButton getnew = new JButton("New_User");
	        getnew.addActionListener(new ActionListener() {
	            @Override
	            public void actionPerformed(ActionEvent arg0) 
	            {
	               frame.dispose();
	               New_User getNew = new New_User(Getuser);
	               getNew.Frame();
	            }
	            });
	        return getnew;
	    }
	    
	    @Override
	    public JPanel Panel()
	    {
	        JPanel panel = new JPanel();
	        panel.setLayout(new GridLayout(3, 3, 5, 10));
	        JTextField user = new JTextField("Username");
	        JTextField pass = new JTextField("Password");
	        JLabel incorrect = new JLabel(" ");
	        incorrect.setBorder(javax.swing.BorderFactory.createEmptyBorder());

	        user.setEditable(true);
	        pass.setEditable(true);
	        
	        panel.add(user);
	        panel.add(pass);
	        panel.add(login(user, pass, incorrect));
	        panel.add(Newuser());
	        panel.add(incorrect);
	        return panel;
	    }
	    
	    @Override
	    public void Frame()
	    {        
	        frame.setTitle("Login");
	        frame.setPreferredSize(new Dimension(600, 150));
	        frame.add(Panel());
	        frame.setResizable(false);
	        frame.pack();
	        frame.setVisible(true);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    }        
}
