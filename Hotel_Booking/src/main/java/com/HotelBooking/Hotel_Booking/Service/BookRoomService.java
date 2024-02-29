package com.HotelBooking.Hotel_Booking.Service;

import java.util.List;


import com.HotelBooking.Hotel_Booking.Model.BookRoom;

public interface BookRoomService {
	BookRoom saveBookRoom(BookRoom bookRoom);
    List<BookRoom> getAllBookRooms();
    BookRoom getRoomById(long id);
    void deleteBookRoom(long id);
}
