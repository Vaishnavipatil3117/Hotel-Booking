package com.HotelBooking.Hotel_Booking.Service;

import java.util.List;

import com.HotelBooking.Hotel_Booking.Model.CustomerDtls;

public interface CustomerService {
	public CustomerDtls createCustomer(CustomerDtls customer);
	public boolean checkEmail(String email);
	public CustomerDtls getCustomerById(long id);
	public CustomerDtls getCustomerByUsername(String username);
	List<CustomerDtls> getAllCustomerDetails();
	
}
