package com.usa.grupo13.proyectomoto.repository;

import com.usa.grupo13.proyectomoto.entities.Moto;
import com.usa.grupo13.proyectomoto.repository.crudRepository.MotoCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MotoRepository {

    @Autowired
    private MotoCrudRepository motoCrudRepository;

    public List<Moto> getAll(){
        return(List<Moto>) motoCrudRepository.findAll();
    }

    public Optional<Moto> getMoto(int id){
        return motoCrudRepository.findById(id);
    }
    public Moto save(Moto c){
       return motoCrudRepository.save(c);
    }

    public void delete(Moto c){
        motoCrudRepository.delete(c);
    }
}
