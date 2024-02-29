package com.HotelBooking.Hotel_Booking.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HotelBooking.Hotel_Booking.Model.CustomerDtls;

@Repository
public interface CustomerRepository extends JpaRepository<CustomerDtls, Long>{
	public boolean existsByEmail(String email);
	Optional<CustomerDtls> findByUsername(String email);
	public CustomerDtls findByEmail(String email);
//	public CustomerDtls getCustomerById(long id);
	public CustomerDtls findById(long id);
}
