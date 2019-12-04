package Model;
import java.text.NumberFormat;

public abstract class Item {
	private long PID;
	private int Stock;
	private double price;
	private String Description;
	private String name;
	private String Sellername;
	
	private static final NumberFormat money = NumberFormat.getInstance();

	public Item(String name, int Stock, double Price, String Description, String Sellername) {
		this.PID = hashCode();
		this.setStock(Stock);
		this.setPrice(Price);
		this.setDescription(Description);
		this.setSellername(Sellername);
	}
	public String getName() {
		return name;
	}
	public String getDescription() {
		return Description;
	}
	public String getSellername() {
		return Sellername;
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
	public void setPrice(double price) {
		this.price = price;
	}
	public void setDescription(String description) {
		Description = description;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setStock(int stock) {
		Stock = stock;
	}
	public void setSellername(String sellername) {
		Sellername = sellername;
	}
	@Override
	public String toString() {
		return getName() + '\t' + money.format(getPrice()) + Integer.toString(getStock());
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
		String key = getName().concat(getDescription());// hash on key not value  
		long hash = 37;// Small initial Prime
		
		for(int i = 0; i < key.length(); i++) {
			hash = hash *(127) + key.charAt(i);// multiplicative hash
		}
		return (int) (hash % Integer.MAX_VALUE);
	}

}
