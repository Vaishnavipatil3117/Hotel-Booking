package com.HotelBooking.Hotel_Booking.ServiceImpl;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelBooking.Hotel_Booking.Model.ContactUs;
import com.HotelBooking.Hotel_Booking.Model.CustomerDtls;
import com.HotelBooking.Hotel_Booking.Repository.CustomerRepository;
import com.HotelBooking.Hotel_Booking.Service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepo;

	@Override
	public CustomerDtls createCustomer(CustomerDtls customer) {
		// TODO Auto-generated method stub
		customer.setRole("USER");
		return customerRepo.save(customer);
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return customerRepo.existsByEmail(email);
	}

	@Override
	public CustomerDtls getCustomerById(long id) {
		// TODO Auto-generated method stub
		
        return customerRepo.findById(id);
	}

	@Override
	public CustomerDtls getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return customerRepo.findByEmail(username);
	}

	@Override
	public List<CustomerDtls> getAllCustomerDetails() {
		// TODO Auto-generated method stub
		return customerRepo.findAll();
	}

	

}
