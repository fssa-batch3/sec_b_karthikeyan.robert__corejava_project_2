package in.fssa.knfunding;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.util.List;

import org.junit.jupiter.api.Test;

import in.fssa.knfunding.model.Donation;
import in.fssa.knfunding.model.Request;
import in.fssa.knfunding.service.DonationService;
import in.fssa.knfunding.service.RequestService;

public class TestDonation {
	
	@Test
	public void testCreateDonationwithValidInput() {
		DonationService donationService = new DonationService();

		Donation newDonation = new Donation();
		newDonation.setDonation_id(1);
		newDonation.setRequest_id(2);
		newDonation.setUser_id(68);
		newDonation.setDonor_name("karthikeyan");
		newDonation.setEmail("karthikn352004@gmail.com");
		newDonation.setMobile_no(7010847986l);
		newDonation.setDonation_amount(10000);

		LocalDate donationDate = LocalDate.of(2023, 9, 20);
		newDonation.setDonation_date(donationDate);

		assertDoesNotThrow(() -> {
			donationService.createDonation(newDonation);
		});

	}

	@Test
	public void testCreateDonationWithNegativeAmount() {
	    DonationService donationService = new DonationService();

	    Donation newDonation = new Donation();
	    newDonation.setDonation_id(7);
	    newDonation.setRequest_id(2);
	    newDonation.setUser_id(68);
	    newDonation.setDonor_name("karthikeyan");
	    newDonation.setEmail("karthikn352004@gmail.com");
	    newDonation.setMobile_no(7010847986L);
	    newDonation.setDonation_amount(-10000); // Negative amount

	    LocalDate donationDate = LocalDate.of(2023, 9, 20);
	    newDonation.setDonation_date(donationDate);

	    assertThrows(RuntimeException.class, () -> {
	        donationService.createDonation(newDonation);
	    });
	}
	
	
	 @Test
	    public void testListAllDonationsByUserId() {
	        DonationService donationService = new DonationService();
	 
	        assertDoesNotThrow(() -> {
	        	 List<Donation> allRequests = donationService.getDonationByUserId(68);
	        });

	    }
	 
	 @Test
	    public void testListAllDonationsByRequestId() {
	        DonationService donationService = new DonationService();
	 
	        assertDoesNotThrow(() -> {
	        	 List<Donation> allRequests = donationService.getDonationByRequestId(15);
	        });

	    }



	
}
