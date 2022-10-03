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

    public List<Moto> getAll(){
        return motoRepository.getAll();
    }
    public Optional<Moto> getMoto(int id){
        return motoRepository.getMoto(id);
    }

    public Moto save(Moto c){
        if(c.getId()==null){
            return motoRepository.save(c);
        }else{
            Optional<Moto> e = motoRepository.getMoto(c.getId());
            if(e.isPresent()){
                return c;
            }else{
                return motoRepository.save(c);
            }
        }

    }
    public Moto update(Moto c){
        if(c.getId()!=null){
            Optional<Moto> t = motoRepository.getMoto(c.getId());
            if(t.isPresent()) {
                if (c.getName() != null) {
                    t.get().setName(c.getName());
                }
                if(c.getDescription()!=null){
                    t.get().setDescription(c.getDescription());
                }
                motoRepository.save(t.get());
                return t.get();

            }else{
                return c;
            }

        }else{
            return c;

        }
    }
    public boolean delete(int id){
        boolean flag=false;
        Optional<Moto>m= motoRepository.getMoto(id);
        if(m.isPresent()){
            motoRepository.delete(m.get());
            flag=true;
        }

        return flag;
    }

}
