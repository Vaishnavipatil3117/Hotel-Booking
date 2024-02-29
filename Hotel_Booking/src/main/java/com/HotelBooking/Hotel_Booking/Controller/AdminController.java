package com.HotelBooking.Hotel_Booking.Controller;


import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.HotelBooking.Hotel_Booking.Model.BookRoom;
import com.HotelBooking.Hotel_Booking.Model.ContactUs;
import com.HotelBooking.Hotel_Booking.Model.CustomerDtls;
import com.HotelBooking.Hotel_Booking.Service.AdminService;
import com.HotelBooking.Hotel_Booking.Service.BookRoomService;
import com.HotelBooking.Hotel_Booking.Service.ContactUsService;
import com.HotelBooking.Hotel_Booking.Service.CustomerService;


@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminServe;
	
	@Autowired
	private ContactUsService contactServe;
	
	@Autowired
	private CustomerService customerServe;
	
	@Autowired
	private BookRoomService bookRoomService;
	
	
	@GetMapping("/admin")
	public String admin()
	{
		return "admin";
	}
	
	       //customer details
	
	@GetMapping("/customerinfo")
	public ModelAndView getAdminPage() {
	    List<CustomerDtls> customerList = adminServe.getAllCustomer();
	    
	    ModelAndView m = new ModelAndView();
	    m.setViewName("customerinfo");
	    m.addObject("customers", customerList);
	    m.addObject("customerEdit", new CustomerDtls());
	    return m;
	}
	
		@GetMapping("/editBook/{id}")
	    public String editCustomer(@PathVariable long id, Model model) {
			CustomerDtls customer = customerServe.getCustomerById(id);
	        return "customerinfo";
	    }

	   
	    @PostMapping("/update/{id}")
	    public String updateCustomer(@ModelAttribute ("customerEdit") CustomerDtls customer,@PathVariable("id") long id, Model model) {
	    	
	    	System.out.println("hello");
	        CustomerDtls existingCustomer = customerServe.getCustomerById(id);
	        System.out.println(existingCustomer);
	        if(existingCustomer !=null)
	        {
	        	existingCustomer.setName(customer.getName());
	        	existingCustomer.setEmail(customer.getEmail());
	        	existingCustomer.setPhone(customer.getPhone());
	        	existingCustomer.setGender(customer.getGender());
	        	existingCustomer.setAddress(customer.getAddress());
	        	customerServe.createCustomer(existingCustomer);
	        	model.addAttribute("customer",existingCustomer);
	        }
		    
	        return "redirect:/customerinfo";
    }
    
	 @RequestMapping("/delete/{id}")
		public String deleteCustomer(@PathVariable("id") long id)
		{
			 System.out.println("Deleting customer with ID: " + id);
			 adminServe.deleteCustomer(id);
			 return "redirect:/customerinfo";
		}
	 
	 			//booking details
	 
	 @GetMapping("/booked")
	    public ModelAndView getAllBookedRooms() {
	        List<BookRoom> bookedRooms = bookRoomService.getAllBookRooms();
	        ModelAndView m = new ModelAndView();
		    m.setViewName("booked");
	        m.addObject("bookedRooms", bookedRooms);
	        m.addObject("bookEdit",new BookRoom());
	        return m;
	    }
		
		
		 
		 @GetMapping("/editBooking/{id}")
		    public String editBooking(@PathVariable long id, Model model) {
				BookRoom room = bookRoomService.getRoomById(id);
				
		        return "booked";
		    }

		   
		    @PostMapping("/updateBooking/{id}")
		    public String updateCustomer(@ModelAttribute ("bookEdit") BookRoom room,@PathVariable("id") long id, Model model) {
		    	
		    	System.out.println("hello");
		        BookRoom existingRoom = bookRoomService.getRoomById(id);
		        System.out.println(existingRoom);
		        if(existingRoom !=null)
		        {
		        	existingRoom.setCustomer_id(room.getCustomer_id());
		        	existingRoom.setCheckin(room.getCheckin());
		        	existingRoom.setCheckout(room.getCheckout());
		        	existingRoom.setAdults(room.getAdults());
		        	existingRoom.setChildren(room.getChildren());
		        	existingRoom.setPayment(room.getPayment());
		        	bookRoomService.saveBookRoom(existingRoom);
		        	model.addAttribute("bookedRooms",existingRoom);
		        }
			    
		        return "redirect:/booked";
		    }
		 @RequestMapping("/deleteBooking/{id}")
		    public String deleteBooking(@PathVariable long id, Model model) {
				
			 bookRoomService.deleteBookRoom(id);
			 return "redirect:/booked";
		    }
		 
		 			// contact us
		 
		 @GetMapping("/contactus")
			public ModelAndView getContactUs() {
			    List<ContactUs> contact = contactServe.getAllContact();
			    
			    ModelAndView m = new ModelAndView();
			    m.setViewName("contactus");
			    m.addObject("contact", contact);
			    return m;
			}
		 @RequestMapping("/deleteContact/{id}")
		    public String deleteContact(@PathVariable long id, Model model) {
				
			 contactServe.deleteContactById(id);
			 return "redirect:/contactus";
		    }
}