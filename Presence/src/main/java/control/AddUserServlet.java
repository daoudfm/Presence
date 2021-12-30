package control;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Admin;
import model.Enseignant;
import model.User;
import DAO.UserDAO;
import java.util.Date;

@WebServlet("/Add")
public class AddUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public AddUserServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		if ((request.getSession().getAttribute("user") != null) && (request.getSession().getAttribute("user") instanceof Admin)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/add.jsp");
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
		
		String n = request.getParameter("fname");
		String p=request.getParameter("lname");
		String m=request.getParameter("password") ;
		String em=request.getParameter("email");
		int t=Integer.parseInt(request.getParameter("telephone"));
		String a=request.getParameter("adress");
		Date dn= java.sql.Date.valueOf(request.getParameter("dateNaissance"));

		try {
			System.out.println(dn);
			if(request.getParameter("type").equals("Enseignant")) {
				
				User user = new Enseignant(n,p,m,em,dn,t,a,"x"); 
				userDAO.addUser(user);
				PrintWriter out = response.getWriter();
				dispatcher = request.getRequestDispatcher("/WEB-INF/add.jsp");
				dispatcher.include(request, response);
				out.print("<center><h2> Add Enseignant salha :D <h2>");
			}else {
				if(request.getParameter("type").equals("Etudiant")) {
					User user = new User(n,p,m,em,dn,t,a,"x");  // mnba3t twali Etudiant kinzidoha fel bd
					userDAO.addUser(user);
					PrintWriter out = response.getWriter();

					dispatcher = request.getRequestDispatcher("/WEB-INF/add.jsp");
					dispatcher.include(request, response);
					out.print("<center><h2> Add Etudiant salha :D <h2>");
					}
			}
		} catch (InstantiationException | IllegalAccessException | NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
