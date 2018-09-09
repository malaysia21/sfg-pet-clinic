package aga.spring.sfgpetclinic.bootstrap;

import aga.spring.sfgpetclinic.model.*;
import aga.spring.sfgpetclinic.services.OwnerService;
import aga.spring.sfgpetclinic.services.PetTypeService;
import aga.spring.sfgpetclinic.services.SpecialtyService;
import aga.spring.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private  final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtiesService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtiesService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtiesService = specialtiesService;
    }

    @Override
    public void run(String... strings) throws Exception {
        int count = petTypeService.findAll().size();
        if(count == 0){
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Agnieszka");
        owner1.setLastName("Kowalska");
        owner1.setAddress("123 Brickerel");
        owner1.setCity("Miami");
        owner1.setCity("123456789");
        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anna");
        owner2.setLastName("Nowak");
        owner2.setAddress("126 Brickerel");
        owner2.setCity("New York");
        owner2.setCity("123456789");
        ownerService.save(owner2);

        Pet pet1 = new Pet();
        pet1.setPetType(savedDogPetType);
        pet1.setBirthDate(LocalDate.now());
        pet1.setName("Rosco");
        pet1.setOwner(owner1);
        owner1.getPets().add(pet1);

        Pet pet2 = new Pet();
        pet2.setPetType(savedCatPetType);
        pet2.setBirthDate(LocalDate.now());
        pet2.setName("Fiona");
        pet2.setOwner(owner2);
        owner2.getPets().add(pet2);


        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtiesService.save(radiology);

        Specialty surgery = new Specialty();
        surgery.setDescription("Surgery");
        Specialty savedSurgery = specialtiesService.save(surgery);

        Specialty dentistry = new Specialty();
        dentistry.setDescription("Dentistry");
        Specialty savedDentistry = specialtiesService.save(dentistry);

        Vet vet1 = new Vet();
        vet1.setFirstName("Tommy");
        vet1.setLastName("Axe");
        vet1.getSpeciality().add(savedRadiology);
        vet1.getSpeciality().add(savedSurgery);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Smith");
        vet2.getSpeciality().add(savedDentistry);
        vetService.save(vet2);

        System.out.println("Loaded Owners..");
        System.out.println("Loaded Vets..");
    }
}
