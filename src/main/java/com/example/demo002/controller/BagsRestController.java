package com.example.demo002.controller;

import com.example.demo002.entities.Bag;
import com.example.demo002.services.BagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    "apple_num": 2,
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
    public Iterable<Bag> getList(Model model, @RequestParam(name="bagsNum",defaultValue="3") Integer bagsNum){
        return bagsService.listAllBags(bagsNum);
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Bag add(@RequestBody Bag bag) {
        bagsService.addBag(bag);

        return bag;
    }
}
