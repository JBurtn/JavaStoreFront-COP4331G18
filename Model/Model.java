package Model;

import java.util.ArrayList;

public class Model {
		private ArrayList<Account> Accounts = new ArrayList<>();
		private final FileSystem files = new FileSystem("accounts.ser");
		
		public boolean addAccount(Account acct) {
			if(Accounts.contains(acct))
				return false;
			else
				Accounts.add(acct);
			return true;
		}
		public Account confirm(String user, String password) {
			Account confirm = null;
			for(int i = 0; i < Accounts.size(); i++) {
				if(Accounts.get(i).confirm(user, password))
					return confirm;
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
			}
			for(Item item: getFullItemList()) {
				files.save(item);
			}
		}
		public ArrayList<Item> getFullItemList() {
			return ItemCollection.getInstance().getfullItemList();
		}
		
}
