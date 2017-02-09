package com.mokon.spring.boot.backend.controller;

import com.mokon.spring.boot.backend.model.dto.CustomerDto;
import com.mokon.spring.boot.backend.model.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mokon on 08.02.2017.
 */
@Controller
public class MainWebController {

    private static final Logger log = LoggerFactory.getLogger(MainWebController.class);

    @Autowired
    private CustomerService service;

    @GetMapping("/")
    public String prepareData() {
        service.save(new CustomerDto("Jack", "Bauer"));
        service.save(new CustomerDto("Chloe", "O'Brian"));
        service.save(new CustomerDto("Kim", "Bauer"));
        service.save(new CustomerDto("David", "Palmer"));
        service.save(new CustomerDto("Michelle", "Dessler"));

        // fetch all customers
        log.info("Customers found with findAll():");
        log.info("-------------------------------");
        for (CustomerDto customer : service.findAll()) {
            log.info(customer.toString());
        }
        log.info("");

        // fetch an individual customer by ID
        CustomerDto customer = service.findOne(1L);
        log.info("Customer found with findOne(1L):");
        log.info("--------------------------------");
        log.info(customer.toString());
        log.info("");

        // fetch customers by last name
        log.info("Customer found with findByLastName('Bauer'):");
        log.info("--------------------------------------------");
        for (CustomerDto bauer : service.findByLastName("Bauer")) {
            log.info(bauer.toString());
        }
        log.info("");
        return "index";
    }

    @GetMapping("/test")
    public String render(@RequestParam(name = "name", required = false) String name, Model model) {
        model.addAttribute("name", name);
        return "index";
    }
}
