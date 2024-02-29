package com.HotelBooking.Hotel_Booking.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class BookRoom {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
	private long customer_id;
    private String checkin;
    private String checkout;
    private String adults;
    private String children;
    private String payment;
}
