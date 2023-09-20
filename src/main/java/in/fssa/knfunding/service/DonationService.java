package in.fssa.knfunding.service;



import in.fssa.knfunding.model.Donation;
import in.fssa.knfunding.dao.DonationDAO;

public class DonationService {
    private DonationDAO donationDao;
    
    public DonationService() {
        donationDao = new DonationDAO();
    }
    
    public void createDonation(Donation newDonation) {
        try {
            // Validate mobile number
            if (!isValidMobileNumber(newDonation.getMobile_no())) {
                throw new IllegalArgumentException("Invalid mobile number.");
            }

            // Check if the donation amount is negative
            if (newDonation.getDonation_amount() < 0) {
                throw new IllegalArgumentException("Donation amount must be non-negative.");
            }

            // Assuming donationDao and requestDao are properly defined
            donationDao.create(newDonation);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while creating donation", e);
        }
    }


    private boolean isValidMobileNumber(long mobileNumber) {
        // Implement your mobile number validation logic here
        // You can use regular expressions or other checks to validate the format
        // Return true if valid, false otherwise
        return mobileNumber >= 1000000000L && mobileNumber <= 9999999999L; // Example format (10 digits)
    }
    

    

	private void validateDonation(Donation donation) {
		// TODO Auto-generated method stub
		
	}




}
