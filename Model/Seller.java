package Model;

import java.util.ArrayList;

public class Seller extends Account{

	private ArrayList<Item> Inventory = new ArrayList<>();
	public Seller(String name, String password, int UserType) {
		super(name, password, UserType);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void save() {
		// TODO Auto-generated method stub
		for(Item it: Inventory) {
			files.save(it);
		}
	}

	@Override
	public Item removeItem(Item item) {
		// TODO Auto-generated method stub
		if(Inventory.contains(item))
			return Inventory.remove(Inventory.lastIndexOf(item));
		return null;
	}

	@Override
	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		if(!Inventory.contains(item))
			Inventory.add(item);
		return false;
	}
	public void setItem(Item old, Item nw) {
		int prev = Inventory.lastIndexOf(old);
		Inventory.set(prev, nw);
	}
}
