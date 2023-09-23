package in.fssa.knfunding.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.google.protobuf.Timestamp;

import in.fssa.knfunding.model.Donation;
import in.fssa.knfunding.model.Request;
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
	        String query = "INSERT INTO donates ( request_id, user_id, donation_amount, donor_name, email, mobile_no, donation_date ) VALUES ( ?, ?, ?, ?, ?, ?, ?)";
	        conn = ConnectionUtil.getConnection();
	        ps = conn.prepareStatement(query);
	       
	        ps.setInt(1, newDonation.getRequest_id());
	        ps.setInt(2, newDonation.getUser_id());
	        ps.setInt(3, newDonation.getDonation_amount());
	        ps.setString(4, newDonation.getDonor_name());
	        ps.setString(5, newDonation.getEmail());
	        ps.setLong(6, newDonation.getMobile_no());
	        
	        LocalDate localDate = newDonation.getDonation_date();
	        java.sql.Date sqlDate = java.sql.Date.valueOf(localDate);
	        
	        ps.setDate(7, sqlDate);
	       
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

/**
 * 
 * @param userId
 * @return
 */
	public List<Donation> findByUserId(int userId) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    List<Donation> donations = new ArrayList<>();

	    try {
	    	String query = "SELECT d.donate_id, d.donation_amount, d.donor_name, d.request_id, d.donation_date, r.title " +
	                "FROM donates d " +
	                "INNER JOIN requests r ON d.request_id = r.id " +
	                "WHERE d.user_id = ?";
	        


	        conn = ConnectionUtil.getConnection();
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, userId);

	        ResultSet rs = ps.executeQuery();

	        while (rs.next()) {
	            Donation donation = new Donation();
	            donation.setUser_id(rs.getInt("donate_id"));
	            donation.setDonation_amount(rs.getInt("donation_amount"));
	            donation.setDonor_name(rs.getString("donor_name"));
	            donation.setRequest_id(rs.getInt("request_id"));
	            Date donationDate = rs.getDate("donation_date");
	            donation.setDonation_date(donationDate.toLocalDate());
	            donation.setRequestTitle(rs.getString("title"));

	            donations.add(donation);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        System.out.println("Error while retrieving donations by User ID: " + e.getMessage());
	        throw new RuntimeException(e);
	    } finally {
	        ConnectionUtil.close(conn, ps);
	    }

	    return donations;
	}
	
	
	
	public List<Donation> findDonationsByRequestId(int requestId) {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    List<Donation> donationsByRequestId = new ArrayList<>();

	    try {
	        conn = ConnectionUtil.getConnection();
	        String query = "SELECT * FROM donates WHERE request_id = ? ";
	        ps = conn.prepareStatement(query);
	        ps.setInt(1, requestId);
	        rs = ps.executeQuery();

	        while (rs.next()) {
	            Donation donation = new Donation();
	            donation.setDonation_amount(rs.getInt("donation_amount"));
	            donationsByRequestId.add(donation);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Error while retrieving requests by category ID", e);
	    } finally {
	        ConnectionUtil.close(conn, ps, rs);
	    }

	    return donationsByRequestId;
	}


}


