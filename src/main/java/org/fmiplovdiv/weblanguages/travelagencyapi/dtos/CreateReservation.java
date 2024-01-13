package org.fmiplovdiv.weblanguages.travelagencyapi.dtos;

public class CreateReservation {

    private String contactName;
    private String phoneNumber;
    private Long holiday;

    public CreateReservation(String contactName, String phoneNumber, Long holiday) {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.holiday = holiday;
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

    public Long getHoliday() {
        return holiday;
    }

    public void setHoliday(Long holiday) {
        this.holiday = holiday;
    }
}
