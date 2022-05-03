package one.digitalinnovation.padroes.entities;

import javax.persistence.*;

@Entity(name = "Distribuidor")
public class Distribuidor {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id_Distribuidor;
    private String name;
    private String comments;
    @ManyToOne
    private Endereco address;
    private Integer addressNumber;

    public Long getId_Distributor() { return id_Distribuidor; }

    public void setId_Distributor(Long id_Distributor) {
        this.id_Distribuidor = id_Distributor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Endereco getAddress() {
        return address;
    }

    public void setAddress(Endereco address) {
        this.address = address;
    }

    public Integer getAddressNumber() { return addressNumber; }

    public void setAddressNumber(Integer addressNumber) { this.addressNumber = addressNumber; }
}
