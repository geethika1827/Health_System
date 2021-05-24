package Package;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet_1() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int license_no = Integer.parseInt(request.getParameter("license_no"));
		String doctor_name = request.getParameter("doctor_name");
		String email_id = request.getParameter("email_id");
		String password = request.getParameter("password");
		String phone_no = request.getParameter("phone_no");

		doctor_bean db = new doctor_bean();
		db.setLicense_no(license_no);
		db.setDoctor_name(doctor_name);
		db.setEmail_id(email_id);
		db.setPassword(password);
		db.setPhone_no(phone_no);

		DAO dao = new DAO();
		if (dao.email_search(email_id)) {
			int i;
			try {
				i = dao.doc_insert(db);
				if (i > 0) {
					RequestDispatcher rd = request.getRequestDispatcher("Login.html");
					request.setAttribute("doctor_bean", db);
					rd.forward(request, response);
				} else {
					RequestDispatcher rd = request.getRequestDispatcher("HomePage.html");
					rd.include(request, response);
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("Error_Email.html");
			rd.include(request, response);
		}

	}

}
