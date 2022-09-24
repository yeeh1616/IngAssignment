package com.example.demo002.repository;

import com.example.demo002.entities.Bag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BagRepository extends CrudRepository<Bag, Long> {

}
