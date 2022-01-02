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

@WebServlet("/gesEtudiant")
public class gesEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public gesEtudiantServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if ((request.getSession().getAttribute("user") != null) && (request.getSession().getAttribute("user") instanceof Admin)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/gesEtudiant.jsp");
			dispatcher.include(request, response);
		} else {
			PrintWriter out = response.getWriter();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.include(request, response);
			out.print("<center><h2 align=\"center\" style =\"font-family:cursive; color:red\"> Not admin :( !!</h2></center>");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
