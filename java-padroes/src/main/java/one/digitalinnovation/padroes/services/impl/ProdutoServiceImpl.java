package one.digitalinnovation.padroes.services.impl;

import one.digitalinnovation.padroes.entities.Endereco;
import one.digitalinnovation.padroes.entities.Distribuidor;
import one.digitalinnovation.padroes.entities.Produto;
import one.digitalinnovation.padroes.repositories.DistribuidorRepository;
import one.digitalinnovation.padroes.repositories.EnderecoRepository;
import one.digitalinnovation.padroes.repositories.ProdutoRepository;
import one.digitalinnovation.padroes.services.ProdutoService;
import one.digitalinnovation.padroes.services.ViaCepService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoServiceImpl implements ProdutoService {


    @Autowired
    private ProdutoRepository productsRepository;
    @Autowired
    private DistribuidorRepository distributorsRepository;
    @Autowired
    private EnderecoRepository addressesRepository;
    @Autowired
    private ViaCepService viaCepService;

    // Strategy: Implementar os métodos definidos na interface.
    // Facade: Abstrair integrações com subsistemas, provendo uma interface simples.

    @Override
    public Iterable<Produto> findAll() {
        return productsRepository.findAll();
    }

    @Override
    public Produto findById(Long id) {
        return null;
    }

    @Override
    public Produto buscarPorId(Long id) {
        Optional<Produto> product = productsRepository.findById(id);
        return product.get();
    }

    @Override
    public void insert(Produto product) {
        insertProductWithDistributor(product);
    }

    @Override
    public void update(Long id, Produto product) {
        Optional<Produto> productDb = productsRepository.findById(id);
        if (productDb.isPresent()) {
            insertProductWithDistributor(product);
        }
    }

    @Override
    public void delete(Long id) {
        productsRepository.deleteById(id);
    }

    private void insertProductWithDistributor(Produto product) {
        List<Distribuidor> distribuidorList = product.getDistributors();
        distribuidorList.forEach(this::insertDistributorWithZipCod);
        productsRepository.save(product);
    }

    private void insertDistributorWithZipCod(Distribuidor distributor) {
        String cep = distributor.getAddress().getCep();
        Endereco address = addressesRepository.findById(cep).orElseGet(() -> {
            Endereco newAddress = viaCepService.consultarCep(cep);
            addressesRepository.save(newAddress);
            return newAddress;
        });
        distributor.setAddress(address);
        distributorsRepository.save(distributor);
    }

}
