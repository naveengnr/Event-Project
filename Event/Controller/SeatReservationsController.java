package Event.Event.Controller;

import Event.Event.DTO.SeatReservationsDTO;
import Event.Event.Entities.SeatReservations;
import Event.Event.Entities.SnackOrder;
import Event.Event.Service.SeatReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/seatreservations")
public class SeatReservationsController {
    @Autowired
    private SeatReservationService seatReservationService;


    @GetMapping("/seat-reservations")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> getSeatReservation(
            @RequestParam(required = false) Integer reservationid,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String seattype,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) String amountstatus) {

        if(reservationid != null && name==null && seattype == null && status == null && amountstatus==null){
            return ResponseEntity.ok().body(seatReservationService.findByReservation(reservationid));
        }else if(reservationid == null && name !=null && seattype == null && status == null && amountstatus==null){
            return ResponseEntity.ok().body(seatReservationService.FindByName(name));
        }else if(reservationid == null && name ==null && seattype != null && status == null && amountstatus==null){
            return ResponseEntity.ok().body(seatReservationService.FindByseattype(seattype));
        }else if(reservationid == null && name ==null && seattype == null && status != null && amountstatus==null){
            return ResponseEntity.ok().body(seatReservationService.FindByStatus(status));
        }else if(reservationid == null && name ==null && seattype == null && status == null && amountstatus!=null){
            return ResponseEntity.ok().body(seatReservationService.FindByamountstatus(amountstatus));
        }

       return ResponseEntity.badRequest().body("Enter the valid Input");
    }
    @GetMapping
    public List<SeatReservations> getAllSeatReservations() {
        return seatReservationService.getAllSeatReservations();
    }

    @GetMapping("/name")
    public ResponseEntity<?> getAllByName(@RequestParam("name") String name){
        return ResponseEntity.ok().body( seatReservationService.FindByName(name));
    }
    @GetMapping("/status")
    public ResponseEntity<?> getAllByStatus(@RequestParam("status") String status){
        return ResponseEntity.ok().body(seatReservationService.FindByStatus(status));
    }

    @PostMapping("/snacks/{reservationId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> orderSnacks(@PathVariable Integer reservationId, @RequestBody SnackOrder snackOrder) {
        return seatReservationService.orderSnacks(reservationId, snackOrder);
    }

}
