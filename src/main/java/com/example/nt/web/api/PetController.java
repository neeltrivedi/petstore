package com.example.nt.web.api;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.example.nt.model.Pet;
import com.example.nt.service.PetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetController {

	@Autowired
   private PetService petService;

    @RequestMapping(
            value = "/api/pets",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Pet>> getPets() {

        Collection<Pet> pets = petService.findAll();

        return new ResponseEntity<Collection<Pet>>(pets,
                HttpStatus.OK);
    }
    
    @RequestMapping(
            value = "/api/pets/{id}",
            method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pet> getPet(
            @PathVariable("id") Long id) {

        Pet pet = petService.findOne(id);
        if (pet == null) {
            return new ResponseEntity<Pet>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<Pet>(pet, HttpStatus.OK);
    }
    
    
    @RequestMapping(
            value = "/api/pets",
            method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pet> createPet(
            @RequestBody Pet pet) {

        Pet savedPet = petService.create(pet);

        return new ResponseEntity<Pet>(savedPet, HttpStatus.CREATED);
    }

    @RequestMapping(
            value = "/api/pets/{id}",
            method = RequestMethod.PUT,
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pet> updateGreeting(
            @RequestBody Pet pet) {

        Pet updatedPet = petService.update(pet);
        if (updatedPet == null) {
            return new ResponseEntity<Pet>(
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return new ResponseEntity<Pet>(updatedPet, HttpStatus.OK);
    }
    
    @RequestMapping(
            value = "/api/pets/{id}",
            method = RequestMethod.DELETE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Pet> deleteGreeting(
            @PathVariable("id") Long id) {

    	petService.delete(id);

        return new ResponseEntity<Pet>(HttpStatus.NO_CONTENT);
    }
}