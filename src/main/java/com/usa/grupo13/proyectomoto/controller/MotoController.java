package com.usa.grupo13.proyectomoto.controller;


import com.usa.grupo13.proyectomoto.entities.Moto;
import com.usa.grupo13.proyectomoto.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Motorbike")
public class MotoController {


    @Autowired
    private MotoService MotoService;


    @GetMapping("/all")
    public List<Moto> getAll(){
        return MotoService.getAll();
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Moto save(@RequestBody Moto c) {
        return MotoService.save(c);
    }
}

