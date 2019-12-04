package Model;

import java.util.ArrayList;

public class Seller extends Account{

	private ItemCollection stock = ItemCollection.getInstance();
	
	public Seller(String name, String password) {
		super(name, password, 0);
		// TODO Auto-generated constructor stub
	}
	@Override
	public Item removeItem(Item item) {
		// TODO Auto-generated method stub
		if(stock.getfullItemList().contains(item)) {
			stock.removeItem(item);
		}
		return null;
	}

	@Override
	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		if(!stock.getfullItemList().contains(item))
			return stock.getfullItemList().add(item);
		return false;
	}
	public void setItem(Item old, Item nw) {
		stock.setItem(old, nw);
	}

	@Override
	public ArrayList<Item> getItemList() {
		// TODO Auto-generated method stub
		return stock.getSellerItemList(name);
	}
}
