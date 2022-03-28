// John Murray
// Eilis Casey
// Unit tests for Item class
import static org.junit.jupiter.api.Assertions.*;
import csc4700.Item;
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
        // Test false when passing null
        Item item = new Item();
        assertFalse(item.equals(null));
    }

    @Test
    public void WrongClassEqualsTest() {
        // Test false when classes not same
        Item item = new Item();
        class TestClass {}
        TestClass test = new TestClass();
        assertFalse(item.equals(test));
    }

    @Test
    public void EqualsTest() {
        // Test false when two Item objects are not equal
        Item item = new Item();
        item.setName("one");
        assertEquals("one", item.getName());
        Item item2 = new Item();
        item2.setName("name");
        assertEquals("name", item2.getName());
        assertFalse(item.equals(item2));
    }

    @Test
    public void SetGetNameTest() {
        // Verify setName and getName
        Item item = new Item();
        item.setName("item1");
        assertEquals("item1", item.getName());
    }

    @Test
    public void HashCodeNameTest() {
        // Verify hashCode
        Item item = new Item();
        item.setName("item1");
        assertEquals("item1", item.getName());
        String name = item.getName();
        assertEquals("item1", item.getName());
        assertEquals(name.hashCode(), item.hashCode());
    }

    @Test
    public void SetGetCostTest() {
        // Verify setCost and getCost
        Item item = new Item();
        int cost = 5;
        item.setCost(cost);
        assertEquals(cost, item.getCost());
    }

    @Test
    public void SetGetDescriptionTest() {
        // Verify setDescription and getDescription
        Item item = new Item();
        String description = "I am an item";
        item.setDescription(description);
        assertEquals(description, item.getDescription());
    }
}
