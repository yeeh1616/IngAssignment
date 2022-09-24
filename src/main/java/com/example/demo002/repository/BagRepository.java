package com.example.demo002.repository;

import com.example.demo002.entities.Bag;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BagRepository extends CrudRepository<Bag, Long> {
    @Query(value = "SELECT * FROM bag LIMIT :limit OFFSET :start", nativeQuery = true)
    List<Bag> getBagsWithLimit(@Param("start") Integer start, @Param("limit") Integer limit);
}
