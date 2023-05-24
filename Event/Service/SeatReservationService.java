package Event.Event.Service;

import Event.Event.DTO.SeatReservationsDTO;
import Event.Event.Entities.SeatReservations;
import Event.Event.Entities.SnackOrder;
import Event.Event.Repository.SeatReservationsRepo;
import Event.Event.Repository.SnackOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class SeatReservationService {
    @Autowired
    private SeatReservationsRepo seatReservationRepository;
    @Autowired
    private SnackOrderRepo snackOrderRepo;
    public List<SeatReservations> getAllSeatReservations() {
        return seatReservationRepository.findAll();
    }

    public List<SeatReservationsDTO> FindByName(String name) {
        List<SeatReservations> dto =  seatReservationRepository.findByName(name);
        List<SeatReservationsDTO> dto1 = dto.stream().map(this::EntitytoDto).toList();
        return dto1;
        }

    public List<SeatReservationsDTO> FindByStatus(String status){
        List<SeatReservations> dto =  seatReservationRepository.findByStatus(status);
        List<SeatReservationsDTO> dto1 = dto.stream().map(this::EntitytoDto).toList();
        return dto1;
    }
    public ResponseEntity<?> orderSnacks(Integer reservationId, SnackOrder snackOrder) {
        SeatReservations seatReservation = seatReservationRepository.findById(reservationId).orElse(null);

        if (seatReservation != null && seatReservation.getSeattype().equalsIgnoreCase("VIP")) {
            snackOrder.setReservationid(reservationId);
            snackOrderRepo.save(snackOrder);
            return ResponseEntity.ok("Snacks ordered successfully for VIP seat reservation.");
        } else {
            return ResponseEntity.ok("Cannot order snacks for the provided reservation ID.");
        }
    }
    

    public  List<SeatReservationsDTO> findByReservation(Integer reservationid){
            List<SeatReservations> dto =  seatReservationRepository.findByReservationid(reservationid);
            List<SeatReservationsDTO> dto1 = dto.stream().map(this::EntitytoDto).toList();
            return dto1;
        }
    public List<SeatReservationsDTO> FindByseattype(String seattype) {
        List<SeatReservations> dto =  seatReservationRepository.findBySeattype(seattype);
        List<SeatReservationsDTO> dto1 = dto.stream().map(this::EntitytoDto).toList();
        return dto1;
    }
    public List<SeatReservationsDTO> FindByamountstatus(String amountstatus) {
        List<SeatReservations> dto =  seatReservationRepository.findBysnackOrdersAmountstatus(amountstatus);
        List<SeatReservationsDTO> dto1 = dto.stream().map(this::EntitytoDto).toList();
        return dto1;
    }


    public  SeatReservationsDTO EntitytoDto(SeatReservations reservations){
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
