package Package;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Servlet_5 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private int i;
	private Date date_check;
       

    public Servlet_5() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		Date date = null;
		date_check = null;
		
		int aadhar_no = Integer.parseInt(request.getParameter("aadhar_no"));
		String user_name = request.getParameter("user_name");
		String dob = request.getParameter("date_of_birth");
		int age = Integer.parseInt(request.getParameter("age"));
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		int zipcode = Integer.parseInt(request.getParameter("zipcode"));
		String visit = request.getParameter("visit");
		String preferred_doctor = request.getParameter("doctors");
		String appointment_time = request.getParameter("appointment_time");
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
		String blood_group = request.getParameter("blood_group");
		String check_date = request.getParameter("appointment_date");
		
		try {
			date = sdf.parse(dob);
			date_check = sdf.parse(check_date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		customer_bean customer = new customer_bean();
		
		customer.setAadhar_no(aadhar_no);
		customer.setUser_name(user_name);
		customer.setDob(date);
		customer.setAge(age);
		customer.setPhone(phone);
		customer.setGender(gender);
		customer.setCity(city);
		customer.setState(state);
		customer.setZipcode(zipcode);
		customer.setVisit(visit);
		customer.setPreferred_doctor(preferred_doctor);
		customer.setAppointment_time(appointment_time);
		customer.setBlood_group(blood_group);
		customer.setAppointment_date(date_check);
		
		DAO dao = new DAO();
		try {
			i = dao.customer_insert(customer);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (i > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("HomePage.html");
			request.setAttribute("customer_bean", customer);
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("Error_Appointment.html");
			rd.include(request, response);
		}
	}

}
