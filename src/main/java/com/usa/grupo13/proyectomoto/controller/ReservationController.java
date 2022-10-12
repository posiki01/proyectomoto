package com.usa.grupo13.proyectomoto.controller;

import com.usa.grupo13.proyectomoto.entities.Reservation;
import com.usa.grupo13.proyectomoto.entities.custome.CountClient;
import com.usa.grupo13.proyectomoto.entities.custome.StatusAmount;
import com.usa.grupo13.proyectomoto.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {
    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    @GetMapping("/{id}")
    public Optional<Reservation> getReservation(@PathVariable("id") int reservationId) {
        return reservationService.getReservation(reservationId);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation save(@RequestBody Reservation reservation){
        return reservationService.save(reservation);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation update(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int reservationId){
        return reservationService.delete(reservationId);
    }

    @GetMapping("/report-status")
    public StatusAmount getReservationClientStatus(){
        return reservationService.getStatusReport();
    }

    @GetMapping("/report-clients")
    public List<CountClient> getCountClient(){
        return reservationService.getTopClients();
    }

    @GetMapping("report-dates/{dateOne}/{dateTwo}")
    public List<Reservation> getDatesReport(@PathVariable("dateOne")String d1,@PathVariable("dateTwo")String d2){
        return reservationService.getReservationPeriod(d1,d2);


    }

}
