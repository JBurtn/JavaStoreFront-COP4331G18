package Model;

import java.util.ArrayList;

public abstract class Account{
	private String name;
	private String password;
	private int UserType;
	
	public Account(String name, String password, int UserType) {
		this.name = name;
		this.password = password;
		this.UserType = UserType;
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
	public abstract void setItem(Item item, Item Nitem);
	public abstract Item removeItem(Item item);
	public abstract boolean addItem(Item item);
	public abstract ArrayList<Item> getItemList();
	
}
