package com.HotelBooking.Hotel_Booking.ServiceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.HotelBooking.Hotel_Booking.Model.BookRoom;
import com.HotelBooking.Hotel_Booking.Repository.BookRoomRepo;
import com.HotelBooking.Hotel_Booking.Service.BookRoomService;

@Service
public class BookRoomServiceImpl implements BookRoomService {
	
	@Autowired
	private BookRoomRepo bookRoomRepo;

	@Override
	public BookRoom saveBookRoom(BookRoom bookRoom) {
		// TODO Auto-generated method stub
		return bookRoomRepo.save(bookRoom);
	}

	@Override
	public List<BookRoom> getAllBookRooms() {
		// TODO Auto-generated method stub
		return bookRoomRepo.findAll();
	}

	@Override
	public BookRoom getRoomById(long id) {
		// TODO Auto-generated method stub
		
		return bookRoomRepo.findById(id).get();
	}

	@Override
	public void deleteBookRoom(long id) {
		// TODO Auto-generated method stub
		bookRoomRepo.deleteById(id);
	}



}
