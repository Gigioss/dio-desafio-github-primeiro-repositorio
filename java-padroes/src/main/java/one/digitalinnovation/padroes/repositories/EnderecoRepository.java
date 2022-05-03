package one.digitalinnovation.padroes.repositories;

import one.digitalinnovation.padroes.entities.Endereco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnderecoRepository extends CrudRepository<Endereco, String> {

}