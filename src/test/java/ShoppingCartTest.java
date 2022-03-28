// John Murray
// Eilis Casey
// Unit tests for ShoppingCart class
import static org.junit.jupiter.api.Assertions.*;
import csc4700.Item;
import csc4700.ShoppingCart;
import csc4700.CartItem;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

    @Test
    public void testAddItemNull(){
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ShoppingCart boats = new ShoppingCart();
                boats.addItem(null);
            }
        });
    }

    @Test
    public void testAddItemFirstItem(){
        Item item = new Item();
        ShoppingCart shoppingCart = new ShoppingCart();
        shoppingCart.addItem(item);
        CartItem cartItem = shoppingCart.findCartItem(item);
        
        assertTrue(shoppingCart.getCartItems().contains(cartItem));
        assertEquals(1,shoppingCart.getCartItems().size());
        assertEquals(1,cartItem.getCount());
    }

    @Test
    public void testAddItemMultiple(){
        ShoppingCart boats = new ShoppingCart();
        Item sailboat = new Item();
        boats.addItem(sailboat);
        boats.addItem(sailboat);

        CartItem cartItem = boats.findCartItem(sailboat);

        assertTrue(boats.getCartItems().contains(cartItem));
        assertEquals(1,boats.getCartItems().size());
        assertEquals(2,cartItem.getCount());
    }

    @Test
    public void testDeleteItemNotPresent(){
        ShoppingCart boats = new ShoppingCart();
        Item sailboat = new Item();
        sailboat.setName("Eilis");
        Item steamboat = new Item();
        steamboat.setName("Jack");
        boats.addItem(steamboat);
        CartItem testSteamBoat = boats.findCartItem(steamboat);
        boats.deleteItem(sailboat);

        assertEquals(1,boats.getCartItems().size());
        assertTrue(boats.getCartItems().contains(testSteamBoat));

    }

    @Test
    public void testDeleteItemNull(){
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                ShoppingCart boats = new ShoppingCart();
                boats.deleteItem(null);
            }
        });
    }

    @Test
    public void testDeleteItemOneLeft(){
        ShoppingCart boats = new ShoppingCart();
        Item sailboat = new Item();
        boats.addItem(sailboat);
        CartItem testSailBoat = boats.findCartItem(sailboat);
        boats.deleteItem(sailboat);

        assertEquals(null,boats.findCartItem(sailboat));
        assertFalse(boats.getCartItems().contains(testSailBoat));
        assertEquals(0,boats.getCartItems().size());
    }

    @Test
    public void testDeleteItemMultiple(){
        ShoppingCart boats = new ShoppingCart();
        Item sailboat = new Item();
        boats.addItem(sailboat);
        boats.addItem(sailboat);
        CartItem testSailBoat = boats.findCartItem(sailboat);
        boats.deleteItem(sailboat);

        assertEquals(testSailBoat, boats.findCartItem(sailboat));
        assertTrue(boats.getCartItems().contains(testSailBoat));
        assertEquals(1,testSailBoat.getCount());

    }

    @Test
    public void testFindCartItemNull(){
        ShoppingCart boats = new ShoppingCart();
        assertEquals(null, boats.findCartItem(null));
    }

    @Test
    public void testFindCartItem(){
        Item sailboat = new Item();
        ShoppingCart boats = new ShoppingCart();
        boats.addItem(sailboat);
        CartItem cartItem = new CartItem(sailboat);
        assertEquals(cartItem, boats.findCartItem(sailboat));
    }

    @Test
    public void testFindCartItemNotPresent(){
        Item sailboat = new Item();
        ShoppingCart boats = new ShoppingCart();

        assertEquals(null, boats.findCartItem(sailboat));
    }

    @Test
    public void testGetCartItemsNull(){
        ShoppingCart boats = new ShoppingCart();
        List<CartItem> test = new ArrayList<CartItem>();
        assertEquals(test, boats.getCartItems());
    }

    @Test
    public void testGetCartItems(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Item item = new Item();
        CartItem cartItem = new CartItem(item);
        List<CartItem> test = new ArrayList<CartItem>();
        test.add(cartItem);
        shoppingCart.addItem(item);
        assertEquals(test,shoppingCart.getCartItems());
    }

    @Test
    public void testGetCartItemsMultiple(){
        ShoppingCart shoppingCart = new ShoppingCart();
        Item item = new Item();
        item.setName("Eilis");
        Item item1 = new Item();
        item1.setName("Jack");

        shoppingCart.addItem(item);
        shoppingCart.addItem(item1);

        CartItem cartItem = shoppingCart.findCartItem(item);
        CartItem cartItem1 = shoppingCart.findCartItem(item1);

        assertTrue(shoppingCart.getCartItems().contains(cartItem));
        assertTrue(shoppingCart.getCartItems().contains(cartItem1));
        assertEquals(2,shoppingCart.getCartItems().size());
    }
}
