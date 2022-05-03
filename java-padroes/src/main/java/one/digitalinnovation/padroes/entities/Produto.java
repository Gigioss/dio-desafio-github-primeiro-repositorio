package one.digitalinnovation.padroes.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "Produto")
public class Produto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idProduct;
    private String name;
    private String unidades;

    private String marca;
    @OneToMany(cascade={CascadeType.MERGE}, fetch = FetchType.LAZY)
    List<Distribuidor> distributors = new ArrayList<>();

    public Long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Long idProduct) {
        this.idProduct = idProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUnidades() {
        return unidades;
    }

    public void setUnidades(String unidades) {
        this.unidades = unidades;
    }

    public List<Distribuidor> getDistributors() { return distributors; }

    public void setDistributors(List<Distribuidor> distributors) {
        this.distributors = distributors;
    }
}
