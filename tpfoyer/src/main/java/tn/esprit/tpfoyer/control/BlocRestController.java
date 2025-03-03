package tn.esprit.tpfoyer.control;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.service.IBlocService;

import java.util.List;

@Tag(name = "Gestion Bloc")

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    @Autowired
    public IBlocService blocService;

    // http://localhost:8089/tpfoyer/bloc/retrieve-all-blocs
    @Operation(description = "récupérer tous les blocs de la base de données")
    @GetMapping("/retrieve-all-blocs")
    public List<Bloc> getBlocs() {
        List<Bloc> listBlocs = blocService.retrieveAllBlocs();
        return listBlocs;
    }

    // http://localhost:8089/tpfoyer/bloc/retrieve-bloc/1
    @Operation(description = "récupérer par ID  les blocs de la base de données")
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public Bloc retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        Bloc bloc = blocService.retrieveBloc(blocId);
        return bloc;
    }

    // http://localhost:8089/tpfoyer/bloc/add-bloc
    @Operation(description = "ajouter un bloc à la base de données")
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.addBloc(b);
        return bloc;
    }

    // http://localhost:8089/tpfoyer/bloc/remove-bloc/{bloc-id}
    @Operation(description = "supprimer un bloc de la base de données")
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.removeBloc(blocId);
    }

    // http://localhost:8089/tpfoyer/bloc/modify-bloc
    @PutMapping("/modify-bloc")
    @Operation(description = "modifer un bloc de la base de données")
    public Bloc modifyBloc(@RequestBody Bloc b) {
        Bloc bloc = blocService.modifyBloc(b);
        return bloc;
    }
}
