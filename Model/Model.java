package Model;



import java.io.*;
import java.util.ArrayList;

public class Model {
		private ArrayList<Account> Accounts = new ArrayList<>();
		private final FileSystem<Account> files = new FileSystem<>("accounts.ser");
		
		public boolean addAccount(Account acct) {
			if(Accounts.contains(acct))
				return false;
			else
				Accounts.add(acct);
			return true;
		}
		public Boolean confirm(String user, String password) {
			Boolean confirm = false;
			for(int i = 0; i < Accounts.size() && confirm == false; i++) {
				confirm = Accounts.get(i).confirm(user, password);
			}
			return confirm;
		}
		public void load() {
			int temp = 0;
			for(Object obj: files.load()) {
				if(obj instanceof Seller) {
					temp = Accounts.indexOf((Account) obj);
					Accounts.add((Account) obj);
				}
				else if(obj instanceof Item) {
					Accounts.get(temp).addItem((Item) obj);
				}
				else if(obj instanceof Customer) {
					Accounts.add((Account) obj);
				}
			}
		}
		public void save() {
			for(Account acct: Accounts) {
				files.save(acct);
				acct.save();
			}
		}
		
}
