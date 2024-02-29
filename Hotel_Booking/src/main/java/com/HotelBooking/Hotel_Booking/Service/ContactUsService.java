package com.HotelBooking.Hotel_Booking.Service;

import java.util.List;

import com.HotelBooking.Hotel_Booking.Model.ContactUs;

public interface ContactUsService {
	public ContactUs contactUs(ContactUs contact);
	public ContactUs getContactUs(long id);
	List<ContactUs> getAllContact();
	void deleteContactById(long id);
}
