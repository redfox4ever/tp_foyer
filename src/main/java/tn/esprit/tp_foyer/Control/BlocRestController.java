package tn.esprit.tp_foyer.Control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.DTO.BlocDTO;
import tn.esprit.tp_foyer.Entities.Bloc;
import tn.esprit.tp_foyer.Services.IBlocService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/bloc")
public class BlocRestController {
    IBlocService blocService;

    // http://localhost:8089/tpfoyer/bloc/retrieve-all-blocs
    @GetMapping("/retrieve-all-blocs")
    public List<BlocDTO> getBlocs() {
        return blocService.retrieveAllBlocs();
    }

    // http://localhost:8089/tpfoyer/bloc/retrieve-bloc/{bloc-id}
    @GetMapping("/retrieve-bloc/{bloc-id}")
    public BlocDTO retrieveBloc(@PathVariable("bloc-id") Long blocId) {
        return blocService.retrieveBloc(blocId);
    }

    // http://localhost:8089/tpfoyer/bloc/add-bloc
    @PostMapping("/add-bloc")
    public Bloc addBloc(@RequestBody Bloc b) {
        return blocService.addBloc(b);
    }

    // http://localhost:8089/tpfoyer/bloc/remove-bloc/{bloc-id}
    @DeleteMapping("/remove-bloc/{bloc-id}")
    public void removeBloc(@PathVariable("bloc-id") Long blocId) {
        blocService.removeBloc(blocId);
    }

    // http://localhost:8089/tpfoyer/bloc/modify-bloc
    @PutMapping("/modify-bloc")
    public Bloc modifyBloc(@RequestBody Bloc b) {
        return blocService.modifyBloc(b);
    }


    @PostMapping("/add-bloc-with-foyer")
    public Bloc addBlocWithFoyer(@RequestBody Bloc bloc) {
        return blocService.addBlocWithFoyer(bloc);
    }

    // Example URL: PUT http://localhost:8089/tpfoyer/bloc/assign/1/3
    @PutMapping("/assign/{blocId}/{foyerId}")
    public Bloc assignBlocToFoyer(@PathVariable long blocId, @PathVariable long foyerId) {
        return blocService.assignBlocToFoyer(blocId, foyerId);
    }

    // Example URL: PUT http://localhost:8089/tpfoyer/bloc/unassign/1
    @PutMapping("/unassign/{blocId}")
    public Bloc unassignBlocToFoyer(@PathVariable long blocId) {
        return blocService.unassignBlocToFoyer(blocId);
    }

    @GetMapping("/Test-Repo")
    public List<Bloc> testRepo() {
        return blocService.findByFoyerIsNull();
    }


}
