package org.fmiplovdiv.weblanguages.travelagencyapi.repos;

import org.fmiplovdiv.weblanguages.travelagencyapi.models.Holiday;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.ListCrudRepository;

import java.util.List;

public interface HolidayRepository extends ListCrudRepository<Holiday, Long> {

    List<Holiday> findAll(Example<Holiday> example);

}
