package es.nom.marcosfernandez.springboot2jpa.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ProductCategory {

    @Id
    @Column(name = "pk", unique = true)
    private Long pk;

    @Column
    private String categoryName;

    @Column
    private int percentage;

    @Column
    private boolean bestCategory;

}
