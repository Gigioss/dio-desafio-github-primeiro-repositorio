package one.digitalinnovation.padroes.repositories;

import one.digitalinnovation.padroes.entities.Produto;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends CrudRepository<Produto, Long> {

}
