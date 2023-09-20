package in.fssa.knfunding;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import in.fssa.knfunding.model.Donation;
import in.fssa.knfunding.service.DonationService;

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
    public void testCreateDonationWithInvalidMobileNumber() {
        DonationService donationService = new DonationService();

        Donation newDonation = new Donation();
        newDonation.setDonation_id(5);
        newDonation.setRequest_id(2);
        newDonation.setUser_id(68);
        newDonation.setDonor_name("karthikeyan");
        newDonation.setEmail("karthikn352004@gmail.com");
        newDonation.setMobile_no(12345L); // Invalid mobile number
	    newDonation.setDonation_amount(2000);

        LocalDate donationDate = LocalDate.of(2023, 9, 20);
        newDonation.setDonation_date(donationDate);

        assertThrows(RuntimeException.class, () -> {
            donationService.createDonation(newDonation);
        });
    }

	
}
