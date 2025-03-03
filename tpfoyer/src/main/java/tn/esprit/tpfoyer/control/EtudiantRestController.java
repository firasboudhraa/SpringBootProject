package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.List;

@Tag(name = "Gestion Etudiant")
@RestController
@AllArgsConstructor
@RequestMapping("/etudiant")
public class EtudiantRestController {
    @Autowired
    public IEtudiantService etudiantService;

    // http://localhost:8089/tpfoyer/etudiant/retrieve-all-etudiants
    @Operation(description = "récupérer tous les etudiants de la base de données")
    @GetMapping("/retrieve-all-etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = etudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }

    // http://localhost:8089/tpfoyer/etudiant/retrieve-etudiant/8
    @Operation(description = "récupérer par ID  les etudiants de la base de données")
    @GetMapping("/retrieve-etudiant/{etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("etudiant-id") Long etudiantId) {
        Etudiant etudiant = etudiantService.retrieveEtudiant(etudiantId);
        return etudiant;
    }

    // http://localhost:8089/tpfoyer/etudiant/add-etudiant
    @Operation(description = "ajouter un étudiant à la base de données")
    @PostMapping("/add-etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.addEtudiant(e);
        return etudiant;
    }
    // http://localhost:8089/tpfoyer/etudiant/remove-etudiant/{etudiant-id}
    @Operation(description = "supprimer un etudiant de la base de données")
    @DeleteMapping("/remove-etudiant/{etudiant-id}")
    public void removeEtudiant(@PathVariable("etudiant-id") Long etId) {

        etudiantService.removeEtudiant(etId);
    }

    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @Operation(description = "modifier un étudiant de la base de données")
    @PutMapping("/modify-etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant e) {
        Etudiant etudiant = etudiantService.modifyEtudiant(e);
        return etudiant;
    }
}
