/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.purchase;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.arg.arsoft.siantluis.domains.product.Product;
import com.fasterxml.jackson.annotation.JsonInclude;

/**
 *
 * @author anawatj
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class PurchaseItem extends AbstractDomain<Integer> {

    private Integer purchaseId;
    //private Product product;
    private Integer quantity;
    private Double unitPrice;
    private Double vat;
    private FlagVat flagVat;
    private boolean selected;

    /**
     * @return the product
     */
    /*  public Product getProduct() {
     return product;
     }*/
    /**
     * @param product the product to set
     */
    /*public void setProduct(Product product) {
     this.product = product;
     }*/
    /**
     * @return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return the unitPrice
     */
    public Double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the vat
     */
    public Double getVat() {
        return vat;
    }

    /**
     * @param vat the vat to set
     */
    public void setVat(Double vat) {
        this.vat = vat;
    }

    /**
     * @return the flagVat
     */
    public FlagVat getFlagVat() {
        return flagVat;
    }

    /**
     * @param flagVat the flagVat to set
     */
    public void setFlagVat(FlagVat flagVat) {
        this.flagVat = flagVat;
    }

    /**
     * @return the purchaseId
     */
    public Integer getPurchaseId() {
        return purchaseId;
    }

    /**
     * @param purchaseId the purchaseId to set
     */
    public void setPurchaseId(Integer purchaseId) {
        this.purchaseId = purchaseId;
    }

    /**
     * @return the selected
     */
    public boolean getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
