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
   private Item sailboat = new Item();

   @Test
   public void testCartItem() {
      CartItem boats = new CartItem(sailboat);
      assertEquals(sailboat, boats.getItem());
      assertEquals(0, boats.getCount());
   }

   @Test
   public void incrementCountByOneTest() {
      //Test for correct increment
      CartItem boats = new CartItem(sailboat);
      assertEquals(0, boats.getCount());
      boats.incrementCountByOne();
      int testCount=boats.getCount();
      assertEquals(1, testCount);
   }

   @Test
   public void testMultipleIncrementCountByOne() {
      //Test for correct increment
      CartItem boats = new CartItem(sailboat);
      assertEquals(0, boats.getCount());
      boats.incrementCountByOne();
      assertEquals(1, boats.getCount());
      boats.incrementCountByOne();
      assertEquals(2, boats.getCount());
   }

   @Test
   public void testDecrementCountByOne() {
      //Test for correct decrement
      CartItem boats = new CartItem(sailboat);
      boats.setCount(5);
      assertEquals(5, boats.getCount());
      boats.decrementCountByOne();
      assertEquals(4, boats.getCount());
   }

   @Test
   public void testDecrementCountByOneLessThanOne() {
      //Test for error thrown when decremented value is less than one

      assertThrows(InvalidCountException.class, new Executable() {
         @Override
         public void execute() throws Throwable {
            CartItem boats = new CartItem(sailboat);
            assertEquals(0, boats.getCount());
            boats.setCount(1);
            assertEquals(1, boats.getCount());
            boats.decrementCountByOne();
         }
      });
   }

   @Test
   public void testMultipleDecrementCountByOne() {
      //Test for correct decrement
      CartItem boats = new CartItem(sailboat);
      assertEquals(0, boats.getCount());
      boats.setCount(5);
      assertEquals(5, boats.getCount());
      boats.decrementCountByOne();
      assertEquals(4, boats.getCount());
      boats.decrementCountByOne();
      assertEquals(3, boats.getCount());
   }

   @Test
   public void testMultipleDecrementCountByOneLessThanOne() {
      //Test for error thrown when decremented value is less than one
      assertThrows(InvalidCountException.class, new Executable() {
         @Override
         public void execute() throws Throwable {
            CartItem boats = new CartItem(sailboat);
            assertEquals(0, boats.getCount());
            boats.setCount(1);
            assertEquals(1, boats.getCount());
            boats.decrementCountByOne();
            assertEquals(0, boats.getCount());
            boats.decrementCountByOne();
         }
      });
   }

   @Test
   public void testEqualsPassSelf() {
      CartItem boats = new CartItem(sailboat);
      assertTrue(boats.equals(boats));
   }

   @Test
   public void testEqualsPassNull(){
      CartItem boats=new CartItem(sailboat);
      assertFalse(boats.equals(null));
   }

   @Test
   public void testEqualsWrongClass(){
      CartItem boats = new CartItem(sailboat);
      class TestClass{}
      TestClass test = new TestClass();
      assertFalse(boats.equals(test));
   }

   @Test
   public void testEquals(){
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
      CartItem boats = new CartItem(sailboat);
      sailboat.setName("Eilis");
      assertEquals("Eilis", sailboat.getName());
      String name = sailboat.getName();
      assertEquals(name.hashCode(), boats.hashCode());
   }

   @Test
   public void testHashCodePassDifferent(){
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
      CartItem boats = new CartItem(null);
      assertEquals(0, boats.hashCode());
   }

   @Test
   public void testSetGetItem() {
      CartItem boats = new CartItem(sailboat);
      Item motorboat = new Item();
      boats.setItem(motorboat);
      assertEquals(motorboat,boats.getItem());

   }

   @Test
   public void testMutlipleSetItem() {
      CartItem boats = new CartItem(sailboat);
      Item motorboat = new Item();
      Item rowboat = new Item();
      boats.setItem(motorboat);
      boats.setItem(rowboat);
      assertEquals(rowboat, boats.getItem());
   }

   @Test
   public void testSetGetCount() {
      CartItem boats = new CartItem(sailboat);
      boats.setCount(5);
      assertEquals(5, boats.getCount());
   }

   @Test
   public void testMultipleSetCount() {
      CartItem boats = new CartItem(sailboat);
      assertEquals(0, boats.getCount());
      boats.setCount(10);
      assertEquals(10, boats.getCount());
      boats.setCount(5);
      assertEquals(5, boats.getCount());
   }

   @Test
   public void testSetCountError(){
      assertThrows(InvalidCountException.class, new Executable() {
         @Override
         public void execute() throws Throwable {
            CartItem boats = new CartItem(sailboat);
            boats.setCount(0);
         }
      });
   }
}
