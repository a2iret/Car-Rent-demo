package models;

import models.enums.RentStatus;

import java.sql.Date;

public class RentInfo {
    private Date startDate;
    private Date endDate;
    private int carId;
    private int renterId;
    private RentStatus status;

    public RentInfo(Date startDate, Date endDate, int carId, int renterId, RentStatus status) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.carId = carId;
        this.renterId = renterId;
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getRenterId() {
        return renterId;
    }

    public void setRenterId(int renterId) {
        this.renterId = renterId;
    }

    public RentStatus getStatus() {
        return status;
    }

    public void setStatus(RentStatus status) {
        this.status = status;
    }
}
