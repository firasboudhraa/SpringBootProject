package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.service.IChambreService;

import java.util.List;

@Tag(name = "Gestion Chambre")
@RestController
@NoArgsConstructor
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
   @Autowired
    public IChambreService chambreService;
    // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
    @Operation(description = "récupérer toutes les chambres de la base de données")
    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return listChambres;
    }
    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @Operation(description = "récupérer par ID  les chambres de la base de données")
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @Operation(description = "ajouter une chambre à la base de données")
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @Operation(description = "supprimer une chambre de la base de données")
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }
    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    @Operation(description = "modifier une chambre de la base de données")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }

    // http://localhost:8089/tpfoyer/chambre/create-chambre-and-reservation
    @Operation(description = "ajouter une chambre et une réservation à la base de données")
    @PostMapping("/create-chambre-and-reservation")
    public Chambre createChambreAndReservation(@RequestBody Chambre chambre) {
        return chambreService.createChambreAndReservation(chambre);
    }

    // http://localhost:8089/tpfoyer/chambre/trouver-chambre-selon-cin-etudiant/123456
    @Operation(description = "trouver une chambre selon le cin de l'étudiant")
    @GetMapping("/trouver-chambre-selon-cin-etudiant/{cin}")
    public Chambre trouverChambreSelonCinEtudiant(@PathVariable("cin") long cin) {
        return chambreService.trouverChambreSelonCinEtudiant(cin);
    }
}