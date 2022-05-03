package one.digitalinnovation.padroes.services;

import one.digitalinnovation.padroes.entities.Produto;

/**
 * Interface que define o padrão <b>Strategy</b> no domínio de produtos. Com
 * isso, se necessário, podemos ter múltiplas implementações dessa mesma
 * interface.
 *
 * @author didifive
 */
public interface ProdutoService {

    Iterable<Produto> findAll();

    Produto findById(Long id);

    Produto buscarPorId(Long id);

    void insert(Produto product);

    void update(Long id, Produto product);

    void delete(Long id);
}