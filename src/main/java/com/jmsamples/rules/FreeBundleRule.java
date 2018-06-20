package com.jmsamples.rules;

import com.jmsamples.Cart;
import com.jmsamples.PricingRule;
import com.jmsamples.model.Item;
import com.jmsamples.model.Product;

import java.math.BigDecimal;
import java.util.List;

public class FreeBundleRule implements PricingRule {

    private Product sku;
    private Product skuFreeItem;

    public FreeBundleRule(Product sku, Product skuFreeItem) {
        this.sku = sku;
        this.skuFreeItem = skuFreeItem;
    }

    @Override
    public void applyRule(Cart cart) {
        List<Item> items = cart.getItemsBySKU(sku);
        List<Item> itemsFree = cart.getItemsBySKU(skuFreeItem);
        for (int i = 0; i < itemsFree.size(); i++) {
            //free item for every base item
            if (i < items.size() ) {
                Item item = itemsFree.get(i);
                item.amendPrice(new BigDecimal(0));
            }
        }
    }
}
