package com.example.demo002.controller;

import com.example.demo002.entities.Bag;
import com.example.demo002.services.BagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class BagsRestController {
    @Autowired
    private BagsService bagsService;

    @GetMapping("/bags")
    public Iterable<Bag> bagsRest(Model model, @RequestParam(name="bagsNum",defaultValue="3") Integer bagsNum){
        return bagsService.listAllBags(bagsNum);
    }

    @PostMapping("/add")
    public Bag addRest(@RequestBody Bag bag) {
        bagsService.addBag(bag);

        return bag;
    }

//    @GetMapping("/bags")
//    public String bags(Model model){
//        model.addAttribute("bags", bagsService.listAllBags());
//        model.addAttribute("bag", new Bag());
//
//        return "bags";
//    }
//
//    @PostMapping("/add")
//    public String add(@ModelAttribute("bag") Bag bag) {
//        bagsService.addBag(bag);
//
//        return "redirect:/bags";
//    }
}
