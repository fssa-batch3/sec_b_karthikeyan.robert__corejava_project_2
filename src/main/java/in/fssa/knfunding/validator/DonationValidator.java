package in.fssa.knfunding.validator;

import in.fssa.knfunding.model.Donation;

public class DonationValidator {
	private void validateDonation(Donation donation) {
	    if (donation == null) {
	        throw new IllegalArgumentException("Donation object is null.");
	    }

	    if (donation.getDonation_amount() <= 300) {
	        throw new IllegalArgumentException("Donation amount must be greater than 300.");
	    }

	    if (donation.getDonor_name() == null || donation.getDonor_name().isEmpty()) {
	        throw new IllegalArgumentException("Donor name is required.");
	    }

	    if (donation.getEmail() == null || !isValidEmail(donation.getEmail())) {
	        throw new IllegalArgumentException("Invalid email address.");
	    }

	    if (!isValidMobileNumber(String.valueOf(donation.getMobile_no()))) {
	        throw new IllegalArgumentException("Invalid mobile number.");
	    }
	    
	}

	private boolean isValidEmail(String email) {
	    String emailRegex = "^[A-Za-z0-9+_.-]+@(.+)$";
	    return email.matches(emailRegex);
	}
	private boolean isValidMobileNumber(String mobileNumber) {
	    String mobileRegex = "^[0-9]{10}$"; 
	    return mobileNumber.matches(mobileRegex);
	}

}
