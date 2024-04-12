package com.project.stayease.controller;

import com.project.stayease.DTOs.BookingDTO;
import com.project.stayease.service.BookingService;
import java.util.List;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookings")
public class BookingController {

  private static final Logger logger = LoggerFactory.getLogger(BookingController.class);

  @Autowired
  private BookingService bookingService;

  @Autowired
  private ModelMapper modelMapper;

  @GetMapping
  public ResponseEntity<List<BookingDTO>> getAllBookings() {
    logger.info("Fetching all bookings.");
    List<BookingDTO> bookings = bookingService.getAllBookings();
    return ResponseEntity.ok(bookings);
  }
}
