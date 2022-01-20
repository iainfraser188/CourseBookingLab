package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value= "/courses")
    public ResponseEntity getAllCourses(
            @RequestParam(required = false, name = "rating")Integer rating,
            @RequestParam(required = false, name = "custName")String custName

            ){
        if(rating != null){
            return new ResponseEntity(courseRepository.findByRating(rating),HttpStatus.OK);
        }
        if(custName!= null){
            return new ResponseEntity(courseRepository.findByBookingsCustomerName(custName),HttpStatus.OK);
        }

        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);

    }



}
