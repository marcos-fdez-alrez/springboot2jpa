package es.nom.marcosfernandez.springboot2jpa.controller;

import es.nom.marcosfernandez.springboot2jpa.service.DashboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ThymeleafController {

    @Autowired
    private DashboardService dashboardService;

    @GetMapping("/")
    public String getDashDetail(Model model) {
        /**
         * Populates Company Revenue data
         */
        model.addAttribute("cr",dashboardService.getTodayRevenueDashboard());

        /**
         * Populate Employees info
         */
        model.addAttribute("ei", dashboardService.getEmployeeDashboard());

        /**
         * Populate Orders info
         */
        model.addAttribute("ods", dashboardService.getOrderDashboard());

        return "/index";
    }

}
