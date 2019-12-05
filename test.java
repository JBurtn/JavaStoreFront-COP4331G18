
import View.*;
import Model.*;

public class test {
    public static void main(String [] args)
    {
    	Model m = new Model();
    	Login Welcome = new Login(m);
    	Welcome.Frame();
    	
    	
    	Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {

	        public void run() {
	            // Do what you want when the application is stopping
	        	m.save();
	        }
	    }));
    	//View test = new View(2);
    	//test.Display();
    }

}
