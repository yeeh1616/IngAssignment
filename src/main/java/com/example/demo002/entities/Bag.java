package com.example.demo002.entities;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Product entity.
 */

public class Bag {
    private Integer id;
    private Integer appleNum;
    private String supplier;
    private Date time;
    private Integer price;

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppleNum() {
        return appleNum;
    }

    public void setAppleNum(Integer appleNum) {
        this.appleNum = appleNum;
    }
}