// John Murray
// Eilis Casey
// Unit tests for CartItem class
import static org.junit.jupiter.api.Assertions.*;
import csc4700.CartItem;
import csc4700.Item;
import csc4700.exceptions.InvalidCountException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

public class CartItemTest {

   @Test
   public void testCartItem() {
      // Tests the constructor
      // Makes sure the count and item were stored correctly
      Item sailboat = new Item();
      CartItem boats = new CartItem(sailboat);
      assertEquals(sailboat, boats.getItem());
      assertEquals(0, boats.getCount());
   }

   @Test
   public void testIncrementCount() {
      // Test for correct increment when called
      Item sailboat = new Item();
      CartItem boats = new CartItem(sailboat);
      assertEquals(0, boats.getCount());
      boats.incrementCountByOne();
      assertEquals(1, boats.getCount());
      boats.incrementCountByOne();
      assertEquals(2, boats.getCount());
   }


   @Test
   public void testDecrementCount() {
      // Test for correct decrement when called
      Item sailboat = new Item();
      CartItem boats = new CartItem(sailboat);
      boats.setCount(5);
      assertEquals(5, boats.getCount());
      boats.decrementCountByOne();
      assertEquals(4, boats.getCount());
      boats.decrementCountByOne();
      assertEquals(3, boats.getCount());
   }

   @Test
   public void testDecrementCountException() {
      // Test for when decremented value is less than one
      // Error should be thrown
      assertThrows(InvalidCountException.class, new Executable() {
         @Override
         public void execute() throws Throwable {
            Item sailboat = new Item();
            CartItem boats = new CartItem(sailboat);
            assertEquals(0, boats.getCount());
            boats.setCount(2);
            assertEquals(2, boats.getCount());
            boats.decrementCountByOne();
            assertEquals(1, boats.getCount());
            boats.decrementCountByOne();
         }
      });
   }

   @Test
   public void testEqualsPassSelf() {
      // Test for correct object pass
      Item sailboat = new Item();
      CartItem boats = new CartItem(sailboat);
      assertTrue(boats.equals(boats));
   }

   @Test
   public void testEqualsPassNull(){
      // Test false when passing null
      Item sailboat = new Item();
      CartItem boats=new CartItem(sailboat);
      assertFalse(boats.equals(null));
   }

   @Test
   public void testEqualsWrongClass(){
      // Test false when classes not same
      Item sailboat = new Item();
      CartItem boats = new CartItem(sailboat);
      class TestClass{}
      TestClass test = new TestClass();
      assertFalse(boats.equals(test));
   }

   @Test
   public void testEquals(){
      // Test false when two Item objects are not equal
      Item sailboat = new Item();
      CartItem boats = new CartItem(sailboat);
      sailboat.setName("Eilis");
      assertEquals("Eilis", sailboat.getName());
      Item car = new Item();
      car.setName("Jack");
      assertEquals("Jack", car.getName());
      CartItem vehicle = new CartItem(car);
      assertFalse(boats.equals(vehicle));
   }

   @Test
   public void testHashCodePassSelf(){
      // Verify hashCode
      Item sailboat = new Item();
      CartItem boats = new CartItem(sailboat);
      sailboat.setName("Eilis");
      assertEquals("Eilis", sailboat.getName());
      String name = sailboat.getName();
      assertEquals(name.hashCode(), boats.hashCode());
   }

   @Test
   public void testHashCodePassDifferent(){
      // Verify different items have unique hashcodes
      Item sailboat = new Item();
      CartItem boats = new CartItem(sailboat);
      sailboat.setName("Eilis");
      assertEquals("Eilis", sailboat.getName());
      Item car = new Item();
      car.setName("Jack");
      assertEquals("Jack", car.getName());
      CartItem vehicle = new CartItem(car);
      assertNotEquals(vehicle.hashCode(), boats.hashCode());
   }

   @Test
   public void testHashCodeNull() {
      // Test for when null is passed
      CartItem boats = new CartItem(null);
      assertEquals(0, boats.hashCode());
   }

   @Test
   public void testSetGetItem() {
      // Verify setItem and getItem
      Item sailboat = new Item();
      CartItem boats = new CartItem(sailboat);
      Item motorboat = new Item();
      boats.setItem(motorboat);
      assertEquals(motorboat,boats.getItem());

   }

   @Test
   public void testSetItemMultiple() {
      // Test when multiple setItems are called
      Item sailboat = new Item();
      CartItem boats = new CartItem(sailboat);
      Item motorboat = new Item();
      Item rowboat = new Item();
      boats.setItem(motorboat);
      boats.setItem(rowboat);
      assertEquals(rowboat, boats.getItem());
   }

   @Test
   public void testSetGetCount() {
      // Verify setCount and getCount
      Item sailboat = new Item();
      CartItem boats = new CartItem(sailboat);
      boats.setCount(5);
      assertEquals(5, boats.getCount());
   }

   @Test
   public void testSetCountMultiple() {
      // Test when multiple setCounts are called
      Item sailboat = new Item();
      CartItem boats = new CartItem(sailboat);
      assertEquals(0, boats.getCount());
      boats.setCount(10);
      assertEquals(10, boats.getCount());
      boats.setCount(5);
      assertEquals(5, boats.getCount());
   }

   @Test
   public void testSetCountError(){
      // Verify error thrown when count is less than 0
      assertThrows(InvalidCountException.class, new Executable() {
         @Override
         public void execute() throws Throwable {
            Item sailboat = new Item();
            CartItem boats = new CartItem(sailboat);
            boats.setCount(0);
         }
      });
   }
}
