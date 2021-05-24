package Package;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "user_table")
public class user_bean {

	@Id
	private int aadhar_no;
	@Column
	private String user_name;
	@Column
	private String email_id;
	@Column
	private String password;
	@Column
	private String phone_no;
	public int getAadhar_no() {
		return aadhar_no;
	}
	public void setAadhar_no(int aadhar_no) {
		this.aadhar_no = aadhar_no;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}
	public String pass() {
		return password;
	}
}
