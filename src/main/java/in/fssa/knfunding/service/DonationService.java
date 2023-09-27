package in.fssa.knfunding.service;



import in.fssa.knfunding.model.Donation;
import in.fssa.knfunding.model.Request;

import java.util.List;

import in.fssa.knfunding.dao.DonationDAO;

public class DonationService {
    private DonationDAO donationDao;
    
    public DonationService() {
        donationDao = new DonationDAO();
    }
    /**
     * 
     * @param newDonation
     */
    public void createDonation(Donation newDonation) {
        try {
            // Validate mobile number
            if (!isValidMobileNumber(newDonation.getMobile_no())) {
                throw new RuntimeException("Invalid mobile number.");
            }

            // Check if the donation amount is negative
            if (newDonation.getDonation_amount() < 0) {
                throw new RuntimeException("Donation amount must be non-negative.");
            }

            // Assuming donationDao and requestDao are properly defined
            donationDao.create(newDonation);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error while creating donation", e);
        }
    }

    /**
     * 
     * @param mobileNumber
     * @return
     */
    private boolean isValidMobileNumber(long mobileNumber) {
        // Implement your mobile number validation logic here
        // You can use regular expressions or other checks to validate the format
        // Return true if valid, false otherwise
        return mobileNumber >= 0000000000L && mobileNumber <= 9999999999L; // Example format (10 digits)
    }
    

    
/**
 * 
 * @param donation
 */
	private void validateDonation(Donation donation) {
		// TODO Auto-generated method stub
		
	}
	
	/**
	 * 
	 * @param userId
	 * @return
	 */
	
	public List<Donation> getDonationByUserId(int userId) {
        try {
            return donationDao.findByUserId(userId); 
        } catch (Exception e) {
            
            e.printStackTrace();
            throw new RuntimeException("Error while getting requests by User ID: " + e.getMessage());
        }
    }
	
	
	public List<Donation> getDonationByRequestId(int requestId) {
        try {
            return donationDao.findDonationsByRequestId(requestId); 
        } catch (Exception e) {
            
            e.printStackTrace();
            throw new RuntimeException("Error while getting requests by User ID: " + e.getMessage());
        }
    }
	
	
	
	




}
