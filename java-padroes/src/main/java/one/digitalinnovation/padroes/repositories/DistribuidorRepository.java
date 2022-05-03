package one.digitalinnovation.padroes.repositories;

import one.digitalinnovation.padroes.entities.Distribuidor;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistribuidorRepository extends CrudRepository<Distribuidor, Long> {

}
