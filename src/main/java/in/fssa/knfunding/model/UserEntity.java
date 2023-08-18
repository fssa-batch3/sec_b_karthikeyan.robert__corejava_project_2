package in.fssa.knfunding.model;

public abstract class UserEntity implements Comparable<UserEntity> {
	private int id;
	private String fullName;
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	private String email;
	private String password;
	private long phone_Number;
	private boolean isActive = true;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return fullName;
	}

	public void setFirstName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	

	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", Name=" + fullName + ", email=" + email
				+ ", password=" + password + ", isActive=" + isActive + ",phone_Number=" + phone_Number + "]";
	}

	@Override
	public int compareTo(UserEntity userEmail) {
		return this.getEmail().compareTo(userEmail.getEmail());
	}

	public long getPhoneNumber() {
		return phone_Number;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phone_Number = phoneNumber;
	}

}
