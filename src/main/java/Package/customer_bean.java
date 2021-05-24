package Package;


import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customer_table")
public class customer_bean {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int appointment_id;
	@Column
	private int aadhar_no;
	@Column
	private String user_name;
	@Column
	private Date dob;
	@Column 
	private int age;
	@Column
	private String phone;
	@Column
	private String gender;
	@Column
	private String city;
	@Column
	private String state;
	@Column
	private int zipcode;
	@Column
	private String visit;
	@Column
	private String preferred_doctor;
	@Column
	private String appointment_time;
	@Column
	private String blood_group;
	@Column
	private Date appointment_date;
	public Date getAppointment_date() {
		return appointment_date;
	}
	public void setAppointment_date(Date appointment_date) {
		this.appointment_date = appointment_date;
	}
	public String getBlood_group() {
		return blood_group;
	}
	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}
	public int getAppointment_id() {
		return appointment_id;
	}
	public void setAppointment_id(int appointment_id) {
		this.appointment_id = appointment_id;
	}
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
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getZipcode() {
		return zipcode;
	}
	public void setZipcode(int zipcode) {
		this.zipcode = zipcode;
	}
	public String getVisit() {
		return visit;
	}
	public void setVisit(String visit) {
		this.visit = visit;
	}
	public String getPreferred_doctor() {
		return preferred_doctor;
	}
	public void setPreferred_doctor(String preferred_doctor) {
		this.preferred_doctor = preferred_doctor;
	}
	public String getAppointment_time() {
		return appointment_time;
	}
	public void setAppointment_time(String appointment_time) {
		this.appointment_time = appointment_time;
	}
}
