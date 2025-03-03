package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IReservationService;

import java.util.List;

@Tag(name = "Gestion Reservation")

@RestController
@AllArgsConstructor
@RequestMapping("/reservation")
public class ReservationRestController {
    @Autowired
    IReservationService reservationService ;

    //http://localhost:8089/tpfoyer/reservation/retrieve-all-reservations
    @Operation(description = "récupérer toutes les reservations de la base de données")
    @GetMapping("/retrieve-all-reservations")
    public List<Reservation> getReservations(){
        return reservationService.retrieveAllReservations();
    }

    //http://localhost:8089/tpfoyer/reservation/retrieve-reservation/8
    @Operation(description = "récupérer par ID  les reservations de la base de données")
    @GetMapping("/retrieve-reservation/{reservation-id}")
    public Reservation retrieveReservation(@PathVariable("reservation-id") String idReservation){
        return reservationService.retrieveReservation(idReservation) ;
    }

    @PostMapping("/add-reservation")
    @Operation(description = "ajouter une reservation à la base de données")
    public Reservation addReservation(@RequestBody Reservation reservation){
        return reservationService.addReservation(reservation) ;
    }

    @DeleteMapping("/delete-reservation/{reservation-id}")
    @Operation(description = "supprimer une reservation de la base de données")
    public void removeReservation(@PathVariable("reservation-id") String idReservation){
        reservationService.removeReservation(idReservation);
    }

    @PutMapping("/modify-reservation")
    @Operation(description = "modifier une reservation de la base de données")
    public Reservation modifyReservation(@RequestBody Reservation reservation){
        return reservationService.modifyReservation(reservation) ;
    }
}