package fr.eni.formation.banque.action;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebFilter(urlPatterns = {"/*","*.css","*.html"})
@WebFilter("/*")
public class LogFilter implements Filter {

	public void init(FilterConfig fConfig) throws ServletException {
	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
		

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;
		
		Date t1 = new Date();
		
		request.setAttribute("nom", "test");
		
		chain.doFilter(request, response);
		
		Date t2 = new Date();
		
		long temps = t2.getTime() - t1.getTime();
		
		System.out.printf("%tDT - %3dms - %s - %d (%s)\n", 
				t2, temps, request.getServletPath(),
				response.getStatus(),
				request.getHeader("User-Agent")
		);
		
	}

	public void destroy() {
	}

}
