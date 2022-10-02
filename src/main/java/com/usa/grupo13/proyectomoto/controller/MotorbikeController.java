package com.usa.grupo13.proyectomoto.controller;


import com.usa.grupo13.proyectomoto.entities.Motorbike;
import com.usa.grupo13.proyectomoto.service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Motorbike")
public class MotorbikeController {


    @Autowired
    private MotorbikeService motorbikeService;


    @GetMapping("/all")
    public List<Motorbike> getAll(){
        return motorbikeService.getAll();
    }
    @PostMapping("/save")
    public Motorbike save(@RequestBody Motorbike m){
        return motorbikeService.save(m);
    }
}
