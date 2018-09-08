package aga.spring.sfgpetclinic.services;


import aga.spring.sfgpetclinic.model.Vet;

import java.util.Set;

public interface VetService {

    Vet findById (Long id);

    Vet save (Vet pet);

    Set<Vet> findAll();
}
