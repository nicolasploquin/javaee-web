package fr.eni.formation.banque.action;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.eni.formation.banque.dao.BanqueDao;
import fr.eni.formation.banque.dao.jpa.BanqueJpa;

@WebListener
public class ApplicationListener implements ServletContextListener {

	public void contextInitialized(ServletContextEvent event)  { 
		
		System.out.println("Démarrage de l'application banque !!");
		
		ServletContext application = event.getServletContext();
		
		BanqueDao dao = new BanqueJpa();
		
		application.setAttribute("dao", dao);
		
	}
	
    public void contextDestroyed(ServletContextEvent sce)  { 
    	System.out.println("Arrêt de l'application banque.");
    }

}
