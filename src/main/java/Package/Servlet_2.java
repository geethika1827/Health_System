package Package;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet_2() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int aadhar_no = Integer.parseInt(request.getParameter("aadhar_no"));
		String user_name = request.getParameter("user_name");
		String email_id = request.getParameter("email_id");
		String password = request.getParameter("password");
		String phone_no = request.getParameter("phone_no");
		
		user_bean user = new user_bean();
		user.setAadhar_no(aadhar_no);
		user.setUser_name(user_name);
		user.setEmail_id(email_id);
		user.setPassword(password);
		user.setPhone_no(phone_no);
		
		DAO dao = new DAO();
		if (dao.email_search(email_id)) {
			int i;
			try {
				i = dao.user_insert(user);
				if (i > 0) {
					RequestDispatcher rd = request.getRequestDispatcher("Login.html");
					request.setAttribute("user_bean", user);
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
