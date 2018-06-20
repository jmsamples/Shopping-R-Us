package com.jmsamples;

import com.jmsamples.model.Item;
import com.jmsamples.model.Product;

import java.math.BigDecimal;
import java.util.*;

public class Cart {
    private List<Item> cartItems = new ArrayList();

    public void addCartItem(Item item) {
        cartItems.add(item);
    }

    public List<Item> getItemsBySKU(Product sku) {
        List<Item> matchingItems = new ArrayList<>();
        for (Item item : this.cartItems) {
            if (item.getSku().equals(sku)) {
                matchingItems.add(item);
            }
        }
        return matchingItems;
    }

    public BigDecimal getTotal() {
        BigDecimal cartTotal = new BigDecimal(0);
        for (Item item : this.cartItems) {
            cartTotal = cartTotal.add(item.getPrice());
        }
        return cartTotal;
    }
}
