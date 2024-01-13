package org.fmiplovdiv.weblanguages.travelagencyapi.dtos;

import org.fmiplovdiv.weblanguages.travelagencyapi.models.Reservation;

public class ResponseReservation {

    private Long id;
    private String contactName;
    private String phoneNumber;
    private ResponseHoliday holiday;

    public ResponseReservation(Long id, String contactName, String phoneNumber, ResponseHoliday holiday) {
        this.id = id;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.holiday = holiday;
    }

    public ResponseReservation(Reservation reservation) {
        this.id = reservation.getId();
        this.contactName = reservation.getContactName();
        this.phoneNumber = reservation.getPhoneNumber();
        this.holiday = new ResponseHoliday(reservation.getHoliday());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public ResponseHoliday getHoliday() {
        return holiday;
    }

    public void setHoliday(ResponseHoliday holiday) {
        this.holiday = holiday;
    }
}
