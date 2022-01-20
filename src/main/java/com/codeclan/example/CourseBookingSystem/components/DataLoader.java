package com.codeclan.example.CourseBookingSystem.components;

import com.codeclan.example.CourseBookingSystem.models.Booking;
import com.codeclan.example.CourseBookingSystem.models.Course;
import com.codeclan.example.CourseBookingSystem.models.Customer;
import com.codeclan.example.CourseBookingSystem.repositories.BookingRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CourseRepository;
import com.codeclan.example.CourseBookingSystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CustomerRepository customerRepository;


    public DataLoader() {
    }

    public void run(ApplicationArguments args){
        Course course1 = new Course("PSD","Edinburgh",8);
        courseRepository.save(course1);

        Course course2 = new Course("DAT","Edinburgh",6);
        courseRepository.save(course2);

        Course course3 = new Course("Web","Glasgow",5);
        courseRepository.save(course3);


        Customer customer1 = new Customer("iain","Falkirk", 39);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("olly","Edinburgh",25);
        customerRepository.save(customer2);


        Customer customer3 = new Customer("craig","Livingston",25);
        customerRepository.save(customer3);
//
//        List<Customer> customers1;
//        List<Customer> customers2;
//
//        customers1.add(customer2);
//
//        customers2.add(customer3);




        Booking booking1 = new Booking("09/05/2021", course1,customer1);
        bookingRepository.save(booking1);


        Booking booking2 = new Booking("12/02/2021", course1, customer2);
        bookingRepository.save(booking2);


        Booking booking3 = new Booking("10/04/2021", course2,customer3);
        bookingRepository.save(booking3);


    }
}
