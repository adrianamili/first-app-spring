package com.appexample.FirstApp.api;

import com.appexample.FirstApp.api.DTO.apartamentDTO.ApartamentDTOadd;
import com.appexample.FirstApp.api.DTO.apartamentDTO.ApartamentDTOmodify;
import com.appexample.FirstApp.domain.apartament.Apartament;
import com.appexample.FirstApp.domain.apartament.ApartamentRepo;
import com.appexample.FirstApp.exception.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/apartament")
public class ApartamentController {
    
    final ApartamentRepo apartamentRepo;

    public ApartamentController(ApartamentRepo apartamentRepo) {
        this.apartamentRepo = apartamentRepo;
    }

    @PostMapping("/add")
    Apartament add(@RequestBody ApartamentDTOadd addDto) {
        Apartament addAp = new Apartament();
        addAp.setNumar(addDto.getNumar());
        addAp.setEtaj(addDto.getEtaj());
        addAp.setScaraBloc(addDto.getScaraBloc());
        return apartamentRepo.save(addAp);
    }

    @GetMapping("/apartamente")
    public List<Apartament> getApartament() {
        return apartamentRepo.findAll();
    }

    @GetMapping("/apartamente/{id}")
    Apartament getById(@PathVariable Long id) {
        return apartamentRepo.findById(id).get();
    }

    @PostMapping("/modify/{id}")
    Apartament modify(
            @PathVariable Long id,
            @RequestBody ApartamentDTOmodify modifyDto) throws BadRequestException {
        Apartament apartamentModified = apartamentRepo.findById(id).
                orElseThrow(() -> new BadRequestException("Nu exista apartamentul cu id-ul: " + id));
        apartamentModified.setScaraBloc(modifyDto.getScaraBloc());
        apartamentModified.setEtaj(modifyDto.getEtaj());
        apartamentModified.setNumar(modifyDto.getNumar());
        return apartamentRepo.save(apartamentModified);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete (@PathVariable Long id) {
        Apartament apartamentToBeDeleted = apartamentRepo.findById(id).
                orElseThrow(() -> new BadRequestException("Nu exista apartamentul cu id-ul: " + id));
        apartamentRepo.delete(apartamentToBeDeleted);
        return ResponseEntity.ok("The item has been deleted.");
    }
}
