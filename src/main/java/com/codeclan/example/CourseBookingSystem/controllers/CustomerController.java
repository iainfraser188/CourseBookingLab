package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CustomerController {

    @Autowired
    CustomerRepository customerRepository;

    @GetMapping(value= "/customers")
    public ResponseEntity getAllCustomers(
            @RequestParam(required = false, name = "") String name
            ){
        if(name != null){
            return new ResponseEntity(customerRepository.findByBookingsCourseName(name),HttpStatus.OK);
        }

        return new ResponseEntity(customerRepository.findAll(), HttpStatus.OK);
    }



}
