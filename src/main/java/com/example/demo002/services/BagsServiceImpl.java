package com.example.demo002.services;

import com.example.demo002.entities.Bag;
import com.example.demo002.repository.BagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.ArrayList;

@Service
public class BagsServiceImpl implements BagsService {
    @Autowired
    private BagRepository repository;

    @Override
    public Iterable<Bag> listAllBags() {
        List<Bag> bags = (List<Bag>) repository.findAll();

        return bags;
    }

    @Override
    public Bag addBag(Bag bag) {
        Bag bag2 = repository.save(bag);

        return bag2;
    }
}
