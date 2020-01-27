package es.nom.marcosfernandez.springboot2jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderEntity {

    @Id
    @Column(name = "pk", unique = true)
    private Long pk;

    @Column
    private String date;

    @Column
    private int orderId;

}
