package org.fmiplovdiv.weblanguages.travelagencyapi.sevices;

import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.CreateHoliday;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.ResponseHoliday;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.UpdateHoliday;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface HolidayService {

    ResponseHoliday create(CreateHoliday holiday);
    Boolean delete(Long id);
    List<ResponseHoliday> getAll(String location, LocalDate startDate, Integer duration);
    ResponseHoliday get(Long id);
    ResponseHoliday update(UpdateHoliday holiday);


}
