package com.jmsamples.model;

public enum Product {
    IPD ("IPD", "Super iPad"),
    MBP ("MBP", "MacBook Pro"),
    ATV ("ATV", "Apple TV"),
    VGA ("VGA", "VGA adapter");

    private final String sku;
    private final String name;

    Product(final String sku, final String name) {
        this.sku = sku;
        this.name = name;
    }

    public Product getSKU() {
        return this.getSKU();
    }

    public String getName(){
        return this.getName();
    }
}
