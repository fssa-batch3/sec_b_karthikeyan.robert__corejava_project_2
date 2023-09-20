package in.fssa.knfunding.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;

import in.fssa.knfunding.model.Donation;
import in.fssa.knfunding.util.ConnectionUtil;

public class DonationDAO {
	/**
	 * 
	 * @param newDonation
	 */
	public void create(Donation newDonation) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    

	    try {
	        String query = "INSERT INTO donates (donate_id, request_id, user_id, donation_amount, donor_name, email, mobile_no, donation_date ) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
	        conn = ConnectionUtil.getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, newDonation.getDonation_id());
	        ps.setInt(2, newDonation.getRequest_id());
	        ps.setInt(3, newDonation.getUser_id());
	        ps.setInt(4, newDonation.getDonation_amount());
	        ps.setString(5, newDonation.getDonor_name());
	        ps.setString(6, newDonation.getEmail());
	        ps.setLong(7, newDonation.getMobile_no());
	        
	        LocalDate localDate = newDonation.getDonation_date();
	        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
	        
	        ps.setDate(8, sqlDate);
	       
	        ps.executeUpdate();

	        System.out.println("Donated successfully");

	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error while creating request: " + e.getMessage());
	        throw new RuntimeException();
	    } finally {
	        ConnectionUtil.close(conn, ps);
	    }
	}


}
