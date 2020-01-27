package es.nom.marcosfernandez.springboot2jpa.repositories;


import es.nom.marcosfernandez.springboot2jpa.entities.OrderEntity;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value = "orderEntityRepository")
public interface OrderEntityRepository extends JpaRepository<OrderEntity,Long> {
}
