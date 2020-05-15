package fr.eni.formation.banque.action;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.eni.formation.banque.dao.BanqueDao;
import fr.eni.formation.banque.model.Client;

@WebServlet("/client/form")
public class ClientFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		ServletContext application = getServletContext();
		
		String nom = request.getParameter("nom");
		String prenom = request.getParameter("prenom");
		
		BanqueDao dao = (BanqueDao) application.getAttribute("dao");
		
		if( "".equals(nom) ) {
			application
				.getRequestDispatcher("/client-form.jsp")
				.forward(request, response);
		} else {
			dao.createClient(new Client(nom, prenom));

			// 302 /javaee-web
			response.sendRedirect(application.getContextPath());
		}
		
	}

}
