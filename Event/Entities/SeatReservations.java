package Event.Event.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.*;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name="seatreservations")
public class SeatReservations {
    @Id
    private Integer reservationid;

    private String name;

    private String seattype;

    private String status;

    private LocalDateTime reservationtime;

    private Integer priority;

//    @OneToOne(mappedBy = "seatReservation")
//    @JsonIgnore
//    private SnackOrder snackOrders;

    @OneToOne(mappedBy = "seatReservation")
    @JoinColumn(name = "reservationid", referencedColumnName = "reservationid", updatable = false, insertable = false)
    @JsonIgnore
    private SnackOrder snackOrders;
    public SeatReservations(Integer reservationid, String name, String seattype, String status, LocalDateTime reservationtime, Integer priority, SnackOrder snackOrders) {
        this.reservationid = reservationid;
        this.name = name;
        this.seattype = seattype;
        this.status = status;
        this.reservationtime = reservationtime;
        this.priority = priority;
        this.snackOrders = snackOrders;
    }

    public Integer getReservationid() {
        return reservationid;
    }

    public void setReservationid(Integer reservationid) {
        this.reservationid = reservationid;
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

    public LocalDateTime getReservationtime() {
        return reservationtime;
    }

    public void setReservationtime(LocalDateTime reservationtime) {
        this.reservationtime = reservationtime;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public SnackOrder getSnackOrders() {
        return snackOrders;
    }

    public void setSnackOrders(SnackOrder snackOrders) {
        this.snackOrders = snackOrders;
    }

    @Override
    public String toString() {
        return "SeatReservations{" +
                "reservationid=" + reservationid +
                ", name='" + name + '\'' +
                ", seattype='" + seattype + '\'' +
                ", status='" + status + '\'' +
                ", reservationtime=" + reservationtime +
                ", priority=" + priority +
                ", snackOrders=" + snackOrders +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeatReservations that = (SeatReservations) o;
        return reservationid == that.reservationid && Objects.equals(name, that.name) && Objects.equals(seattype, that.seattype) && Objects.equals(status, that.status) && Objects.equals(reservationtime, that.reservationtime) && Objects.equals(priority, that.priority) && Objects.equals(snackOrders, that.snackOrders);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reservationid, name, seattype, status, reservationtime, priority, snackOrders);
    }

    public SeatReservations(){};
}
