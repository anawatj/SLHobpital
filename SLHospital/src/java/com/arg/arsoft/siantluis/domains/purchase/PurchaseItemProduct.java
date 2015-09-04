/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.purchase;

import com.arg.arsoft.siantluis.domains.product.Product;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author anawatj
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PurchaseItemProduct extends PurchaseItem{
    
    
    private Product product;

    /**
     * @return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }
}
