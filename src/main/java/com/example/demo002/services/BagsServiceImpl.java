package com.example.demo002.services;

import com.example.demo002.entities.Bag;
import com.example.demo002.repository.BagRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BagsServiceImpl implements BagsService {
    @Autowired
    private BagRepository repository;

    @Override
    public Iterable<Bag> listAllBags(Integer bagsNum) {
        Iterable<Bag> res = repository.getBagsWithLimit(0, bagsNum);
        return res;
    }

    @Override
    public Bag addBag(Bag bag) {
        return repository.save(bag);
    }
}
