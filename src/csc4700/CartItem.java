package csc4700;

import csc4700.exceptions.InvalidCountException;

public class CartItem {

    private Item item;
    private int count;

    public CartItem(Item item) {
        this.item = item;
        this.count = 0;
    }

    public void incrementCountByOne() {
        setCount(getCount() + 1);
    }

    public void decrementCountByOne() {
        setCount(getCount() - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CartItem cartItem = (CartItem) o;

        return item.equals(cartItem.item);

    }

    @Override
    public int hashCode() {
        return item != null ? item.hashCode() : 0;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        if (count <= 0) {
            throw new InvalidCountException();
        }
        this.count = count;
    }
}
