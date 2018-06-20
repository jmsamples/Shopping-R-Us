package com.jmsamples.rules;

import com.jmsamples.Cart;
import com.jmsamples.PricingRule;
import com.jmsamples.model.Item;
import com.jmsamples.model.Product;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class XForYDiscountRule implements PricingRule {

    private Product sku;
    private int baseQuantity;
    private int chargeQuantity;

    public XForYDiscountRule(Product sku, int baseQuantity, int chargeQuantity) {
        this.sku = sku;
        this.baseQuantity = baseQuantity;
        this.chargeQuantity = chargeQuantity;
    }

    @Override
    public void applyRule(Cart cart) {
        List<Item> items = cart.getItemsBySKU(sku);
        for (int i = 0; i < items.size(); i++) {
            if ( i + 1 == baseQuantity) {
                Item item = items.get(i);
                item.amendPrice(new BigDecimal(0));
            }
        }
    }
}
