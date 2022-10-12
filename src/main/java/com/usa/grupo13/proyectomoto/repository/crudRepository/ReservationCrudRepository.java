package com.usa.grupo13.proyectomoto.repository.crudRepository;

import com.usa.grupo13.proyectomoto.entities.Reservation;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Date;
import java.util.List;

public interface ReservationCrudRepository extends CrudRepository<Reservation,Integer> {

    @Query("select c.client, COUNT(c.client) FROM Reservation AS c group by c.client order by COUNT(c.client) desc")
    public List<Object[]> countTotalReservationByClient();

    public List<Reservation>findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    public List<Reservation>findAllByStatus(String status);


}
