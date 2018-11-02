package aga.spring.sfgpetclinic.services.map;

import aga.spring.sfgpetclinic.model.Owner;
import aga.spring.sfgpetclinic.model.Pet;
import aga.spring.sfgpetclinic.services.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    final Long id = 1L;
    final String lastName = "Smith";


    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().id(id).lastName(lastName).build());

    }

    @Test
    void findAll() {
        Set<Owner> mapServiceAll = ownerMapService.findAll();
        assertEquals(1, mapServiceAll.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(id);
        assertNotNull(owner);
    }

    @Test
    void saveExistingId() {
        Long id2 = 2l;
        Owner owner2 = Owner.builder().id(id2).build();
        Owner savedOwner = ownerMapService.save(owner2);
        assertEquals(id2, savedOwner.getId());
        assertEquals(2, ownerMapService.findAll().size());
    }

    @Test
    void saveNoId() {
        Owner savedOwner = ownerMapService.save(Owner.builder().build());
        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(id));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(id);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner ownerByLastName = ownerMapService.findByLastName(lastName);
        assertNotNull(ownerByLastName);

    }

    @Test
    void findByLastNameNotFound() {
        Owner ownerByLastName = ownerMapService.findByLastName("foo");
        assertNull(ownerByLastName);

    }
}