package Event.Event.DTO;

import Event.Event.Entities.SeatReservations;

import java.util.List;

public class SeatReservationsDTO {

    private String name;
    private String seattype;
    private String status;
    private String snack;
    private double amount;
    private String amountstatus;

    public SeatReservationsDTO() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSeattype() {
        return seattype;
    }

    public void setSeattype(String seattype) {
        this.seattype = seattype;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSnack() {
        return snack;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getAmountstatus() {
        return amountstatus;
    }

    public void setAmountstatus(String amountstatus) {
        this.amountstatus = amountstatus;
    }

    public SeatReservationsDTO(String name, String seattype, String status, String snack, double amount, String amountstatus) {
        this.name = name;
        this.seattype = seattype;
        this.status = status;
        this.snack = snack;
        this.amount = amount;
        this.amountstatus = amountstatus;
    }


    public static SeatReservationsDTO EntitytoDto(SeatReservations reservations){
    SeatReservationsDTO dto = new SeatReservationsDTO();
    dto.setAmountstatus(reservations.getSnackOrders().getAmountstatus());
    dto.setAmount(reservations.getSnackOrders().getAmount());
    dto.setSnack(reservations.getSnackOrders().getSnack());
    dto.setStatus(reservations.getStatus());
    dto.setName(reservations.getName());
    dto.setSeattype(reservations.getSeattype());
    return dto;


    }
}

