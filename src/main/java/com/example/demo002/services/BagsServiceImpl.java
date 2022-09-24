package com.example.demo002.services;

import com.example.demo002.entities.Bag;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.ArrayList;

@Service
public class BagsServiceImpl implements BagsService {
    @Override
    public Iterable<Bag> listAllBags() {
        List<Bag> bags = new ArrayList<>();

        Bag bag1 = new Bag();
        bag1.setId(1);
        bag1.setAppleNum(2);
        bag1.setSupplier("Royal Gala");
        bag1.setTime(new Date(System.currentTimeMillis()));
        bag1.setPrice(5);

        Bag bag2 = new Bag();
        bag2.setId(1);
        bag2.setAppleNum(2);
        bag2.setSupplier("Pink Lady");
        bag2.setTime(new Date(System.currentTimeMillis()));
        bag2.setPrice(5);

        Bag bag3 = new Bag();
        bag3.setId(1);
        bag3.setAppleNum(2);
        bag3.setSupplier("Kanzi Apple");
        bag3.setTime(new Date(System.currentTimeMillis()));
        bag3.setPrice(5);

        bags.add(bag1);
        bags.add(bag2);
        bags.add(bag3);

        return bags;
    }

    @Override
    public Bag addBag(Bag bag) {
        return null;
    }
}
