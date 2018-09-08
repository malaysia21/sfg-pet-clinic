package aga.spring.sfgpetclinic.services;

import aga.spring.sfgpetclinic.model.Owner;


public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName (Long id);
}
