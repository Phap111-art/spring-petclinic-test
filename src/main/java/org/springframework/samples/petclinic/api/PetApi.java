package org.springframework.samples.petclinic.api;

import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.samples.petclinic.owner.PetRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetApi {
    private final PetRepository  repository ;

    public PetApi(PetRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/api/pet/{id}")

    public ResponseEntity<Pet> getUserInfo(@PathVariable("id") int id) {
        // find id owners
        Pet pet = repository.findById(id);

        //if the owner id is found return 200 OK
        return ResponseEntity.ok(pet);
    }
}
