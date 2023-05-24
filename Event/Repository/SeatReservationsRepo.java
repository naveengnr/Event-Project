package Event.Event.Repository;

import Event.Event.Entities.SeatReservations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface SeatReservationsRepo extends JpaRepository<SeatReservations,Integer> {

    List<SeatReservations> findByName (String name);
    List<SeatReservations> findByStatus(String status);
    //SeatReservations findSeatReservationByAttributes(Integer reservationId, String name, String seattype, String status, String snack, Double amount, String amountstatus);
//
    List<SeatReservations> findByReservationid(Integer reservationid);
    List<SeatReservations> findBySeattype(String seattype);

    List<SeatReservations> findBysnackOrdersAmountstatus(String amountstatus);

}
