package com.jmsamples.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Item {
    private Product sku;
    private BigDecimal price;

    public Item(Product sku, BigDecimal price) {
        this.sku = sku;
        this.price = price;
    }

    public Product getSku() {
        return sku;
    }

    public String getName() {
        return sku.getName();
    }

    public BigDecimal getPrice() {
        return price;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return getSku() == item.getSku();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSku());
    }

    public void amendPrice(BigDecimal newPrice) {
        this.price = newPrice;
    }
}
