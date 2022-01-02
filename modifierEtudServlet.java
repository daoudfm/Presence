package control;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.EtudiantDAO;
import model.Admin;
import model.Etudiant;

@WebServlet("/modifier")
public class modifierEtudServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public modifierEtudServlet() {
        super();
 
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		if ((request.getSession().getAttribute("user") != null) && (request.getSession().getAttribute("user") instanceof Admin)) {
			EtudiantDAO E = new EtudiantDAO();
			System.out.println("matt="+request.getParameter("x"));
			int m=Integer.parseInt(request.getParameter("x")); 
			System.out.println("matt"+m);
			try {
				Etudiant etud = E.etudInfo(m);
				request.setAttribute("etud", etud);
				E.deleteEtud(etud);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/modifierEtud.jsp");
				dispatcher.include(request, response);
			} catch (InstantiationException | IllegalAccessException e) {
				System.out.println("E");
				e.printStackTrace();
			}

		} else {
			PrintWriter out = response.getWriter();
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/login.jsp");
			dispatcher.include(request, response);
			out.print("<center><h2 align=\"center\" style =\"font-family:cursive; color:red\"> Not admin :( !!</h2></center>");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher;
		EtudiantDAO etudDAO = new EtudiantDAO();
		
		int mat=Integer.parseInt(request.getParameter("matricule"));
		String n= request.getParameter("fname");
		String p=request.getParameter("lname");
		String e=request.getParameter("email");
		Date dn=java.sql.Date.valueOf(request.getParameter("dateNaissance"));
		int t=Integer.parseInt(request.getParameter("telephone"));
		String a=request.getParameter("adress");
		String s=request.getParameter("sexe");
		int nb=Integer.parseInt(request.getParameter("numBac"));
		int ab=Integer.parseInt(request.getParameter("anneeBac"));
		int gr=Integer.parseInt(request.getParameter("groupe"));


			try {
				PrintWriter out = response.getWriter();
				Etudiant etud = new Etudiant(mat,n,p,e,dn,t,a,s,nb,ab,gr);
				etudDAO.addEtudiant(etud);

				request.setAttribute("etud",etud);
				dispatcher = request.getRequestDispatcher("/WEB-INF/etudiantInfo.jsp");
				dispatcher.include(request, response);
				out.print("<center><h2 align=\"center\" style =\"font-family:cursive; color:green\"> l'Etudiant "+n+" "+p+" modifier </h2></center>");
				
				
			} catch (InstantiationException | IllegalAccessException e1) {
				e1.printStackTrace();
			}
	}

}
