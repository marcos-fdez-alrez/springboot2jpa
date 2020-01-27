package es.nom.marcosfernandez.springboot2jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Employee {

    @Id
    @Column(name = "pk", unique = true)
    private Long pk;

    @Column
    private String name;

    @Column
    private String position;

    @Column
    private String officeLocation;

    @Column
    private int age;

    @Column
    private Date startDate;

    @Column
    private double salary;

}
