package Model;

import java.io.Serializable;
import java.util.ArrayList;

public abstract class Account implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4359273478321210727L;
	
	private String name;
	private String password;
	private int UserType;
	private Boolean both;

	public Account(String name, String password, int UserType, Boolean both) {
		this.name = name;
		this.password = password;
		this.UserType = UserType;
		this.both = false;
	}
	public Boolean confirm(String user, String password) {
		return user.equals(name) && this.password.equals(password);
	}
	@Override
	public boolean equals(Object o) {
		if(o instanceof Account) {
			Account test = (Account) o;
			return test.getName().equals(this.getName());
		}
		return false;
	}
	public int getUserType() {
		return UserType;
	}
	public String getName() {
		return name;
	}
	public void setPass(String password) {
		this.password = password;
	}
	public Account swap() {
		if(UserType == 0)
			return new Seller(name, password, 1);
		else
			return new Customer(name, password, 0);
	}
	public abstract void setItem(Item item, Item Nitem);
	public abstract Item removeItem(Item item);
	public abstract boolean addItem(Item item);
	public abstract ArrayList<Item> getItemList();
	public Boolean getBoth() {
		return both;
	}
	
}
