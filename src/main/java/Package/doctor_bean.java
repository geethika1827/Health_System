package Package;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table (name = "doctor_table")
public class doctor_bean {

	@Id
	private int license_no;
	@Column
	private String doctor_name;
	@Column
	private String email_id;
	@Column
	private String password;
	@Column
	private String phone_no;
	
	public int getLicense_no() {
		return license_no;
	}
	public void setLicense_no(int license_no) {
		this.license_no = license_no;
	}
	public String getDoctor_name() {
		return doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		this.doctor_name = doctor_name;
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
