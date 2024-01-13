package org.fmiplovdiv.weblanguages.travelagencyapi.controllers;

import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.CreateReservation;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.ResponseReservation;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.UpdateReservation;
import org.fmiplovdiv.weblanguages.travelagencyapi.sevices.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @PostMapping
    public ResponseEntity<ResponseReservation> createReservation(@RequestBody CreateReservation createReservation){
        return ResponseEntity.ok(reservationService.create(createReservation));
    }

    @DeleteMapping("/{reservationId}")
    public ResponseEntity<Boolean> deleteReservation(@PathVariable Long reservationId){
        return ResponseEntity.ok(reservationService.delete(reservationId));
    }

    @GetMapping
    public ResponseEntity<List<ResponseReservation>> getReservations(){
        return ResponseEntity.ok(reservationService.getAll());
    }

    @GetMapping("/{reservationId}")
    public ResponseEntity<ResponseReservation> getReservation(@PathVariable Long reservationId){
        return ResponseEntity.ok(reservationService.get(reservationId));
    }

    @PutMapping
    public ResponseEntity<ResponseReservation> updateReservation(@RequestBody UpdateReservation updateReservation){
        return ResponseEntity.ok(reservationService.update(updateReservation));
    }

}
