package aga.spring.sfgpetclinic.services.springdatajpa;

import aga.spring.sfgpetclinic.model.Owner;
import aga.spring.sfgpetclinic.repositories.OwnerRepository;
import aga.spring.sfgpetclinic.repositories.PetRepository;
import aga.spring.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {
    public static final String LAST_NAME = "Smith";
    @Mock
    OwnerRepository ownerRepository;
    @Mock
    PetRepository petRepository;
    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService ownerService;

    Owner returnedOwner;

    @BeforeEach
    void setUp() {
        returnedOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnedOwnerSet = new HashSet<>();
        returnedOwnerSet.add(Owner.builder().id(1L).lastName(LAST_NAME).build());
        returnedOwnerSet.add(Owner.builder().id(2L).lastName(LAST_NAME).build());
        when(ownerRepository.findAll()).thenReturn(returnedOwnerSet);
        Set<Owner> all = ownerService.findAll();
        assertEquals(2, all.size());

    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnedOwner));
        Owner ownerById = ownerService.findById(1L);
        assertNotNull(ownerById);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());
        Owner ownerById = ownerService.findById(1L);
        assertNull(ownerById);
    }


    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).lastName(LAST_NAME).build();
        when(ownerRepository.save(any())).thenReturn(returnedOwner);
        Owner owner = ownerService.save(ownerToSave);
        assertNotNull(owner);

    }

    @Test
    void delete() {
        ownerService.delete(returnedOwner);
        verify(ownerRepository).delete(any());
    }

    @Test
    void deleteById() {
        ownerService.deleteById(1L);
        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnedOwner);
        Owner smith = ownerService.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME, smith.getLastName());
        verify(ownerRepository).findByLastName(any());
    }
}