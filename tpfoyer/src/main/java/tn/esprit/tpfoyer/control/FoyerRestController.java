package tn.esprit.tpfoyer.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;

@RestController
@RequestMapping("foyer")
public class FoyerRestController {
    @Autowired
    IFoyerService foyerService;

    // http://localhost:8089/tpfoyer/foyer/retrieve-all-foyers
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyers = foyerService.retrieveAllFoyers();
        return listFoyers;
    }

    // http://localhost:8089/tpfoyer/foyer/retrieve-foyer/8
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long foyerId) {
        Foyer foyer = foyerService.retrieveFoyer(foyerId);
        return foyer;
    }

    // http://localhost:8089/tpfoyer/etudiant/add-etudiant
    @PostMapping("/add-foyer")
    public Foyer addEtudiant(@RequestBody Foyer f) {
        Foyer foyer = foyerService.addFoyer(f);
        return foyer;
    }
    // http://localhost:8089/tpfoyer/etudiant/remove-etudiant/{etudiant-id}
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeEtudiant(@PathVariable("foyer-id") Long etId) {

        foyerService.removeFoyer(etId);
    }

    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-foyer")
    public Foyer modifyEtudiant(@RequestBody Foyer f) {
        Foyer foyer = foyerService.modifyFoyer(f);
        return foyer;
    }
}
