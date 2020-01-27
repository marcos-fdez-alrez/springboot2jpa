package es.nom.marcosfernandez.springboot2jpa.controller;

import es.nom.marcosfernandez.springboot2jpa.entities.Employee;
import es.nom.marcosfernandez.springboot2jpa.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestEndpointController {

    @Autowired
    private DashboardService dashboardService;

    @RequestMapping("/employees")
    public List<Employee> getAllEmployees() {
        return dashboardService.getEmployeeDashboard();
    }

    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    public String saveEmployee(@RequestBody Employee employee) {
        return dashboardService.addEmployee(employee) != null ? "done!":"error";
    }

    @RequestMapping(value = "/employees/{id}",method = RequestMethod.DELETE)
    public String saveEmployee(@PathVariable Long id) {
        Optional<Employee> employee = dashboardService.findEmployeeById(id);
        if(employee.isPresent()) {
            dashboardService.deleteEmployee(employee.get());
            return "deleted!";
        }
        return "error";
    }
}
