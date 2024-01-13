package org.fmiplovdiv.weblanguages.travelagencyapi.sevices;

import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.*;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationService {

    ResponseReservation create(CreateReservation reservation);
    Boolean delete(Long id);
    List<ResponseReservation> getAll();
    ResponseReservation get(Long id);
    ResponseReservation update(UpdateReservation reservation);


}
