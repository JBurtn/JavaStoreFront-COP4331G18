package View;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Context{
	   private Display strategy;

	   public Context(Display strategy){
	      this.strategy = strategy;
	   }

	   public void executeOpenStrategy(ItemPanel it, JButton j){
	      strategy.onItemLink(it, j);
	   }
	   public void executeSubmitStrategy(ItemPanel it, JButton j) {
		   strategy.onSubmit(it, j);
	   }

	}
