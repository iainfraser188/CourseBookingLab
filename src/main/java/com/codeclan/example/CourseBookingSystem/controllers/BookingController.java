package com.codeclan.example.CourseBookingSystem.controllers;

import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookingController {

    @Autowired
    BookingRepository bookingRepository;

    @GetMapping(value= "/bookings")
    public ResponseEntity getAllBookings(
            @RequestParam(required = false,name = "date")String date

            ){
    if (date != null){
        return new ResponseEntity(bookingRepository.getByDate(date),HttpStatus.OK);
    }
        return new ResponseEntity(bookingRepository.findAll(), HttpStatus.OK);

    }
}
