package org.fmiplovdiv.weblanguages.travelagencyapi.sevices;

import jakarta.persistence.EntityNotFoundException;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.CreateLocation;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.ResponseLocation;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.UpdateLocation;
import org.fmiplovdiv.weblanguages.travelagencyapi.models.Location;
import org.fmiplovdiv.weblanguages.travelagencyapi.repos.LocationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {
    private final LocationRepository locationRepository;

    public LocationServiceImpl(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public ResponseLocation create(CreateLocation createLocation) {

        var location = locationRepository.save(new Location(createLocation.getStreet(), createLocation.getNumber(),
                createLocation.getCity(), createLocation.getCountry(), createLocation.getImageUrl()));

        return new ResponseLocation(location);

    }

    @Override
    public Boolean delete(Long id) {

        if(locationRepository.existsById(id)){
            locationRepository.deleteById(id);
            return true;
        }

        throw new EntityNotFoundException("location not found");

    }

    @Override
    public List<ResponseLocation> getAll() {
        return locationRepository.findAll().stream()
                .map(ResponseLocation::new)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseLocation get(Long id) {
        return new ResponseLocation(locationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("location not found")));
    }

    @Override
    public ResponseLocation update(UpdateLocation updateLocation) {

        var location = locationRepository.findById(updateLocation.getId())
                .orElseThrow(() -> new EntityNotFoundException("location not found"));


        location.setCity(updateLocation.getCity());
        location.setCountry(updateLocation.getCountry());
        location.setNumber(updateLocation.getNumber());
        location.setStreet(updateLocation.getStreet());
        location.setImageUrl(updateLocation.getImageUrl());

        return new ResponseLocation(locationRepository.save(location));
    }
}
