package Model;

import java.util.ArrayList;

public class Customer extends Account{
	private int creditNum;
	
	private ItemCollection Store = ItemCollection.getInstance();
	private ArrayList<Item> cart = new ArrayList<>();
	
	public Customer(String name, String password) {
		super(name, password, 0);
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, String password, int creditNum) {
		super(name, password, 0);
		this.creditNum = creditNum;
	}

	@Override
	public Item removeItem(Item item) {//remove item from cart
		// TODO Auto-generated method stub
		if(cart.contains(item)){
			if(Store.getfullItemList().contains(item)) {
				Item replacement = Store.getItem(item).clone();
				replacement.setStock(item.getStock()+replacement.getStock());
				Store.setItem(item, replacement);
			}
			return cart.remove(cart.lastIndexOf(item));
		}
		return null;
	}
	@Override
	public boolean addItem(Item item) {//add item to cart
		// TODO Auto-generated method stub
		if(Store.getfullItemList().contains(item)) {
			int qty = Store.getItem(item).getStock();
			if(qty <= item.getStock()) {
				item.setStock(qty);
				Store.removeItem(item);
			}
			else {
				Item replacement = Store.getItem(item).clone();
				replacement.setStock(replacement.getStock() - item.getStock());
				Store.setItem(item, replacement);
			}
			return true;
		}
		return false;
	}
	@Override
	public ArrayList<Item> getItemList() {//Retrieve the cart
		// TODO Auto-generated method stub
		return cart;
	}
	@Override
	public void setItem(Item item, Item Nitem) {//replace item in cart or add quantity
		// TODO Auto-generated method stub
		cart.set(cart.lastIndexOf(item), Nitem);
	}
	public String subTotal() {
		int sum = 0;
		double amount = 0;
		for(Item it: cart) {
			sum += it.getStock();
			amount += it.getPrice();
		}
		return Integer.toString(sum) + "\t" + Double.toString(amount);
	}
	
}
