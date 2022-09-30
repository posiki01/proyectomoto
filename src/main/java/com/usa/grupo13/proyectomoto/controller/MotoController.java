package com.usa.grupo13.proyectomoto.controller;


import com.usa.grupo13.proyectomoto.entities.Moto;
import com.usa.grupo13.proyectomoto.service.MotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Motorbike")
public class MotoController {


    @Autowired
    private MotoService motoService;


    @GetMapping("/all")
    public List<Moto> getAll(){
        return motoService.getAll();
    }
    @PostMapping("/save")
    public Moto save(@RequestBody Moto m){
        return motoService.save(m);
    }
}
