package es.nom.marcosfernandez.springboot2jpa.service;

import es.nom.marcosfernandez.springboot2jpa.entities.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

public interface DashboardService {

    HashMap<String, Object> getTodayRevenueDashboard();

    HashMap<String, Object> getOrderDashboard();

    List<Employee> getEmployeeDashboard();

    List<OrderCollectionStatus> getOrderCollectionStatusDashboard();

    List<OrderEntity> getOrderEntityDashboard();

    List<ProductCategory> getProductCategoryDashboard();

    Employee addEmployee(Employee employee);

    void updateEmployee(Employee employee);

    void deleteEmployee(Employee employee);

    Optional<Employee> findEmployeeById(Long id);
}
