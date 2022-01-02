package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.User;
import DAO.UserDAO;

@WebServlet({"/login","/"})
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public loginServlet() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getSession().getAttribute("user") != null ) {
			if (request.getSession().getAttribute("user") instanceof Admin) {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
				dispatcher.include(request, response);
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Enseignant.jsp");
				dispatcher.include(request, response);				
			}

		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher;

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		UserDAO userDAO = new UserDAO();

		try {

			User user = userDAO.checkLogin(username, password);
			HttpSession session = request.getSession();
			
			if (user != null) {
				session.setAttribute("user", user);
				if (user instanceof Admin) {
					dispatcher = request.getRequestDispatcher("/WEB-INF/admin.jsp");
					dispatcher.forward(request, response);
				}else {
					dispatcher = request.getRequestDispatcher("/WEB-INF/Enseignant.jsp");
					dispatcher.include(request, response);						
				}
				
			} else {
				session.setAttribute("login", username);
				PrintWriter out = response.getWriter();

				dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
				dispatcher.include(request, response);

				out.print("<center><h2 align=\"center\" style =\"font-family:cursive; color:red\"> Incorect user or password !!</h2></center>");
			}

		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
	}

}