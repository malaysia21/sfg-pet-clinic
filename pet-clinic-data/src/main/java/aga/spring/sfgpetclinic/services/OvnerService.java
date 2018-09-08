package aga.spring.sfgpetclinic.services;

import aga.spring.sfgpetclinic.model.Owner;

import java.util.Set;

public interface OvnerService {

    Owner findByLastName (Long id);

    Owner findById (Long id);

    Owner save (Owner owner);

    Set<Owner> findAll();
}
