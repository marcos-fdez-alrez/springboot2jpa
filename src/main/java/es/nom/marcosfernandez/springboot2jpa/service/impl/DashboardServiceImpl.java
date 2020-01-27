package es.nom.marcosfernandez.springboot2jpa.service.impl;

import es.nom.marcosfernandez.springboot2jpa.entities.*;
import es.nom.marcosfernandez.springboot2jpa.repositories.*;
import es.nom.marcosfernandez.springboot2jpa.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.NumberFormat;
import java.util.*;

@Service
public class DashboardServiceImpl implements DashboardService {

    @Autowired
    private CompanyRevenueRepository companyRevenueRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private OrderCollectionStatusRepository orderCollectionStatusRepository;

    @Autowired
    private OrderEntityRepository orderEntityRepository;

    @Autowired
    private ProductCategoryRepository productCategoryRepository;


    @Override
    public HashMap<String, Object> getOrderDashboard() {
        HashMap<String,Object> orderDash = new HashMap<>();

        final List<OrderEntity> orderEntities = orderEntityRepository.findAll();

        List<String> labels = new ArrayList<>();
        List<Double> orders = new ArrayList<>();

        for (OrderEntity orderEntity : orderEntities) {
            labels.add(orderEntity.getDate());
            orders.add(Double.valueOf(orderEntity.getOrderId()));
        }

        orderDash.put("labels",labels);
        orderDash.put("orders",orders);

        return  orderDash;
    }

    @Override
    public HashMap<String, Object> getTodayRevenueDashboard() {
        HashMap<String,Object> populateCompanyRev = new HashMap<>();

        final List<CompanyRevenue> companyRevenues = companyRevenueRepository.findAll();

        /**
         * Build Labels and Revenue
         */

        List<String> label = new ArrayList<>();
        List<Double> revenue = new ArrayList<>();
        double totalMargin = 0;
        double totalExpense = 0;
        double totalRevenue = 0;

        Locale locale = new Locale("es","ES");
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);

        for (CompanyRevenue companyRevenue : companyRevenues) {
            label.add(companyRevenue.getMonth());
            revenue.add(companyRevenue.getRevenue());
            totalExpense += companyRevenue.getExpense();
            totalMargin += companyRevenue.getMargins();
            totalRevenue += companyRevenue.getRevenue();
        }

        populateCompanyRev.put("crLabels",label.toString());
        populateCompanyRev.put("crRevenue",revenue);
        populateCompanyRev.put("totalExpense",numberFormat.format(totalExpense));
        populateCompanyRev.put("totalMargin",numberFormat.format(totalMargin));
        populateCompanyRev.put("totalRevenue",numberFormat.format(totalRevenue));

        return populateCompanyRev;
    }

    @Override
    public List<Employee> getEmployeeDashboard() {
        return employeeRepository.findAll();
    }

    @Override
    public List<OrderCollectionStatus> getOrderCollectionStatusDashboard() {
        return orderCollectionStatusRepository.findAll();
    }

    @Override
    public List<OrderEntity> getOrderEntityDashboard() {
        return orderEntityRepository.findAll();
    }

    @Override
    public List<ProductCategory> getProductCategoryDashboard() {
        return productCategoryRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public Optional<Employee> findEmployeeById(Long id) {
        return employeeRepository.findById(id);
    }
}
