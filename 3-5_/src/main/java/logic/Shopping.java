package logic;

import java.util.List;

import model.Cart;
import model.ItemSet;
import model.User;

public interface Shopping {
	void checkout(User user, Cart cart);
	Integer calculateTotal(List<ItemSet> list);
}
