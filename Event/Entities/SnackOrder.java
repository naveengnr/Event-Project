package Event.Event.Entities;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Objects;

@Entity
@Table(name="snackorders")
public class SnackOrder {
    @Id
    private int orderid;

    private int reservationid;
    private String snack;

    private double amount;

    private String amountstatus;
//    @ManyToOne
//    @JoinColumn(name = "reservationid",updatable = false,insertable = false)
//    private SeatReservations seatReservation;
    @OneToOne
    @JoinColumn(name = "reservationid", referencedColumnName = "reservationid", updatable = false, insertable = false)
    private SeatReservations seatReservation;
    public SnackOrder(int orderId, int reservationid, String snack, double amount, String amountStatus, SeatReservations seatReservation) {
        this.orderid = orderId;
        this.reservationid = reservationid;
        this.snack = snack;
        this.amount = amount;
        this.amountstatus = amountStatus;
        this.seatReservation = seatReservation;
    }

    public int getOrderId() {
        return orderid;
    }

    public void setOrderId(int orderId) {
        this.orderid = orderId;
    }

    public int getReservationid() {
        return reservationid;
    }

    public void setReservationid(int reservationid) {
        this.reservationid = reservationid;
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

    public SeatReservations getSeatReservation() {
        return seatReservation;
    }

    public void setSeatReservation(SeatReservations seatReservation) {
        this.seatReservation = seatReservation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SnackOrder that = (SnackOrder) o;
        return orderid == that.orderid && reservationid == that.reservationid && Objects.equals(snack, that.snack) && Objects.equals(amount, that.amount) && Objects.equals(amountstatus, that.amountstatus) && Objects.equals(seatReservation, that.seatReservation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderid, reservationid, snack, amount, amountstatus, seatReservation);
    }

    @Override
    public String toString() {
        return "SnackOrder{" +
                "orderId=" + orderid +
                ", reservationid=" + reservationid +
                ", snack='" + snack + '\'' +
                ", amount=" + amount +
                ", amountStatus='" + amountstatus + '\'' +
                ", seatReservation=" + seatReservation +
                '}';
    }
    public SnackOrder (){};

}
