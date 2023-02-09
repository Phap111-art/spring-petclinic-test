package org.springframework.samples.petclinic.pet;

import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.owner.Pet;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetApi {
    private final PetService petService ;

    public PetApi(PetService petService) {
        this.petService = petService;
    }


    @GetMapping("/api/pet/{id}")

    public ResponseEntity<Pet> getPetById(@PathVariable("id") int id) {
        // find id pet
        Pet pet = petService.findById(id);

        //if the owner id is found return 200 OK
        return ResponseEntity.ok(pet);
    }
}
