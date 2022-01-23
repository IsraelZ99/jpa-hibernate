package com.israel.jpahibernate.job.employee;

import com.israel.jpahibernate.job.address.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "employees")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

//    private static final long serialVersionUID = 1L;

    @Id
    @Column
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String lastName;

    @Column(nullable = false)
    private LocalDate dateOfBirth;

    // Esta entidad sera la dueña, sera la tabla que tendra la relacion (fk) hacia el Id de la tabla Address (@JoinColumn)
    // Mecanismo de cascada: Por ejemplo si se guarda un empleado junto con su address, pero esta no existe
    //                       en la B.D la insertara por nosotros; Ademas tambien va bien cuando se quiere boorar
    //                       el employee tambien se borrara la address
    @OneToOne(cascade = { CascadeType.ALL })
    @JoinColumn
    private Address address;

}
