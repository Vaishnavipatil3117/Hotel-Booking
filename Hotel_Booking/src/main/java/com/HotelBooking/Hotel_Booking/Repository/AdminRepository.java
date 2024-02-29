package com.HotelBooking.Hotel_Booking.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HotelBooking.Hotel_Booking.Model.CustomerDtls;

@Repository
public interface AdminRepository extends JpaRepository<CustomerDtls, Long> {

}
