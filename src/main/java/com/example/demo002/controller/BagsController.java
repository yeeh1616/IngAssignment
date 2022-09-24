package com.example.demo002.controller;

import com.example.demo002.entities.Bag;
import com.example.demo002.services.BagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.*;

@Controller
public class BagsController {
    @Autowired
    private BagsService bagsService;

    @GetMapping("/bags")
    public String bags(Model model){
        Iterable<Bag> bags = bagsService.listAllBags();
        Bag bag = new Bag();
        model.addAttribute("bags", bags);
        model.addAttribute("bag", bag);
        return "bags";
    }

    @PostMapping("/add")
    public String submitForm(@ModelAttribute("user") Bag bag) {
        bagsService.addBag(bag);
        System.out.println(bag);
        return "redirect:/bags";
    }
}
