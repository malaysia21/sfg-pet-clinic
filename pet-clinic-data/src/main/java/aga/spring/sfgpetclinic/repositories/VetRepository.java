package aga.spring.sfgpetclinic.repositories;


import aga.spring.sfgpetclinic.model.Vet;
import org.springframework.data.repository.CrudRepository;

public interface VetRepository extends CrudRepository<Vet, Long> {
}
