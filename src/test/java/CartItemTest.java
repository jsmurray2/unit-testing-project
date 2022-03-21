// John Murray
// Eilis Casey
// Unit tests for CartItem class
import static org.junit.jupiter.api.Assertions.*;
import csc4700.CartItem;
import csc4700.Item;
import csc4700.exceptions.InvalidCountException;
import org.junit.jupiter.api.Test;

public class CartItemTest {
   private Item sailboat = new Item();


   @Test
   public void incrementCountByOneTest(){
      //Test for correct increment
      CartItem boats = new CartItem(sailboat);
      boats.incrementCountByOne();
      int testCount=boats.getCount();
      assertEquals(1,testCount);
   }

   @Test
   public void testMultipleIncrementCountByOne(){
      //Test for correct increment
      CartItem boats = new CartItem(sailboat);
      boats.incrementCountByOne();
      boats.incrementCountByOne();
      int testCount=boats.getCount();
      assertEquals(2,testCount);
   }

   @Test
   public void testDecrementCountByOne(){
      //Test for correct decrement
      CartItem boats = new CartItem(sailboat);
      boats.setCount(5);
      boats.decrementCountByOne();
      int testCount = boats.getCount();
      assertEquals(4,testCount);

   }

   @Test
   public void testDecrementCountByOneLessThanOne(){
      //Test for error thrown when decremented value is less than one
      CartItem boats = new CartItem(sailboat);
      boats.setCount(1);
      try{
         boats.decrementCountByOne();
         fail("Expected error");
      } catch(InvalidCountException e){
         //Expected
      }

   }

   @Test
   public void testMultipleDecrementCountByOne(){
      //Test for correct decrement
      CartItem boats = new CartItem(sailboat);
      boats.setCount(5);
      boats.decrementCountByOne();
      boats.decrementCountByOne();
      int testCount = boats.getCount();
      assertEquals(3,testCount);

   }

   @Test
   public void testMultipleDecrementCountByOneLessThanOne(){
      //Test for error thrown when decremented value is less than one
      CartItem boats = new CartItem(sailboat);
      boats.setCount(1);
      try{
         boats.decrementCountByOne();
         boats.decrementCountByOne();
         fail("Expected error");
      } catch(InvalidCountException e){
         //Expected
      }
   }

   @Test
   public void testEqualsPassSelf(){
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
      Item car =new Item();
      car.setName("jack");
      CartItem vehicle = new CartItem(car);
      assertFalse(boats.equals(vehicle));

   }

   @Test
   public void testHashCodePassSelf(){
      CartItem boats = new CartItem(sailboat);
      sailboat.setName("Eilis");
      String name = sailboat.getName();
      assertEquals(name.hashCode(), boats.hashCode());
   }

   @Test
   public void testHashCodePassDifferent(){
      CartItem boats = new CartItem(sailboat);
      sailboat.setName("Eilis");
      Item car =new Item();
      car.setName("jack");
      CartItem vehicle = new CartItem(car);
      assertNotEquals(vehicle.hashCode(),boats.hashCode());
   }

   @Test
   public void testHashCodeNull(){
      CartItem boats = new CartItem(null);
      assertEquals(boats.hashCode(),0);
   }

   @Test
   public void testSetGetItem(){
      CartItem boats = new CartItem(sailboat);
      Item motorboat = new Item();
      boats.setItem(motorboat);
      assertEquals(motorboat,boats.getItem());

   }

   @Test
   public void testMutlipleSetItem(){
      CartItem boats = new CartItem(sailboat);
      Item motorboat = new Item();
      Item rowboat = new Item();
      boats.setItem(motorboat);
      boats.setItem(rowboat);
      assertEquals(rowboat,boats.getItem());

   }

   @Test
   public void testSetGetCount(){
      CartItem boats = new CartItem(sailboat);
      int testCount = 5;
      boats.setCount(testCount);
      assertEquals(testCount,boats.getCount());
   }

   @Test
   public void testMultipleSetCount(){
      CartItem boats = new CartItem(sailboat);
      int testCount = 5;
      boats.setCount(10);
      boats.setCount(testCount);
      assertEquals(testCount,boats.getCount());
   }

   @Test
   public void testSetCountError(){
      CartItem boats = new CartItem(sailboat);
      try{
         boats.setCount(0);
         fail("Expected error");
      } catch(InvalidCountException e){
         //Expected
      }
   }
}
