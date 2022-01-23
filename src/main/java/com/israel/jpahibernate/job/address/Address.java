package com.israel.jpahibernate.job.address;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
public class Address {

    @Id
    @Column
    private Long id;

    @Column
    private String street;

    @Column(nullable = false)
    private Long postcode;

    @Column(nullable = false)
    private String country;

    // Mapear con una relacion ya existente como esta llamado el campo en la entidad
//    @OneToOne(mappedBy = "address")
//    private Employee employee;

    public Address(Long id, String street, Long postcode, String country) {
        this.id = id;
        this.street = street;
        this.postcode = postcode;
        this.country = country;
    }
}
