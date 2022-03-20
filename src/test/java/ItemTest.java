// John Murray
// Eilis Casey
// Unit tests for Item class
import static org.junit.jupiter.api.Assertions.*;
import csc4700.Item;
import org.junit.jupiter.api.Test;

public class ItemTest {

    @Test
    public void equalsTestPassSelf() {
        // Test for correct object pass
        Item item = new Item();
        assertTrue(item.equals(item));
    }

    @Test
    public void equalsTestPassNull() {
        // Test false when passing null
        Item item = new Item();
        assertFalse(item.equals(null));
    }

    @Test
    public void wrongClassEqualsTest() {
        // Test false when classes not same
        Item item = new Item();
        class TestClass {}
        TestClass test = new TestClass();
        assertFalse(item.equals(test));
    }

    @Test
    public void equalsTest() {
        // Test false when two Item objects are not equal
        Item item = new Item();
        item.setName("one");
        Item item2 = new Item();
        item2.setName("name");
        assertFalse(item.equals(item2));
    }

    @Test
    public void setGetNameTest() {
        // Verify setName and getName
        Item item = new Item();
        item.setName("item1");
        String name = item.getName();
        assertEquals("item1", name);
    }

    @Test
    public void hashCodeNameTest() {
        // Verify hashCode
        Item item = new Item();
        item.setName("item1");
        String name = item.getName();
        assertEquals(name.hashCode(), item.hashCode());
    }

    @Test
    public void setGetCostTest() {
        // Verify setCost and getCost
        Item item = new Item();
        int cost = 5;
        item.setCost(cost);
        assertEquals(cost, item.getCost());
    }

    @Test
    public void setGetDescriptionTest() {
        // Verify setDescription and getDescription
        Item item = new Item();
        String description = "I am an item";
        item.setDescription(description);
        assertEquals(description, item.getDescription());
    }
}
