package com.usa.grupo13.proyectomoto.service;


import com.usa.grupo13.proyectomoto.entities.Motorbike;
import com.usa.grupo13.proyectomoto.repository.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class MotorbikeService {

    @Autowired
    private MotorbikeRepository motorbikeRepository;

    public List<Motorbike> getAll()
    {return motorbikeRepository.getAll();}
    public Optional<Motorbike> getMotorbike(int id){
        return motorbikeRepository.getMotorbike(id);
    }

    public Motorbike save(Motorbike m){
        if(m.getId()==null){
            return motorbikeRepository.save(m);
        }else{
            Optional<Motorbike> e = motorbikeRepository.getMotorbike(m.getId());
            if(e.isPresent()){
                return m;
            }else{
                return motorbikeRepository.save(m);
            }
        }

    }
    public Motorbike update(Motorbike m){
        if(m.getId()!=null){
            Optional<Motorbike> t = motorbikeRepository.getMotorbike(m.getId());
            if(t.isPresent()) {
                if (m.getName() != null) {
                    t.get().setName(m.getName());
                }
                if (m.getBrand() != null){
                    t.get().setBrand(m.getBrand());
                }
                if(m.getCategory()!=null) {
                    t.get().setCategory(m.getCategory());
                }
                if(m.getYear()!=null){
                    t.get().setYear(m.getYear());
                }
                if(m.getDescription()!=null){
                    t.get().setDescription(m.getDescription());
                }
                motorbikeRepository.save(t.get());
                return t.get();

            }else{
                return m;
            }

        }else{
            return m;

        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Motorbike>m= motorbikeRepository.getMotorbike(id);
        if(m.isPresent()){
            motorbikeRepository.delete(m.get());
            flag=true;
        }

        return flag;
    }

}
