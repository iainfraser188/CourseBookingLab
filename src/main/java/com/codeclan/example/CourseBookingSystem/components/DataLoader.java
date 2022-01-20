package com.codeclan.example.CourseBookingSystem.components;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;


    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        Course course1 = new Course("PSD","Edinburgh",8);
        courseRepository.save(course1);

        Course course2 = new Course("DAT","Edinburgh",6);
        courseRepository.save(course2);

        Course course3 = new Course("Web","Glasgow",5);
        courseRepository.save(course3);

        Booking booking1 = new Booking("09/05/2021", course1);
        bookingRepository.save(booking1);


        Booking booking2 = new Booking("12/02/2021", course1);
        bookingRepository.save(booking2);


        Booking booking3 = new Booking("10/04/2021", course1);
        bookingRepository.save(booking3);
    }
}
