package org.fmiplovdiv.weblanguages.travelagencyapi.controllers;

import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.CreateLocation;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.ResponseLocation;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.UpdateLocation;
import org.fmiplovdiv.weblanguages.travelagencyapi.sevices.LocationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<ResponseLocation> createLocation(@RequestBody CreateLocation createLocation){
        return ResponseEntity.ok(locationService.create(createLocation));
    }

    @DeleteMapping("/{locationId}")
    public ResponseEntity<Boolean> deleteLocation(@PathVariable Long locationId){
        return ResponseEntity.ok(locationService.delete(locationId));
    }

    @GetMapping
    public ResponseEntity<List<ResponseLocation>> getLocations(){
        return ResponseEntity.ok(locationService.getAll());
    }

    @GetMapping("/{locationId}")
    public ResponseEntity<ResponseLocation> getLocation(@PathVariable Long locationId){
        return ResponseEntity.ok(locationService.get(locationId));
    }

    @PutMapping
    public ResponseEntity<ResponseLocation> updateLocation(@RequestBody UpdateLocation updateLocation){
        return ResponseEntity.ok(locationService.update(updateLocation));
    }

}