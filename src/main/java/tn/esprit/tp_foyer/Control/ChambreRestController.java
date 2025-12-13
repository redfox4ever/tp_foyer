package tn.esprit.tp_foyer.Control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tp_foyer.DTO.ChambreDTO;
import tn.esprit.tp_foyer.Entities.Chambre;

import tn.esprit.tp_foyer.Entities.TypeChambre;
import tn.esprit.tp_foyer.Services.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {
    IChambreService chambreService;
    // http://localhost:8089/tpfoyer/chambre/retrieve-all-chambres
    @GetMapping("/retrieve-all-chambres")
    public List<ChambreDTO> getChambres() {
        return chambreService.retrieveAllChambres();
    }
    // http://localhost:8089/tpfoyer/chambre/retrieve-chambre/8
    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }

    // http://localhost:8089/tpfoyer/chambre/add-chambre
    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }
    // http://localhost:8089/tpfoyer/chambre/remove-chambre/{chambre-id}
    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }
    // http://localhost:8089/tpfoyer/chambre/modify-chambre
    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }

    @PostMapping("/add-chambre-with-reservation")
    public Chambre addChambreWithReservation(@RequestBody Chambre chambre) {
        return chambreService.addChambreWithReservation(chambre);
    }


    // Example: PUT http://localhost:8089/tpfoyer/chambre/assign/RES123/5
    @PutMapping("/assign/{reservationId}/{chambreId}")
    public Chambre assignReservationToChambre(@PathVariable String reservationId,
                                              @PathVariable long chambreId) {
        return chambreService.assignReservationToChambre(reservationId, chambreId);
    }


    // Example: PUT http://localhost:8089/tpfoyer/chambre/unassign/RES123/5
    @PutMapping("/unassign/{reservationId}/{chambreId}")
    public Chambre unassignReservationToChambre(@PathVariable String reservationId,
                                                @PathVariable long chambreId) {
        return chambreService.unassignReservationToChambre(reservationId, chambreId);
    }

    @GetMapping("/Test-Repo/findByTypeC")
    public List<Chambre> findByTypeC(@RequestParam TypeChambre typeC)
    {
        return  chambreService.findByTypeC(typeC);
    }

    @GetMapping("/Test-Repo/findByNumeroChambre")
    public List<Chambre> findByNumeroChambre(@RequestParam long numeroChambre)
    {
        return chambreService.findByNumeroChambre(numeroChambre);
    }

    @GetMapping("/Test-Repo/findChambreByEtudiantCin")
    public Chambre findChambreByEtudiantCin(@RequestParam long cin)
    {
        return chambreService.findChambreByEtudiantCin(cin);
    }
}
