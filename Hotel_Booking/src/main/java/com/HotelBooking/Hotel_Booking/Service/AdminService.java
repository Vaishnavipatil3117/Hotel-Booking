package com.HotelBooking.Hotel_Booking.Service;

import java.util.List;

import com.HotelBooking.Hotel_Booking.Model.CustomerDtls;

public interface AdminService {
	List<CustomerDtls> getAllCustomer();
	void deleteCustomer(long id);
	CustomerDtls getCustomerById(long id);
	CustomerDtls updateCustomer(CustomerDtls customer);
}
