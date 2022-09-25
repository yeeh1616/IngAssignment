package com.example.demo002.entities;

import java.util.Date;
import java.util.UUID;
import javax.persistence.*;

/**
 * Product entity.
 */
@Entity
@Table(name = "bag")
public class Bag {
    enum Supplier {
        ROYAL_GALA,
        PINK_LADY,
        KANZI_APPLE,
        ELSTAR_APPLES
    };

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private Integer applenum;
    private Supplier supplier;
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

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Integer getApplenum() {
        return applenum;
    }

    public void setApplenum(Integer appleNum) {
        this.applenum = appleNum;
    }
}