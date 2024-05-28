package com.appexample.FirstApp.api;


import com.appexample.FirstApp.api.DTO.blocDTO.BlocDTOadd;
import com.appexample.FirstApp.api.DTO.blocDTO.BlocDTOmodify;
import com.appexample.FirstApp.domain.bloc.Bloc;
import com.appexample.FirstApp.domain.bloc.BlocRepo;
import com.appexample.FirstApp.exception.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/bloc")
public class BlocController {
    
    final BlocRepo blocRepo;

    public BlocController(BlocRepo blocRepo) {
        this.blocRepo = blocRepo;
    }

    @PostMapping("/add")
    Bloc add(@RequestBody BlocDTOadd addDto) {
        Bloc addBloc = new Bloc();
        addBloc.setNumar(addDto.getNumar());
        addBloc.setNume(addDto.getNume());
        addBloc.setScara(addDto.getScara());
        addBloc.setNumeStrada(addDto.getNumeStrada());
        return blocRepo.save(addBloc);
    }

    @GetMapping("/blocuri")
    public List<Bloc> getBlocuri() {
        return blocRepo.findAll();
    }

    @GetMapping("/blocuri/{id}")
    Bloc getById(@PathVariable Long id) {
        return blocRepo.findById(id).get();
    }

    @PostMapping("/modify/{id}")
    Bloc modify(
            @PathVariable Long id,
            @RequestBody BlocDTOmodify modifyDto) throws BadRequestException {
        Bloc blocModified = blocRepo.findById(id).
                orElseThrow(() -> new BadRequestException("Nu exista blocul cu id-ul: " + id));
        blocModified.setNumeStrada(modifyDto.getNumeStrada());
        blocModified.setNume(modifyDto.getNume());
        blocModified.setNumar(modifyDto.getNumar());
        blocModified.setScara(modifyDto.getScara());
        return blocRepo.save(blocModified);
    }

    @DeleteMapping("/delete/{id}")
    ResponseEntity<String> delete(@PathVariable Long id) {
        Bloc blocToBeDeleted = blocRepo.findById(id).
                orElseThrow(() -> new BadRequestException("Nu exista blocul cu id-ul: " + id));
        blocRepo.delete(blocToBeDeleted);
        return ResponseEntity.ok("The item has been deleted.");
    }
}


