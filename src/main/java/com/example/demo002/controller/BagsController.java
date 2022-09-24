package com.example.demo002.controller;

import com.example.demo002.entities.Bag;
import com.example.demo002.services.BagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class BagsController {
    @Autowired
    private BagsService bagsService;

    @GetMapping("/bagsui")
    public String bags(Model model){
        model.addAttribute("bags", bagsService.listAllBags());
        model.addAttribute("bag", new Bag());

        return "bags";
    }

    @PostMapping("/addui")
    public String add(@ModelAttribute("bag") Bag bag) {
        bagsService.addBag(bag);

        return "redirect:/bags";
    }
}
