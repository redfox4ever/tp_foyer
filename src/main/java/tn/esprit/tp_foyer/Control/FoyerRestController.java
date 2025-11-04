package tn.esprit.tp_foyer.Control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.Entities.Foyer;
import tn.esprit.tp_foyer.Services.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/foyer")
public class FoyerRestController {
    IFoyerService foyerService;

    // http://localhost:8089/tpfoyer/foyer/retrieve-all-foyers
    @GetMapping("/retrieve-all-foyers")
    public List<Foyer> getFoyers() {
        return foyerService.retrieveAllFoyers();
    }

    // http://localhost:8089/tpfoyer/foyer/retrieve-foyer/{foyer-id}
    @GetMapping("/retrieve-foyer/{foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("foyer-id") Long foyerId) {
        return foyerService.retrieveFoyer(foyerId);
    }

    // http://localhost:8089/tpfoyer/foyer/add-foyer
    @PostMapping("/add-foyer")
    public Foyer addFoyer(@RequestBody Foyer f) {
        return foyerService.addFoyer(f);
    }

    // http://localhost:8089/tpfoyer/foyer/remove-foyer/{foyer-id}
    @DeleteMapping("/remove-foyer/{foyer-id}")
    public void removeFoyer(@PathVariable("foyer-id") Long foyerId) {
        foyerService.removeFoyer(foyerId);
    }

    // http://localhost:8089/tpfoyer/foyer/modify-foyer
    @PutMapping("/modify-foyer")
    public Foyer modifyFoyer(@RequestBody Foyer f) {
        return foyerService.modifyFoyer(f);
    }
}
