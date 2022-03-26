// John Murray
// Eilis Casey
// Unit tests for CartItem class
import static org.junit.jupiter.api.Assertions.*;
import csc4700.Item;
import csc4700.ShoppingCart;
import csc4700.CartItem;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCartTest {

    @Test
    public void testAddItemNull(){
        ShoppingCart boats = new ShoppingCart();
        try{
           boats.addItem(null);
           fail("Expected error");
        } catch (NullPointerException e){
            //Expected
        }
    }

    @Test
    public void testAddItemFirstItem(){
        Item item = new Item();
        ShoppingCart shoppingCart = new ShoppingCart();
        CartItem cartItem = new CartItem(item);

        List<CartItem> test = new ArrayList<CartItem>();
        test.add(cartItem);

        shoppingCart.addItem(item);

        CartItem cartItem1 = shoppingCart.findCartItem(item);
        
        assertEquals(test,shoppingCart.getCartItems());
        assertEquals(1,cartItem1.getCount());
    }

    @Test
    public void testDeleteItemNotPresent(){
        ShoppingCart boats = new ShoppingCart();
        Item sailboat = new Item();
        Item motorboat = new Item();
        motorboat.setName("Eilis");
        Item steamboat = new Item();
        steamboat.setName("Jack");
        boats.addItem(motorboat);
        boats.addItem(steamboat);

        List<CartItem> test = new ArrayList<CartItem>();
        test.add(boats.findCartItem(motorboat));
        test.add(boats.findCartItem(steamboat));

        boats.deleteItem(sailboat);

        assertEquals(test,boats.getCartItems());
        assertEquals(2,boats.getCartItems().size());
    }

    @Test
    public void testDeleteItemNull(){
        ShoppingCart boats = new ShoppingCart();
        try{
            boats.deleteItem(null);
            fail("Expected error");
        }catch(NullPointerException e){
            //Expected
        }
    }

    @Test
    public void testDeleteItemOne(){
        ShoppingCart boats = new ShoppingCart();
        Item sailboat = new Item();
        boats.addItem(sailboat);

        boats.deleteItem(sailboat);

        assertEquals(null,boats.findCartItem(sailboat));
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
        assertEquals(1,testSailBoat.getCount());

    }

    @Test
    public void testFindItemNull(){
        ShoppingCart boats = new ShoppingCart();
        assertEquals(null, boats.findCartItem(null));
    }

    @Test
    public void testFindItem(){
        Item sailboat = new Item();
        ShoppingCart boats = new ShoppingCart();
        boats.addItem(sailboat);
        CartItem cartitem = new CartItem(sailboat);
        assertEquals(cartitem, boats.findCartItem(sailboat));
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
