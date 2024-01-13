package org.fmiplovdiv.weblanguages.travelagencyapi.sevices;

import jakarta.persistence.EntityNotFoundException;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.CreateHoliday;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.ResponseHoliday;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.ResponseLocation;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.UpdateHoliday;
import org.fmiplovdiv.weblanguages.travelagencyapi.models.Holiday;
import org.fmiplovdiv.weblanguages.travelagencyapi.models.Location;
import org.fmiplovdiv.weblanguages.travelagencyapi.repos.HolidayRepository;
import org.fmiplovdiv.weblanguages.travelagencyapi.repos.LocationRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class HolidayServiceImpl implements HolidayService{

    private final HolidayRepository holidayRepository;
    private final LocationRepository locationRepository;

    public HolidayServiceImpl(HolidayRepository holidayRepository, LocationRepository locationRepository) {
        this.holidayRepository = holidayRepository;
        this.locationRepository = locationRepository;
    }

    @Override
    public ResponseHoliday create(CreateHoliday createHoliday) {

        var location = locationRepository.findById(createHoliday.getLocation())
                .orElseThrow(() -> new EntityNotFoundException("location not found"));

        var holiday = holidayRepository.save(new Holiday(createHoliday.getTitle(),createHoliday.getStartDate(),
                createHoliday.getDuration(), createHoliday.getPrice(), createHoliday.getFreeSlots(), location));

        return new ResponseHoliday(holiday);

    }

    @Override
    public Boolean delete(Long id) {
        if(holidayRepository.existsById(id)){
            holidayRepository.deleteById(id);
            return true;
        }
        throw new EntityNotFoundException("holiday not found");
    }

    @Override
    public List<ResponseHoliday> getAll(String location, LocalDate startDate, Integer duration) {

        var holidayExample = new Holiday();
        holidayExample.setLocation(locationRepository.findByCityOrCountry(location, location).orElse(null));
        holidayExample.setStartDate(startDate);
        holidayExample.setDuration(duration);

        List<Holiday> holidays = holidayRepository.findAll(Example.of(holidayExample));

        return holidays.stream()
                .map(ResponseHoliday::new)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseHoliday get(Long id) {
        return new ResponseHoliday(holidayRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("holiday not found")));
    }

    @Override
    public ResponseHoliday update(UpdateHoliday updateHoliday) {

        var holiday = holidayRepository.findById(updateHoliday.getId())
                .orElseThrow(() -> new EntityNotFoundException("holiday not found"));

        var location = locationRepository.findById(updateHoliday.getLocation())
                .orElseThrow(() -> new EntityNotFoundException("location not found"));

        holiday.setDuration(updateHoliday.getDuration());
        holiday.setFreeSlots(updateHoliday.getFreeSlots());
        holiday.setLocation(location);
        holiday.setPrice(updateHoliday.getPrice());
        holiday.setTitle(updateHoliday.getTitle());
        holiday.setStartDate(updateHoliday.getStartDate());

        return new ResponseHoliday(holidayRepository.save(holiday));
    }
}
