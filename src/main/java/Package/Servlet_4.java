package Package;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_4 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public Servlet_4() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String admin_user = request.getParameter("admin_user");
		String password = request.getParameter("password");
		
		if(admin_user.equals("Chaitanya_Nath") && password.equals("Charlie@123#"))
		{
			RequestDispatcher rs = request.getRequestDispatcher("Admin_List.jsp");
			rs.forward(request, response);
		}
		else {
			RequestDispatcher rs = request.getRequestDispatcher("Error_Admin.html");
			rs.include(request, response);
		}
	}

}
