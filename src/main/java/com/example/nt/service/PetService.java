package com.example.nt.service;

import java.util.Collection;

import com.example.nt.model.Pet;

public interface PetService {

    Collection<Pet> findAll();

    Pet findOne(Long id);

    Pet create(Pet pet);

    Pet update(Pet pet);

    void delete(Long id);

}