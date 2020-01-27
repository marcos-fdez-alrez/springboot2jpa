package es.nom.marcosfernandez.springboot2jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CompanyRevenue {

    @Id
    @Column(name = "pk", unique = true)
    private Long pk;

    @Column(name = "monthly_revenue" , nullable = false)
    private String month;

    @Column(name = "revenue" , nullable = false)
    private double revenue;

    @Column(name = "expense")
    private double expense;

    @Column(name = "margins")
    private double margins;

}
