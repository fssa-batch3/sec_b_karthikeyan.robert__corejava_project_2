package in.fssa.knfunding.model;

import java.time.LocalDate;

public class Donation {

	private int donation_id;
	private int request_id;
	private int user_id;
	private String donor_name;
	private String email;
	private int donation_amount;
	private long mobile_no;
	LocalDate donation_date = LocalDate.now();
	
	
	
	public int getDonation_id() {
		return donation_id;
	}
	public void setDonation_id(int donation_id) {
		this.donation_id = donation_id;
	}
	public int getRequest_id() {
		return request_id;
	}
	public void setRequest_id(int request_id) {
		this.request_id = request_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getDonor_name() {
		return donor_name;
	}
	public void setDonor_name(String donor_name) {
		this.donor_name = donor_name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getDonation_amount() {
		return donation_amount;
	}
	public void setDonation_amount(int donation_amount) {
		this.donation_amount = donation_amount;
	}
	public long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(long mobile_no) {
		this.mobile_no = mobile_no;
	}
	public LocalDate getDonation_date() {
		return donation_date;
	}
	public void setDonation_date(LocalDate donation_date) {
		this.donation_date = donation_date;
	}
	
	
}
