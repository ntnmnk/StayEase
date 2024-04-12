package com.project.stayease.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.project.stayease.DTOs.BookingDTO;
import com.project.stayease.model.Booking;
import com.project.stayease.repository.BookingRepository;

public class BookingService {
    private static final Logger logger = LoggerFactory.getLogger(BookingService.class);

    @Autowired
    private BookingRepository bookingRepository;
    
    @Autowired
    private ModelMapper modelMapper;

    public List<BookingDTO> getAllBookings() {
        logger.info("Fetching all bookings from the database.");
        List<Booking> bookings = bookingRepository.findAll();
        return bookings.stream()
                       .map(booking -> modelMapper.map(booking, BookingDTO.class))
                       .collect(Collectors.toList());
    }


}
