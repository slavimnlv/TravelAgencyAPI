package org.fmiplovdiv.weblanguages.travelagencyapi.controllers;

import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.CreateHoliday;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.ResponseHoliday;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.UpdateHoliday;
import org.fmiplovdiv.weblanguages.travelagencyapi.sevices.HolidayService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

    private final HolidayService holidayService;

    public HolidayController(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    @PostMapping
    public ResponseEntity<ResponseHoliday> createHoliday(@RequestBody CreateHoliday createHoliday){
        return ResponseEntity.ok(holidayService.create(createHoliday));
    }

    @DeleteMapping("/{holidayId}")
    public ResponseEntity<Boolean> deleteHoliday(@PathVariable Long holidayId){
        return ResponseEntity.ok(holidayService.delete(holidayId));
    }

    @GetMapping
    public ResponseEntity<List<ResponseHoliday>> getHolidays(@RequestParam(required = false) String location, @RequestParam(required = false) LocalDate startDate, @RequestParam(required = false) Integer duration){
        return ResponseEntity.ok(holidayService.getAll(location, startDate, duration));
    }

    @GetMapping("/{holidayId}")
    public ResponseEntity<ResponseHoliday> getHoliday(@PathVariable Long holidayId){
        return ResponseEntity.ok(holidayService.get(holidayId));
    }

    @PutMapping
    public ResponseEntity<ResponseHoliday> updateHoliday(@RequestBody UpdateHoliday updateHoliday){
        return ResponseEntity.ok(holidayService.update(updateHoliday));
    }

}
