package com.example.nt.service;

import java.math.BigInteger;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nt.model.Pet;
import com.example.nt.repository.PetRepository;

@Service
public class PetServiceBean implements PetService {
	
	@Autowired
	private PetRepository petRepository;
	    
	@Override
	public Collection<Pet> findAll() {
		Collection<Pet> pets = petRepository.findAll();
		return pets;
	}

	@Override
	public Pet findOne(Long id) {
		Pet pet = petRepository.findOne(id);
		return pet;
	}

	@Override
	public Pet create(Pet pet) {
		if(pet.getId() != null){
			//Cannot create Pet with specified ID value
			return null;
		}
		Pet savedPet = petRepository.save(pet);
		return savedPet;
	}

	@Override
	public Pet update(Pet pet) {
		Pet petPersisted = findOne(pet.getId());
		if(petPersisted == null){
			//Cannot update Pet that hasn't been persisted
			return null;
		}
		Pet updatedPet = petRepository.save(pet);
		return updatedPet;
	}

	@Override
	public void delete(Long id) {
		petRepository.delete(id);

	}

}
