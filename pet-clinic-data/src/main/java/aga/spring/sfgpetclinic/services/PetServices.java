package aga.spring.sfgpetclinic.services;

import aga.spring.sfgpetclinic.model.Pet;

import java.util.Set;

public interface PetServices {

    Pet findById (Long id);

    Pet save (Pet pet);

    Set<Pet> findAll();
}
