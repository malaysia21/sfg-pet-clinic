package aga.spring.sfgpetclinic.model;

import java.util.HashSet;
import java.util.Set;

public class Vet extends Person {

    private Set<Specialty> speciality = new HashSet<>();

    public Set<Specialty> getSpeciality() {
        return speciality;
    }

    public void setSpeciality(Set<Specialty> speciality) {
        this.speciality = speciality;
    }
}
