package com.example.demo002.controller;

import com.example.demo002.Exception.ApiResponse;
import com.example.demo002.Exception.BagsapiException;
import com.example.demo002.entities.Bag;
import com.example.demo002.services.BagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/*
http://127.0.0.1:8080/bags
http://127.0.0.1:8080/bags?bagsNum=10
http://127.0.0.1:8080/bagsui

Add a bag:
http://127.0.0.1:8080/bags
-- in postman, select Body, raw and JSON, input the following data in Json:
{
    "applenum": 2,
    "supplier": "ROYAL_GALA",
    "time": "2022-09-24T20:10:02.890+00:00",
    "price": 5
}
* */

@RestController
@RequestMapping("/bags")
public class BagsRestController {
    @Autowired
    private BagsService bagsService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Iterable<Bag>> getList(@RequestParam(name = "bagsNum", defaultValue = "3") Integer bagsNum) {
        return ResponseEntity.ok(bagsService.listAllBags(bagsNum));
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public ResponseEntity<Object> add(@RequestBody Bag bag) {
        if (bag.getId() != null) {
            bag.setId(null);
        }

        try {
            if (bag.getApplenum() < 1 || bag.getApplenum() > 100) {
                throw new Exception();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(Boolean.FALSE, "Apple number should be in (minimum 1, maximum 100)"));
        }

        try {
            if (bag.getPrice() < 1 || bag.getPrice() > 50) {
                throw new Exception();
            }
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(new ApiResponse(Boolean.FALSE, "Price should be a number from 1 to 50"));
        }

        return ResponseEntity.ok(bagsService.addBag(bag));
    }
}
