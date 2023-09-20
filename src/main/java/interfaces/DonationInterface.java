package interfaces;

import java.util.List;

import in.fssa.knfunding.model.Donation;

public  interface DonationInterface {
	
	  List<Donation> findAllDonors();
	    
	    List<Donation> findByUserId();

	   List <Donation> findByRequestId(int id);

	    void create(Donation newDonation);

	    

}
