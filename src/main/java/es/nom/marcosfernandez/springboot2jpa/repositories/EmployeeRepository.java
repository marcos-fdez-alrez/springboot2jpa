package es.nom.marcosfernandez.springboot2jpa.repositories;


import es.nom.marcosfernandez.springboot2jpa.entities.Employee;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value = "employeeRepository")
public interface EmployeeRepository extends JpaRepository<Employee,Long> {
}
