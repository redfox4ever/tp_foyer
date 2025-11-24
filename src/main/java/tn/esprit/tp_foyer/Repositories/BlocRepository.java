package tn.esprit.tp_foyer.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.tp_foyer.Entities.Bloc;

import java.util.List;

@Repository
public interface BlocRepository extends JpaRepository<Bloc, Long> {

    List<Bloc> findByFoyerIsNull();

    List<Bloc> findByCapaciteBlocGreaterThan(long count);

    List<Bloc> findByNomBlocStartingWith(String nomBloc);

    List<Bloc> findByNomBlocStartingWithAndCapaciteBlocGreaterThan(String nomBloc, long count);
}
