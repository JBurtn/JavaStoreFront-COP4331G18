import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Model.Item;

class JUnItem {

	@Test
	void test() {
		Item it = new Item("a", 4, 0.3, "aa", "bb");
		Item it2 = it.clone();
		assert(it.equals(it2) == true);
		it.setName("b");
		assert(it.equals(it2) == false);
		it2.setName("b");
		it.setPrice(3.0);
		assert(it.equals(it2) == true);
	}

}
