package com.HotelBooking.Hotel_Booking.ServiceImpl;


import java.util.List;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelBooking.Hotel_Booking.Model.ContactUs;
import com.HotelBooking.Hotel_Booking.Repository.ContactUsRepo;
import com.HotelBooking.Hotel_Booking.Service.ContactUsService;

@Service
public class ContactUsServiceImpl implements ContactUsService{
	
	@Autowired
	private ContactUsRepo contactRepo;
	@Override
	public ContactUs contactUs(ContactUs contact) {
		// TODO Auto-generated method stub
		return contactRepo.save(contact);
	}
	@Override
	public ContactUs getContactUs(long id) {
		// TODO Auto-generated method stub
		Optional<ContactUs> contact=contactRepo.findById(id);
		return contact.orElse(null);
	}
	@Override
	public List<ContactUs> getAllContact() {
		// TODO Auto-generated method stub
		List<ContactUs> contactus=contactRepo.findAll();
		return contactus;
	}
	@Override
	public void deleteContactById(long id) {
		// TODO Auto-generated method stub
		contactRepo.deleteById(id);
	}

}
