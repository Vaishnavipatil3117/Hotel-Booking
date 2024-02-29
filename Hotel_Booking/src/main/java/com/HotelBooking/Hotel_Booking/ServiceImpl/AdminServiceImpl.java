package com.HotelBooking.Hotel_Booking.ServiceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelBooking.Hotel_Booking.Model.CustomerDtls;
import com.HotelBooking.Hotel_Booking.Repository.AdminRepository;
import com.HotelBooking.Hotel_Booking.Service.AdminService;

@Service
public class AdminServiceImpl implements AdminService {
	
	@Autowired
	private AdminRepository adminrepo;
	
	@Override
	public List<CustomerDtls> getAllCustomer() {
		// TODO Auto-generated method stub
		List<CustomerDtls> customer=adminrepo.findAll();
		return customer;
	}
	
	@Override
	public CustomerDtls getCustomerById(long id) {
		// TODO Auto-generated method stub
		return adminrepo.findById(id).get();
		
	}
	
	@Override
	public CustomerDtls updateCustomer(CustomerDtls customer) {
		// TODO Auto-generated method stub
		return adminrepo.save(customer);
	}

	@Override
	public void deleteCustomer(long id) {
		// TODO Auto-generated method stub
		adminrepo.deleteById(id);
	}
}
