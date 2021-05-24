package Package;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Servlet_3 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Servlet_3() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email_id = request.getParameter("email_id");
		String password = request.getParameter("password");

		DAO dao = new DAO();
		String s = "";
		s = s + dao.password_search(email_id,password);
		
		if(s.equals(password))
		{
			if(dao.getStatus() == true)
			{
				RequestDispatcher rd = request.getRequestDispatcher("Doctor.jsp");
				rd.forward(request, response);
			}
			else if(dao.getStatus() == false){
				
				String username = dao.user_name(email_id);
				int aadhar_no = dao.aadhar_no(email_id);
				HttpSession hs = request.getSession();
				hs.setAttribute("username", username);
				hs.setAttribute("aadhar_no", String.valueOf(aadhar_no));
				RequestDispatcher rd = request.getRequestDispatcher("Customer.jsp");
				rd.include(request, response);
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("Error_Login.html");
			rd.include(request, response);
		}	
	}
}
