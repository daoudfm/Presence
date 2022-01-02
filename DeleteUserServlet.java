package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UserDAO;
import model.Admin;
import model.User;


@WebServlet("/Delete")
public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		if ((request.getSession().getAttribute("user") != null) && (request.getSession().getAttribute("user") instanceof Admin)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/delete.jsp");
			dispatcher.include(request, response);
		} else {
			PrintWriter out = response.getWriter();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.include(request, response);
			out.print("<center><h2> Not admin :( !!<h2>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher;
		UserDAO userDAO = new UserDAO();
		User user=new User();
		user.setEmail(request.getParameter("email"));
		try {
			userDAO.deleteUser(user);
			PrintWriter out = response.getWriter();
			dispatcher = request.getRequestDispatcher("/WEB-INF/welcome.jsp");
			dispatcher.include(request, response);
			out.print("<center><h2> Delete user salha :D <h2>");
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	
	}

}
