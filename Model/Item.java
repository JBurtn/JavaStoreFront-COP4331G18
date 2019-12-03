package Model;
import java.text.NumberFormat;

public abstract class Item {
	private long PID;
	private int Stock;
	private double price;
	private String Description;
	private String name;
	
	private static final NumberFormat money = NumberFormat.getInstance();

	public Item(String name, int Stock, double Price, String Description) {
		this.PID = hashCode();
		this.Stock = Stock;
		this.price = Price;
		this.Description = Description;
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return Description;
	}

	public double getPrice() {
		return price;
	}

	public int getStock() {
		return Stock;
	}

	public long getPID() {
		return PID;
	}
	@Override
	public String toString() {
		return name + '\t' + money.format(price) + Integer.toString(Stock);
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Item) {
			Item test = (Item) o;
			return test.getPID() == this.getPID();
		}
		return false;
	}
	@Override
	public int hashCode() {
		String key = name.concat(Description);// hash on key not value  
		long hash = 37;// Small initial Prime
		
		for(int i = 0; i < key.length(); i++) {
			hash = hash *(127) + key.charAt(i);// multiplicative hash
		}
		return (int) (hash % Integer.MAX_VALUE);
	}
}
