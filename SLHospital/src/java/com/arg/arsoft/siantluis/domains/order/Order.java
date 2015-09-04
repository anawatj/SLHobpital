/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.arg.arsoft.siantluis.domains.order;

import com.arg.arsoft.siantluis.domains.AbstractDomain;
import com.arg.arsoft.siantluis.domains.DateDeSeriialize;
import com.arg.arsoft.siantluis.domains.DateSerialize;
import com.arg.arsoft.siantluis.domains.customer.Customer;
import com.arg.arsoft.siantluis.domains.employee.Employee;
import com.arg.arsoft.siantluis.domains.master.Address;
import com.arg.arsoft.siantluis.domains.master.Shipper;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author anawatj
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Order extends AbstractDomain<Integer> {

    public Order() {
        this.items = new ArrayList<OrderItem>();
    }
    private String code;
  //  @JsonSerialize(using = DateSerialize.class)
 //   @JsonDeserialize(using = DateDeSeriialize.class)
    private Date orderDate;
 //   @JsonSerialize(using = DateSerialize.class)
  //  @JsonDeserialize(using = DateDeSeriialize.class)
    private Date requireDate;
  //  @JsonSerialize(using = DateSerialize.class)
  //  @JsonDeserialize(using = DateDeSeriialize.class)
    private Date shipperDate;
    private String description;
    private Address address;
    private String shippName;
    private Shipper shipper;
    private Double freight;
    private Customer customer;
    private Employee requestBy;
    private Employee approveBy;
  //  @JsonSerialize(using = DateSerialize.class)
  //  @JsonDeserialize(using = DateDeSeriialize.class)
    private Date approveDate;
    private OrderStatus status;
    private List<OrderItem> items;

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the orderDate
     */
    public Date getOrderDate() {
        return orderDate;
    }

    /**
     * @param orderDate the orderDate to set
     */
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    /**
     * @return the requireDate
     */
    public Date getRequireDate() {
        return requireDate;
    }

    /**
     * @param requireDate the requireDate to set
     */
    public void setRequireDate(Date requireDate) {
        this.requireDate = requireDate;
    }

    /**
     * @return the shipperDate
     */
    public Date getShipperDate() {
        return shipperDate;
    }

    /**
     * @param shipperDate the shipperDate to set
     */
    public void setShipperDate(Date shipperDate) {
        this.shipperDate = shipperDate;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the address
     */
    public Address getAddress() {
        return address;
    }

    /**
     * @param address the address to set
     */
    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * @return the shippName
     */
    public String getShippName() {
        return shippName;
    }

    /**
     * @param shippName the shippName to set
     */
    public void setShippName(String shippName) {
        this.shippName = shippName;
    }

    /**
     * @return the shipper
     */
    public Shipper getShipper() {
        return shipper;
    }

    /**
     * @param shipper the shipper to set
     */
    public void setShipper(Shipper shipper) {
        this.shipper = shipper;
    }

    /**
     * @return the freight
     */
    public Double getFreight() {
        return freight;
    }

    /**
     * @param freight the freight to set
     */
    public void setFreight(Double freight) {
        this.freight = freight;
    }

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the requestBy
     */
    public Employee getRequestBy() {
        return requestBy;
    }

    /**
     * @param requestBy the requestBy to set
     */
    public void setRequestBy(Employee requestBy) {
        this.requestBy = requestBy;
    }

    /**
     * @return the approveBy
     */
    public Employee getApproveBy() {
        return approveBy;
    }

    /**
     * @param approveBy the approveBy to set
     */
    public void setApproveBy(Employee approveBy) {
        this.approveBy = approveBy;
    }

    /**
     * @return the approveDate
     */
    public Date getApproveDate() {
        return approveDate;
    }

    /**
     * @param approveDate the approveDate to set
     */
    public void setApproveDate(Date approveDate) {
        this.approveDate = approveDate;
    }

    /**
     * @return the status
     */
    public OrderStatus getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    /**
     * @return the items
     */
    public List<OrderItem> getItems() {
        return items;
    }

    /**
     * @param items the items to set
     */
    public void setItems(List<OrderItem> items) {
        this.items = items;
    }
}
