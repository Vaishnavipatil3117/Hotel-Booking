package com.HotelBooking.Hotel_Booking.Controller;

import java.util.Collections;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.HotelBooking.Hotel_Booking.Model.BookRoom;
import com.HotelBooking.Hotel_Booking.Model.ContactUs;
import com.HotelBooking.Hotel_Booking.Model.CustomerDtls;
import com.HotelBooking.Hotel_Booking.Service.AdminService;
import com.HotelBooking.Hotel_Booking.Service.BookRoomService;
import com.HotelBooking.Hotel_Booking.Service.ContactUsService;
import com.HotelBooking.Hotel_Booking.Service.CustomerService;

import jakarta.servlet.http.HttpSession;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private ContactUsService contactServe;
    
    
    @Autowired
	private BookRoomService bookRoomService;
    
    @Autowired
	private AdminService adminServe;
    
    @GetMapping("/")
	    public String index() {
	        return "index";
	    }
    
    @GetMapping("/customer/{id}")
	    public String customer(@PathVariable("id") long id, Model model) {
	    	CustomerDtls customer = customerService.getCustomerById(id);
	    	model.addAttribute("customer", customer);
	        return "customer/customer";
	    }

  				//SIGNUP LOGIC//
    
    @PostMapping("/create_customer")
	    public String createCustomer(@ModelAttribute CustomerDtls customer) {
	    	customer.setUsername(customer.getEmail());
	        boolean f = customerService.checkEmail(customer.getEmail());
	
	        if (f) {
	           System.out.println("already exists");
	        } else {
	            CustomerDtls c = customerService.createCustomer(customer);
	            if (c != null) {
	            	System.out.println("registration successful");
	                return "redirect:/";
	            } else {
	            	System.out.println("server pb");
	            }
	        }
	        return "redirect:error";
	    }
    
    				//SIGNIN LOGIC//
    @PostMapping("/customer")
		 public String redirectAfterLogin(Model model,@RequestParam String username,@RequestParam String password) {
			 CustomerDtls customer= customerService.getCustomerByUsername(username);
		     long customerId = determineCustomerId(username, password);
		     model.addAttribute("customerId", customerId);
		     return "redirect:/customer/" + customerId;
		 }
	
		 private long determineCustomerId(String username, String password) {
		     CustomerDtls c = customerService.getCustomerByUsername(username);
	
		     if (c != null&&c.getPassword().equals(password)) {
		         return c.getId();
		     } else {
		         throw new IllegalStateException("Invalid credentials");
		     }
		 }
	 
                          //contact us
	 
	 @PostMapping("/contactus")
	    public String contactUsInfo(@ModelAttribute ContactUs contact) {
		 
		 	ContactUs c = contactServe.contactUs(contact);   
	        return "redirect:/";
	    }
	 
	                //booking
	 
	 @GetMapping("/booking")
		 public String book()
		 {
			 return "booking";
		 }
	 @PostMapping("/saveBookRoom")
	    public String saveBookRoom(@ModelAttribute BookRoom bookRoom) {
	        bookRoomService.saveBookRoom(bookRoom);
	        return "customer/customer";
	    }
	 


}
