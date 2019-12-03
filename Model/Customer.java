package Model;
public class Customer extends Account{
	private int creditNum;
	public Customer(String name, String password, int UserType) {
		super(name, password, UserType);
		// TODO Auto-generated constructor stub
	}
	public Customer(String name, String password, int UserType, int creditNum) {
		super(name, password, UserType);
		this.creditNum = creditNum;
	}
	@Override
	public void save() {
		// TODO Auto-generated method stub
	}
	@Override
	public Item removeItem(Item item) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean addItem(Item item) {
		// TODO Auto-generated method stub
		return false;
	}
	
}
