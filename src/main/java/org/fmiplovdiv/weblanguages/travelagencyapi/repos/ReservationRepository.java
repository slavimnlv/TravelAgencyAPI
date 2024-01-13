package org.fmiplovdiv.weblanguages.travelagencyapi.repos;

import org.fmiplovdiv.weblanguages.travelagencyapi.models.Reservation;
import org.springframework.data.repository.ListCrudRepository;

public interface ReservationRepository extends ListCrudRepository<Reservation, Long> {

}
