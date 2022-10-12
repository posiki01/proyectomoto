package com.usa.grupo13.proyectomoto.repository.crudRepository;

import com.usa.grupo13.proyectomoto.entities.Moto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.xml.crypto.Data;
import java.util.Date;
import java.util.List;

public interface MotoCrudRepository extends CrudRepository<Moto,Integer> {

}
