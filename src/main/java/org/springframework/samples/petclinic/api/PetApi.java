package org.springframework.samples.petclinic.api;

import org.springframework.http.ResponseEntity;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.owner.OwnerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PetApi {
    private final OwnerRepository repository;

    public PetApi(OwnerRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/{id}")

    public ResponseEntity<Owner> getUserInfo(@PathVariable("id") Integer id) {
        // Tìm User trong database bằng username
        Owner user = repository.findById(id);

        // Nếu không tìm thấy, trả về message lỗi 404 Not found

        // Nếu tìm thấy return 200 OK
        return ResponseEntity.ok(user);
    }
}
