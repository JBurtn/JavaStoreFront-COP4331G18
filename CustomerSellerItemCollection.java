import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.*;

class CustomerSellerItemCollection {

	@Test
	void test() {
		Model mod = new Model();
		mod.addAccount(new Seller("a", "b"));
		assert(mod.confirm("a", "b").getName().equals("a")); 
		assert(mod.addAccount(new Customer("a", "b")) == false);
		assert(mod.addAccount(new Customer("sgs", "b")) == true);
		
		Seller sell = (Seller) mod.confirm("a", "b");
		sell.addItem(new Item("a", 4, 0.3, "aa", "a"));
		System.out.println(sell.getItemList());
		Customer cust = new Customer("ssgd", "s");
		cust.addItem(new Item("a", 5, 0.3, "aa", "a"));
		
		System.out.println(cust.getItemList());
		System.out.println(sell.getItemList());
		
		cust.removeItem(new Item("a", 5, 0.3, "aa", "a"));
		
		System.out.println(cust.getItemList());
		System.out.println(sell.getItemList());
		
		FileSystem file = new FileSystem("test.ser");
		
		file.save(cust);
		file.save(sell);
		
		System.out.println(file.load());
	}

}
