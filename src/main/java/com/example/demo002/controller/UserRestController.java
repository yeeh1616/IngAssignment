package com.example.demo002.controller;

import com.example.demo002.Exception.ApiResponse;
import com.example.demo002.entities.Bag;
import com.example.demo002.services.BagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
public class UserRestController {
    @Autowired
    private BagsService bagsService;

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public ResponseEntity<Iterable<Bag>> getList(@RequestParam(name = "bagsNum", defaultValue = "3") Integer bagsNum) {
        //JSON parser object to parse read file
        JSONParser jsonParser = new JSONParser();
        JSONArray userList = null;

        try (FileReader reader = new FileReader("employees.json")){
            //Read JSON file
            userList = (JSONArray) jsonParser.parse(reader);;
            System.out.println(userList);

            //Iterate over employee array
            userList.forEach( emp -> parseEmployeeObject( (JSONObject) emp ) );

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok(bagsService.listAllBags(userList));
    }

    private static void parseEmployeeObject(JSONObject employee)
    {
        //Get employee object within list
        JSONObject employeeObject = (JSONObject) employee.get("employee");

        //Get employee first name
        String firstName = (String) employeeObject.get("firstName");
        System.out.println(firstName);

        //Get employee last name
        String lastName = (String) employeeObject.get("lastName");
        System.out.println(lastName);

        //Get employee website name
        String website = (String) employeeObject.get("website");
        System.out.println(website);
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
