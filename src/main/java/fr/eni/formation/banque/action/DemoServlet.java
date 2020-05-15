package fr.eni.formation.banque.action;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(
		value = "/demo",
		initParams = { @WebInitParam(name = "message", value = "Ma deuxième servlet Java !")}
//		loadOnStartup = 1
)
public class DemoServlet extends HttpServlet {
	
	private static final long serialVersionUID = -7850022916118603482L;

	private String message = "";
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		message = config.getInitParameter("message");
		
		System.out.println("Initialisation de la servlet /demo");
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(request.getRequestURL());
		
		PrintWriter out = response.getWriter(); 

		out.printf("<h2>%s</h2>\n", message);
		
//		out.println("<p>Ma première servlet en Java !");
		out.printf("<p>url : %s\n",request.getRequestURL());
		out.printf("<p>application path : %s\n",request.getContextPath());
		out.printf("<p>servlet path : %s\n",request.getServletPath());
		out.printf("<p>langue : %s\n",request.getHeader("Accept-Language"));
		out.printf("<p>navigateur : %s\n",request.getHeader("User-Agent"));
		
		// --- Cookie ----------------------------------
		
		// Lire dans la requ�te ou cr�er le cookie compteur
		Cookie compteur = Arrays.stream(request.getCookies() != null ? request.getCookies() : new Cookie[0])
			.filter(coo -> coo.getName().equalsIgnoreCase("compteur"))
			.findFirst()
			.orElse(new Cookie("compteur", "0"));
		
		
		// Incr�menter le compteur
		int val = Integer.valueOf(compteur.getValue()) + 1;
		compteur.setValue(String.valueOf(val));
		
		// Envoyer le cookie compteur modifi� dans la r�ponse
		response.addCookie(compteur);
		
		out.printf("<p>compteur (cookie) : %s\n", val);

		// --- Session ----------------------------------
		
		HttpSession session = request.getSession();
//		session.isNew();
//		session.invalidate();
		int cpt = 0;
		if(session.getAttribute("compteur") == null) {
			cpt = ((Integer)session.getAttribute("compteur")) + 1;
		} else {
			cpt = 1;
		}
		session.setAttribute("compteur", cpt);
		out.printf("<p>compteur (session) : %s\n", cpt);
		out.printf("<p>id session : %s\n", session.getId());
		
		if(session.isNew()) out.printf("<p>nouvelle session !!!\n");
		if(cpt > 10) session.invalidate();
		
//		byte      	Byte
//		short		Short
//		int			Integer
//		long		Long
//		float		Float
//		double		Double
//		char		Character
//		boolean		Boolean
//		
//		new Integer(12)
//		new Integer("12");
//		
//		Object[] test = {new Integer(12), 12};
		
		
		response.setContentType("text/html");
	}
	

	@Override
	public void destroy() {
		System.out.println("Arrêt de la servlet /demo");
	}
	
}
