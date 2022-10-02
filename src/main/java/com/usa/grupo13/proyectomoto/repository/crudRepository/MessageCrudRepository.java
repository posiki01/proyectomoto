package com.usa.grupo13.proyectomoto.repository.crudRepository;


import com.usa.grupo13.proyectomoto.entities.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageCrudRepository extends CrudRepository<Message,Integer> {
}

