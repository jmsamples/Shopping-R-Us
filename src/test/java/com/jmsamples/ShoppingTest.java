package com.jmsamples;

import com.jmsamples.exception.ShopException;
import com.jmsamples.model.Product;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;

import static com.jmsamples.model.Product.*;
import static junit.framework.TestCase.assertEquals;

public class ShoppingTest {

    private Store store;

    @Before
    public void setup() {
        store = new Store();
    }

    @Test
    public void givenAtvAtvAtvVgaShouldReturn249() throws ShopException {
        Map<Product, PricingRule> pricingRules = store.getPricingRules();

        //SKUs Scanned: atv, atv, atv, vga
        //Total expected: $249.00
        Checkout co = new Checkout(pricingRules);
        co.setStore(store);
        co.scan(ATV);
        co.scan(ATV);
        co.scan(ATV);
        co.scan(VGA);
        BigDecimal totalPrice = co.total();

        assertEquals(totalPrice.doubleValue() , 249.0);

        System.out.println("Total is " + totalPrice);

    }

    @Test
    public void givenAtvIpdIpdAtvIpdIpdIpdShouldReturn2718point95() throws ShopException {
        Map<Product, PricingRule> pricingRules = store.getPricingRules();

        //SKUs Scanned: atv, ipd, ipd, atv, ipd, ipd, ipd
        //Total expected: $2718.95
        Checkout co = new Checkout(pricingRules);
        co.setStore(store);
        co.scan(ATV);
        co.scan(IPD);
        co.scan(IPD);
        co.scan(ATV);
        co.scan(IPD);
        co.scan(IPD);
        co.scan(IPD);
        BigDecimal totalPrice = co.total();

        assertEquals(totalPrice.doubleValue() , 2718.95);

        System.out.println("Total is " + totalPrice);

    }

    @Test
    public void givenMpbVgaIpdShouldReturn1949point98() throws ShopException {
        Map<Product, PricingRule> pricingRules = store.getPricingRules();

        //SKUs Scanned: atv, ipd, ipd, atv, ipd, ipd, ipd
        //Total expected: $2718.95
        Checkout co = new Checkout(pricingRules);
        co.setStore(store);
        co.scan(MBP);
        co.scan(VGA);
        co.scan(IPD);
        BigDecimal totalPrice = co.total();

        assertEquals(totalPrice.doubleValue() , 1949.98);

        System.out.println("Total is " + totalPrice);

    }

    @Test(expected = ShopException.class)
    public void givenNullItemShouldReturnException() throws ShopException {
        Map<Product, PricingRule> pricingRules = store.getPricingRules();

        Checkout checkout = new Checkout(pricingRules);
        checkout.scan(null);

    }


}
