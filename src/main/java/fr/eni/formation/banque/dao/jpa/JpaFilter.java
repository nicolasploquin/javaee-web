package fr.eni.formation.banque.dao.jpa;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 * Servlet Filter implementation class JpaFilter
 */
@WebFilter(
		dispatcherTypes = {DispatcherType.REQUEST },
		urlPatterns = { "/*" }
)
public class JpaFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	
		EntityManager em = JpaUtil.getEntityManager();

		chain.doFilter(request, response);
		
		em.close();
		
	}

	public void init(FilterConfig config) throws ServletException {
	}
	
	public void destroy() {
		JpaUtil.getEntityManager().getEntityManagerFactory().close();
	}

}
