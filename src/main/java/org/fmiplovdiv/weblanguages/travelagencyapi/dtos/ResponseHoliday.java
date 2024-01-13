package org.fmiplovdiv.weblanguages.travelagencyapi.dtos;

import org.fmiplovdiv.weblanguages.travelagencyapi.models.Holiday;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class ResponseHoliday {

    private Long id;
    private String title;
    private LocalDate startDate;
    private Integer duration;
    private Double price;
    private Integer freeSlots;
    private ResponseLocation location;

    public ResponseHoliday(Long id, String title, LocalDate startDate, Integer duration, Double price, Integer freeSlots, ResponseLocation location) {
        this.id = id;
        this.title = title;
        this.startDate = startDate;
        this.duration = duration;
        this.price = price;
        this.freeSlots = freeSlots;
        this.location = location;
    }

    public ResponseHoliday(Holiday holiday) {
        this.id = holiday.getId();
        this.title = holiday.getTitle();
        this.startDate = holiday.getStartDate();
        this.duration = holiday.getDuration();
        this.price = holiday.getPrice();
        this.freeSlots = holiday.getFreeSlots();
        this.location = new ResponseLocation(holiday.getLocation());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getFreeSlots() {
        return freeSlots;
    }

    public void setFreeSlots(Integer freeSlots) {
        this.freeSlots = freeSlots;
    }

    public ResponseLocation getLocation() {
        return location;
    }

    public void setLocation(ResponseLocation location) {
        this.location = location;
    }
}
