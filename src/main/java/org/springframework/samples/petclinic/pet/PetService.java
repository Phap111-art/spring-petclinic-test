package org.springframework.samples.petclinic.pet;

import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PetService {
    private final PetRepository repository;

    public PetService(PetRepository repository) {
        this.repository = repository;
    }

    public Pet findById(int id) {
        Pet pet = repository.findById(id);
        if (pet == null) {
            throw new IllegalArgumentException("Pet id not found!");
        }
        return pet;
    }
}
