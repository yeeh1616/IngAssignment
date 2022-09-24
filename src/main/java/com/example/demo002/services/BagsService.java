package com.example.demo002.services;


import com.example.demo002.entities.Bag;

public interface BagsService {
    Iterable<Bag> listAllBags();
    Bag addBag(Bag bag);
}
