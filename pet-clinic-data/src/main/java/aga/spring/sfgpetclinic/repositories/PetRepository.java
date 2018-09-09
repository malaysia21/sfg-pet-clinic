package aga.spring.sfgpetclinic.repositories;

import aga.spring.sfgpetclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;

public interface PetRepository extends CrudRepository<Pet, Long> {
}
