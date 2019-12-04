package Model;

import java.util.ArrayList;

public class ItemCollection {
	private final ArrayList<Item> fullList = new ArrayList<>();
	
	public ItemCollection() {}
	public static final ItemCollection getInstance() {
		return Singleton.INSTANCE;
	}
	public Item removeItem(Item item) {
		if(fullList.contains(item))
			return fullList.remove(fullList.lastIndexOf(item));
		return null;
	}
	public boolean addItem(Item item) {
		if(!fullList.contains(item))
			return fullList.add(item);

		return false;
	}
	public Item getItem(Item item) {
		return fullList.get(fullList.lastIndexOf(item));
	}
	public void setItem(Item oldItem, Item newItem) {
		fullList.set(fullList.lastIndexOf(oldItem), newItem);
	}
	public ArrayList<Item> getfullItemList(){
		return fullList;
	}
	public ArrayList<Item> getSellerItemList(String name){
		ArrayList<Item> SellerList = new ArrayList<>();
		for(Item item: fullList) {
			if(item.getSellername().equals(name))
				SellerList.add(item);
		}
		return SellerList;
	}
	private static class Singleton{
		private final static ItemCollection INSTANCE = new ItemCollection();
	}
}
