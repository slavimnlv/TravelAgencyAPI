package org.fmiplovdiv.weblanguages.travelagencyapi.repos;

import org.fmiplovdiv.weblanguages.travelagencyapi.models.Location;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface LocationRepository extends ListCrudRepository<Location, Long> {

    Optional<Location> findByCityOrCountry(String city, String country);


}
