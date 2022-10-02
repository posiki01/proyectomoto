package com.usa.grupo13.proyectomoto.service;


import com.usa.grupo13.proyectomoto.entities.Moto;
import com.usa.grupo13.proyectomoto.repository.MotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotoService {

    @Autowired
    private MotoRepository motoRepository;

    public List<Moto> getAll(){return motoRepository.getAll();}
    public Optional<Moto> getMoto(int id){
        return motoRepository.getMoto(id);
    }

    public Moto save(Moto m){
        if(m.getId()==null){
            return motoRepository.save(m);
        }else{
            Optional<Moto> e =motoRepository.getMoto(m.getId());
            if(e.isPresent()){
                return m;
            }else{
                return motoRepository.save(m);
            }
        }

    }
    public Moto update(Moto m){
        if(m.getId()!=null){
            Optional<Moto> t =motoRepository.getMoto(m.getId());
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
                motoRepository.save(t.get());
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
        Optional<Moto>m=motoRepository.getMoto(id);
        if(m.isPresent()){
            motoRepository.delete(m.get());
            flag=true;
        }

        return flag;
    }

}
