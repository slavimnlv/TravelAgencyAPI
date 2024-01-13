package org.fmiplovdiv.weblanguages.travelagencyapi.sevices;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.CreateReservation;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.ResponseHoliday;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.ResponseReservation;
import org.fmiplovdiv.weblanguages.travelagencyapi.dtos.UpdateReservation;
import org.fmiplovdiv.weblanguages.travelagencyapi.models.Holiday;
import org.fmiplovdiv.weblanguages.travelagencyapi.models.Reservation;
import org.fmiplovdiv.weblanguages.travelagencyapi.repos.HolidayRepository;
import org.fmiplovdiv.weblanguages.travelagencyapi.repos.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationServiceImpl implements ReservationService{

    private final ReservationRepository reservationRepository;
    private  final HolidayRepository holidayRepository;

    public ReservationServiceImpl(ReservationRepository reservationRepository, HolidayRepository holidayRepository) {
        this.reservationRepository = reservationRepository;
        this.holidayRepository = holidayRepository;
    }

    @Override
    @Transactional
    public ResponseReservation create(CreateReservation createReservation) {
        var holiday = holidayRepository.findById(createReservation.getHoliday())
                .orElseThrow(() -> new EntityNotFoundException("holiday not found"));

        holiday.setFreeSlots(holiday.getFreeSlots() - 1);

        holidayRepository.save(holiday);

        var reservation = reservationRepository.save(new Reservation(createReservation.getContactName(),
                createReservation.getPhoneNumber(), holiday));

        return new ResponseReservation(reservation);
    }

    @Override
    public Boolean delete(Long id) {
        if(reservationRepository.existsById(id)){
            reservationRepository.deleteById(id);
            return true;
        }
        throw new EntityNotFoundException("reservation not found");
    }

    @Override
    public List<ResponseReservation> getAll() {
        return reservationRepository.findAll().stream()
                .map(ResponseReservation::new)
                .collect(Collectors.toList());
    }

    @Override
    public ResponseReservation get(Long id) {
        return new ResponseReservation(reservationRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("reservation not found")));
    }

    @Override
    public ResponseReservation update(UpdateReservation updateReservation) {
        var reservation = reservationRepository.findById(updateReservation.getId())
                .orElseThrow(() -> new EntityNotFoundException("reservation not found"));

        var holiday = holidayRepository.findById(updateReservation.getHoliday())
                .orElseThrow(() -> new EntityNotFoundException("holiday not found"));

        reservation.setContactName(updateReservation.getContactName());
        reservation.setPhoneNumber(updateReservation.getPhoneNumber());
        reservation.setHoliday(holiday);

        return new ResponseReservation(reservationRepository.save(reservation));
    }
}
