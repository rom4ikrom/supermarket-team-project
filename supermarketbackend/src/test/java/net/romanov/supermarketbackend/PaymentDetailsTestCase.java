package net.romanov.supermarketbackend;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.romanov.supermarketbackend.dao.UserDAO;
import net.romanov.supermarketbackend.dto.PaymentDetails;

public class PaymentDetailsTestCase {
	
	private static AnnotationConfigApplicationContext context;
	
	private static UserDAO userDAO;
	
	private PaymentDetails pd;
	
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.romanov.supermarketbackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
	
	@Test
	public void testCRUDpd() throws ParseException {
		
		pd = new PaymentDetails();
		
		pd.setUserId(13);
		pd.setActive(true);
		pd.setCardName("roman");
		pd.setCardNumber("012345678900");
		pd.setCvv("123");
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		
		String dateStr = "01-04-2019";
		
		Date date = formatter.parse(dateStr);
		
		pd.setExpiryDate(date);
		
		assertEquals("Something went wrong while inserting a new payment details!", true, userDAO.addPaymentDetails(pd));
	}

}
