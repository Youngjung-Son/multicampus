package model.domain;

public class ClientDTO {
	private String userId;
	private String password1;
	private String koreanLastName;
	private String koreanFirstName;
	private String lastName;
	private String firstName;	
	private String dateOfBirth;
	private String gender;
	private String email;
	private String representPhoneNumber;
	
	
	public ClientDTO(String userId, String password1, String koreanLastName, String koreanFirstName, String lastName,
			String firstName, String dateOfBirth, String gender, String email, String representPhoneNumber) {
		super();
		this.userId = userId;
		this.password1 = password1;
		this.koreanLastName = koreanLastName;
		this.koreanFirstName = koreanFirstName;
		this.lastName = lastName;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.email = email;
		this.representPhoneNumber = representPhoneNumber;
	}
	public ClientDTO() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getKoreanLastName() {
		return koreanLastName;
	}
	public void setKoreanLastName(String koreanLastName) {
		this.koreanLastName = koreanLastName;
	}
	public String getKoreanFirstName() {
		return koreanFirstName;
	}
	public void setKoreanFirstName(String koreanFirstName) {
		this.koreanFirstName = koreanFirstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getRepresentPhoneNumber() {
		return representPhoneNumber;
	}
	public void setRepresentPhoneNumber(String representPhoneNumber) {
		this.representPhoneNumber = representPhoneNumber;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ClientDTO [userId=");
		builder.append(userId);
		builder.append(", password1=");
		builder.append(password1);
		builder.append(", koreanLastName=");
		builder.append(koreanLastName);
		builder.append(", koreanFirstName=");
		builder.append(koreanFirstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", dateOfBirth=");
		builder.append(dateOfBirth);
		builder.append(", gender=");
		builder.append(gender);
		builder.append(", email=");
		builder.append(email);
		builder.append(", representPhoneNumber=");
		builder.append(representPhoneNumber);
		builder.append("]");
		return builder.toString();
	}
	
}	