package mz.co.faktorize.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Table(name = "tb_suppliers")
@Entity
public class Supplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String vatNumber;
    private String name;
    private String address;

    @OneToMany(mappedBy = "supplier", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Invoice> invoices;

}