// John Murray
// Unit tests for Item class
import static org.junit.jupiter.api.Assertions.*;

import csc4700.CartItem;
import csc4700.Item;
import csc4700.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void EqualsTestPassSelf() {
        // Test for correct object pass
        Item item = new Item();
        assertTrue(item.equals(item));
    }

    @Test
    public void EqualsTestPassNull() {
        // Test False when passing null
        Item item = new Item();
        assertFalse(item.equals(null));
    }

//    @Test
//    public void WrongClassEqualsTest() {
//        Item item = new Item();
//        ShoppingCart cart = new ShoppingCart();
//        assertFalse(item.equals(cart));
//    }

    @Test
    public void WrongClassEqualsTest() {
        Item item = new Item();
        class TestClass {}
        TestClass test = new TestClass();
        assertFalse(item.equals(test));
    }

    @Test
    public void EqualsTest() {
        Item item = new Item();
        item.setName("one");
        Item item2 = new Item();
        item2.setName("name");
        assertFalse(item.equals(item2));
    }

    @Test
    public void SetGetNameTest() {
        // Verify setName and getName
        Item item = new Item();
        item.setName("item1");
        String name = item.getName();
        assertEquals("item1", name);
    }

    @Test
    public void HashCodeNameTest() {
        Item item = new Item();
        item.setName("item1");
        String name = item.getName();
        assertEquals(name.hashCode(), item.hashCode());
    }

    @Test
    public void SetGetCostTest() {
        Item item = new Item();
        int cost = 5;
        item.setCost(cost);
        assertEquals(cost, item.getCost());
    }

    @Test
    public void SetGetDescriptionTest() {
        Item item = new Item();
        String description = "I am an item";
        item.setDescription(description);
        assertEquals(description, item.getDescription());
    }

}
