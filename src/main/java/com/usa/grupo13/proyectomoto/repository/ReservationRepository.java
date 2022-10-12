package com.usa.grupo13.proyectomoto.repository;





import com.usa.grupo13.proyectomoto.entities.Client;
import com.usa.grupo13.proyectomoto.entities.Reservation;
import com.usa.grupo13.proyectomoto.entities.custome.CountClient;
import com.usa.grupo13.proyectomoto.repository.crudRepository.ReservationCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Repository
public class ReservationRepository {

    @Autowired
    private ReservationCrudRepository reservationCrudRepository;

    public List<Reservation> getAll(){
        return (List<Reservation>) reservationCrudRepository.findAll();
    }
    public Optional<Reservation>  getReservation(int id){
        return reservationCrudRepository.findById(id);
    }
    public Reservation save(Reservation p){
        return reservationCrudRepository.save(p);
    }
    public void delete(Reservation p){
        reservationCrudRepository.delete(p);
    }

    public  List<Reservation> getReservationsByStatus(String status){
        return reservationCrudRepository.findAllByStatus(status);

    }

    public List<Reservation> getReservationPeriod(Date dateOne, Date dateTwo){
        return reservationCrudRepository.findAllByStartDateAfterAndStartDateBefore(dateOne,dateTwo);


    }

    public List<CountClient> getTopClients(){
        List<CountClient> res=new ArrayList<>();

        List<Object[]> report = reservationCrudRepository.countTotalReservationByClient();
        for(int i=0;i<report.size();i++) {
            /*Client cli=(CLient)report.get(i)[0];
            Integer cantidad=(Integer) report.get(i)[1];
            CountClient cl=new CountClient(cantidad,cli);
            res.add(cl)
        }   */
            res.add(new CountClient((Long) report.get(i)[1], (Client)report.get(i)[0]));
        }

        return res;

    }


}
