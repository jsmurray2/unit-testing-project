// John Murray
// Eilis Casey
// Unit tests for Backup class
import static org.junit.jupiter.api.Assertions.*;

import csc4700.Backup;
import csc4700.CartItem;
import csc4700.Item;
import csc4700.ShoppingCart;
import csc4700.exceptions.SerializedFormatException;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BackupTest {

    @Test
    public void serializeShoppingCartNullTest() {
        // Call serializeShoppingCart with null
        // Assert throws NullPointerException
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Backup backup = new Backup();
                String s = backup.serializeShoppingCart(null);
            }
        });
    }

    @Test
    public void deserializeShoppingCartNullTest() {
        // Call deserializeShoppingCart() with null
        // Assert throws NullPointerException
        assertThrows(NullPointerException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Backup backup = new Backup();
                backup.deserializeShoppingCart(null);
            }
        });
    }

    @Test
    public void serializeDeserializeCartTest() throws SerializedFormatException {
        // calls serializeShoppingCart() with a cart and item
        // runs serialized cart through deserialize cart to verify
        Backup backup = new Backup();
        Item item = new Item();

        String nameStr = "Sailboat";
        int cost = 1000;
        String descriptionStr = "Sailboats are fun!";

        item.setName(nameStr);
        assertEquals(nameStr, item.getName());
        item.setCost(cost);
        assertEquals(cost, item.getCost());
        item.setDescription(descriptionStr);
        assertEquals(descriptionStr, item.getDescription());

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(item);

        String cartBackupStr = backup.serializeShoppingCart(cart);
        ShoppingCart cart1 = backup.deserializeShoppingCart(cartBackupStr);
        CartItem cartItem1 = cart1.findCartItem(item);
        Item item1 = cartItem1.getItem();

        assertTrue(item.equals(item1));
    }

    @Test
    public void deserializeShoppingCartSFExTest() {
        // Assert throws SerializedFormatException()
        assertThrows(SerializedFormatException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Backup backup = new Backup();
                backup.deserializeShoppingCart("123");
            }
        });
    }

    @Test
    public void LoadShoppingCartNoFileTest() {
        // Assert throws FileNotFoundException when bad path is passed
        assertThrows(FileNotFoundException.class, new Executable() {
            @Override
            public void execute() throws Throwable {
                Backup backup = new Backup();
                backup.loadShoppingCart(new File("fakeLocation"));
            }
        });
    }

    @Test
    public void saveLoadShoppingCartFileExistsTest() throws IOException, SerializedFormatException {
        // Tests saving and loading a backup when a file already exists
        File location = new File("saveFile");
        location.createNewFile();

        Backup backup = new Backup();
        Item item = new Item();

        String nameStr = "Sailboat";
        int cost = 1000;
        String descriptionStr = "Sailboats are fun!";

        item.setName(nameStr);
        assertEquals(nameStr, item.getName());
        item.setCost(cost);
        assertEquals(cost, item.getCost());
        item.setDescription(descriptionStr);
        assertEquals(descriptionStr, item.getDescription());

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(item);

        backup.saveShoppingCart(cart, location);
        ShoppingCart loadCart = backup.loadShoppingCart(new File("saveFile"));

        CartItem cartItem1 = loadCart.findCartItem(item);
        Item item1 = cartItem1.getItem();
        assertTrue(item.equals(item1));
    }

    @Test
    public void saveLoadShoppingCartFileNotExistTest() throws IOException, SerializedFormatException {
        // Tests saving and loading a backup when a file does not already exist
        Backup backup = new Backup();
        Item item = new Item();

        String nameStr = "Sailboat";
        int cost = 1000;
        String descriptionStr = "Sailboats are fun!";

        item.setName(nameStr);
        assertEquals(nameStr, item.getName());
        item.setCost(cost);
        assertEquals(cost, item.getCost());
        item.setDescription(descriptionStr);
        assertEquals(descriptionStr, item.getDescription());

        ShoppingCart cart = new ShoppingCart();
        cart.addItem(item);

        backup.saveShoppingCart(cart, new File("saveFile"));
        ShoppingCart loadCart = backup.loadShoppingCart(new File("saveFile"));

        CartItem cartItem1 = loadCart.findCartItem(item);
        Item item1 = cartItem1.getItem();
        assertTrue(item.equals(item1));
    }

    @AfterEach
    public void removeSaveFile() {
        // If a saveFile was created by a test, delete it
        File location = new File("saveFile");
        if (location.exists()) {
            location.delete();
        }
    }

}
