package control;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EtudiantDAO;
import model.Admin;
import model.Etudiant;

@WebServlet("/listeEtudinat")
public class listeEtudinatServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public listeEtudinatServlet() {
        super();

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		if (request.getSession().getAttribute("user") != null&& (request.getSession().getAttribute("user") instanceof Admin)) {
			
			EtudiantDAO etudDAO = new EtudiantDAO();
			
			ArrayList<Etudiant> etudList= null;
			System.out.println("ok");
			
			try {
				
				etudList = etudDAO.getEtudiants();
				
			} catch (InstantiationException | IllegalAccessException e) {
				
				e.printStackTrace();
			}
			
			request.setAttribute("etudList",etudList);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/listeEtudinat.jsp");
			dispatcher.include(request, response);
			
		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.include(request, response);
		}
				
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
