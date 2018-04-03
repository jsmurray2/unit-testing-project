package csc4700;

import csc4700.exceptions.SerializedFormatException;

import java.io.*;

public class Backup {


    public static final String FIELD_SEPARATOR = ",";
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    public String serializeShoppingCart(ShoppingCart cart) {
        if (cart == null) {
            throw new NullPointerException();
        }

        StringBuffer allCartItems = new StringBuffer();
        for (CartItem cartItem : cart.getCartItems()) {
            Item item = cartItem.getItem();
            StringBuffer itemLine = new StringBuffer();
            itemLine.append(item.getName());
            itemLine.append(FIELD_SEPARATOR);
            itemLine.append(item.getCost());
            itemLine.append(FIELD_SEPARATOR);
            itemLine.append(item.getDescription());
            itemLine.append(FIELD_SEPARATOR);
            itemLine.append(cartItem.getCount());

            allCartItems.append(itemLine.toString());
            allCartItems.append(LINE_SEPARATOR);
        }

        return allCartItems.toString();
    }


    public ShoppingCart deserializeShoppingCart(String s) throws SerializedFormatException {
        if (s == null) {
            throw new NullPointerException();
        }

        ShoppingCart cart = new ShoppingCart();

        String[] allCartItems = s.split(LINE_SEPARATOR);
        for (String cartItemLine : allCartItems) {
            String[] itemLinePieces = cartItemLine.split(FIELD_SEPARATOR);
            if (itemLinePieces.length != 4) {
                throw new SerializedFormatException();
            }

            Item item = new Item();
            item.setName(itemLinePieces[0]);
            item.setCost(Integer.parseInt(itemLinePieces[1]));
            item.setDescription(itemLinePieces[2]);

            // Yes, no one in their right mind would design it this way instead of
            // just exposing the set count through the cart itself. I'm just doing it here
            // for project purposes; don't judge me :)
            int numItems = Integer.parseInt(itemLinePieces[3]);
            for (int i = 1; i <= numItems; i++) {
                cart.addItem(item);
            }
        }

        return cart;
    }


    public void saveShoppingCart(ShoppingCart saveMe, File location) throws IOException {

        // If there is already a file at the given location, delete it before continuing.
        if (location.exists()) {
            location.delete();
        }

        // Serialize the contact list to be written to the file.
        String serialized = serializeShoppingCart(saveMe);

        BufferedWriter bw = new BufferedWriter(new FileWriter(location));
        bw.write(serialized);
        bw.close();
    }

    public ShoppingCart loadShoppingCart(File location)
            throws IOException, SerializedFormatException {

        // If the file isn't found, throw an error.
        if (!location.exists()) {
            throw new FileNotFoundException();
        }

        // Read in the contents of the serialized file.
        BufferedReader br = new BufferedReader(new FileReader(location));
        String line;
        StringBuffer allLines = new StringBuffer();
        while ((line = br.readLine()) != null) {
            allLines.append(line);
            allLines.append(LINE_SEPARATOR);
        }
        br.close();

        // Deserialize the contents into a ContactList.
        ShoppingCart result = deserializeShoppingCart(allLines.toString());
        return result;
    }

}
