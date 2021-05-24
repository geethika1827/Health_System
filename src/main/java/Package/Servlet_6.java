package Package;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Servlet_6 extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Servlet_6() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id = Integer.parseInt(request.getParameter("id"));
		
		DAO dao = new DAO();
		
		
		int i = dao.delete_appointment(id);
		if(i > 0)
		{
			RequestDispatcher rd=request.getRequestDispatcher("Doctor.jsp");
			rd.include(request, response);
		}
		else
		{
			RequestDispatcher rd = request.getRequestDispatcher("HomePage.html");
			rd.include(request, response);
		}
	}

}
