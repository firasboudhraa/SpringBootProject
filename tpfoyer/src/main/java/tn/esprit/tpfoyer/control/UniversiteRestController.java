package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.service.IUniversiteService;

import java.util.List;

@Tag(name = "Gestion Universite")
@RestController
@RequestMapping("/universite")
public class UniversiteRestController {
    @Autowired
    IUniversiteService universiteService ;
    //http://localhost:8089/tpfoyer/universite/retrieve-all-universites
    @Operation(description = "récupérer toutes les universités de la base de données")
    @GetMapping("/retrieve-all-universites")
    public List<Universite> getUniversites(){
        return universiteService.retrieveAllUniversites();
    }

    //http://localhost:8089/tpfoyer/universite/retrieve-universite/8
    @Operation(description = "récupérer par ID  les universités de la base de données")
    @GetMapping("/retrieve-universite/{universite-id}")
    public Universite retrieveUniversite(@PathVariable("universite-id") Long idUniversite){
        return universiteService.retrieveUniversite(idUniversite) ;
    }

    @PostMapping("/add-universite")
    @Operation(description = "ajouter une université à la base de données")
    public Universite addUniversite(@RequestBody Universite universite){
        return universiteService.addUniversite(universite) ;
    }

    @DeleteMapping("/delete-universite/{universite-id}")
    @Operation(description = "supprimer une université de la base de données")
    public void removeUniversite(@PathVariable("universite-id") Long idUniversite){
        universiteService.removeUniversite(idUniversite);
    }

    @PutMapping("/modify-universite")
    @Operation(description = "modifier une université de la base de données")
    public Universite modifyUniversite(@RequestBody Universite universite){
        return universiteService.modifyUniversite(universite) ;
    }
}