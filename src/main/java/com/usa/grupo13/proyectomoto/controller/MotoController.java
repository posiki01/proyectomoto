package com.usa.grupo13.proyectomoto.controller;

import com.usa.grupo13.proyectomoto.entities.Moto;
import com.usa.grupo13.proyectomoto.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Motorbike")
@CrossOrigin(origins = "*", methods={RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE,RequestMethod.PUT})
public class MotoController {

    @Autowired
    private MotoService motoService;


    @GetMapping("/all")
    public List<Moto> getAll(){
        return motoService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Moto> getMoto(@PathVariable("id") int motoId) {
        return motoService.getMoto(motoId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Moto save(@RequestBody Moto moto) {
        return motoService.save(moto);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Moto update(@RequestBody Moto moto){
        return motoService.update(moto);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int motoId){
        return motoService.delete(motoId);
    }
}

