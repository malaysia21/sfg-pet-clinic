package aga.spring.sfgpetclinic.bootstrap;

import aga.spring.sfgpetclinic.model.Owner;
import aga.spring.sfgpetclinic.model.PetType;
import aga.spring.sfgpetclinic.model.Vet;
import aga.spring.sfgpetclinic.services.OwnerService;
import aga.spring.sfgpetclinic.services.PetTypeService;
import aga.spring.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private  final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... strings) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Owner owner1 = new Owner();
        owner1.setFirstName("Agnieszka");
        owner1.setLastName("Kowalska");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anna");
        owner2.setLastName("Nowak");

        ownerService.save(owner2);

        System.out.println("Loaded Owners..");

        Vet vet1 = new Vet();
        vet1.setFirstName("Tommy");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Sam");
        vet2.setLastName("Smith");

        vetService.save(vet2);

        System.out.println("Loaded Vets..");
    }
}
