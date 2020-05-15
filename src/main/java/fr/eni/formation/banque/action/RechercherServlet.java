package fr.eni.formation.banque.action;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.eni.formation.banque.dao.BanqueDao;

@WebServlet("/rechercher")
public class RechercherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		
		String nom = request.getParameter("nom");
		
		BanqueDao dao = (BanqueDao) application.getAttribute("dao");
		
		session.setAttribute("client", dao.readClientNom(nom));
		
		application
			.getRequestDispatcher("/rechercher.jsp")
			.forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
