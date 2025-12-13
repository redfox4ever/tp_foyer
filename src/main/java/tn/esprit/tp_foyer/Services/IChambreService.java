package tn.esprit.tp_foyer.Services;

import tn.esprit.tp_foyer.DTO.ChambreDTO;
import tn.esprit.tp_foyer.Entities.Chambre;
import tn.esprit.tp_foyer.Entities.TypeChambre;

import java.util.List;

public interface IChambreService {
    public List<ChambreDTO> retrieveAllChambres();
    public Chambre retrieveChambre(Long chambreId);
    public Chambre addChambre(Chambre c);
    public void removeChambre(Long chambreId);
    public Chambre modifyChambre(Chambre chambre);
    public Chambre unassignReservationToChambre(String reservationId, long chambreId);
    public Chambre assignReservationToChambre(String reservationId, long chambreId);
    Chambre addChambreWithReservation(Chambre chambre);

    List<Chambre> findByTypeC(TypeChambre typeC);

    List<Chambre> findByNumeroChambre(long numeroChambre);

    void pourcentageChambreParTypeChambre();
    Chambre findChambreByEtudiantCin(long cin);

}
