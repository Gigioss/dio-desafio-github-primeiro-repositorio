package one.digitalinnovation.padroes.controllers;

import one.digitalinnovation.padroes.entities.Produto;
import one.digitalinnovation.padroes.services.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/v1/products")
public class ProductsRestController {

    @Autowired
    private ProdutoService productsService;

    @GetMapping
    public ResponseEntity<Iterable<Produto>> findAll() {
        return ResponseEntity.ok(productsService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(productsService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Produto> insert(@RequestBody Produto product) {
        productsService.insert(product);
        return ResponseEntity.ok(product);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> update(@PathVariable Long id, @RequestBody Produto product) {
        productsService.update(id, product);
        return ResponseEntity.ok(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productsService.delete(id);
        return ResponseEntity.ok().build();
    }
}