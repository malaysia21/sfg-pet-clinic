package aga.spring.sfgpetclinic.bootstrap;

import aga.spring.sfgpetclinic.model.Owner;
import aga.spring.sfgpetclinic.model.Vet;
import aga.spring.sfgpetclinic.services.OwnerService;
import aga.spring.sfgpetclinic.services.VetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private  final OwnerService ownerService;
    private final VetService vetService;

    @Autowired
    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... strings) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Agnieszka");
        owner1.setLastName("Kowalska");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Anna");
        owner2.setLastName("Nowak");

        ownerService.save(owner2);

        System.out.println("Loaded Owners..");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Tommy");
        vet1.setLastName("Axe");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Sam");
        vet2.setLastName("Smith");

        vetService.save(vet2);

        System.out.println("Loaded Vets..");
    }
}
