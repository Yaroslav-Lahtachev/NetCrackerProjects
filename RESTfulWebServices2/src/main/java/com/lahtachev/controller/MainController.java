package com.lahtachev.controller;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.lahtachev.entity.Buyer;
import com.lahtachev.service.IBuyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MainController {
    @Autowired
    IBuyerService iBuyerService;

    @GetMapping(value = "/buyer", produces = "application/json")
    @Transactional
    public ResponseEntity<List<Buyer>> getAllBuyers() {
        return new ResponseEntity<List<Buyer>>(iBuyerService.findAllBuyer(), HttpStatus.OK);
    }

    @GetMapping(value = "/buyer/{id}", produces = "application/json")
    @Transactional
    public ResponseEntity getBuyerById(@PathVariable("id") int idBuyer) {
        Buyer buyer = iBuyerService.findBuyerById(idBuyer);
        if (buyer == null)
            return new ResponseEntity("wrong id", HttpStatus.NOT_FOUND);
        return new ResponseEntity(buyer, HttpStatus.OK);
    }

    @PostMapping(value = "/buyer")
    @Transactional
    public ResponseEntity<Status> addBuyer(@RequestBody Buyer buyer) {
        iBuyerService.saveBuyer(buyer);
        return new ResponseEntity<Status>(new Status("Successfully created"), HttpStatus.OK);
    }

    @DeleteMapping(value = "/buyer")
    @Transactional
    public ResponseEntity<Status> deleteBuyersAll() {
        iBuyerService.deleteBuyersAll();
        return new ResponseEntity<Status>(new Status("Successfully deleted"), HttpStatus.I_AM_A_TEAPOT);
    }

    @DeleteMapping(value = "/buyer/{id}")
    @Transactional
    public ResponseEntity<Status> deleteBuyerById(@PathVariable("id") int id) {
        if (iBuyerService.deleteBuyerById(id))
            return new ResponseEntity<Status>(new Status("Successfully deleted idBuyer = " + id), HttpStatus.OK);
        else return new ResponseEntity<Status>(new Status("Nothing to delete"),HttpStatus.NOT_FOUND);
    }
}
