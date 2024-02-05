package Servlet.devoir;

import java.io.IOException;

import CLS.devoir.Enseignant;
import Resource.devoir.EnseignantResource;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpFilter;

public class FiltreLogin extends HttpFilter implements Filter {

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) 
	throws IOException, ServletException {
       
		String name = request.getParameter("username"); 
		String pass   = request.getParameter("password"); 
		String post = request.getParameter("userPost");
		
		if (name.equals(Resource.devoir.AdminResource.admin.get(1).name) && pass.equals(Resource.devoir.AdminResource.admin.get(1).password) && post.equals("Admin")) {
			chain.doFilter(request, response);
		}else if (post.equals("Directeur")) {
			boolean exist = false;
			for(CLS.devoir.Directeur directeur : Resource.devoir.DirecteurResource.directeur.values() ) {
				if (directeur.password.equals(pass)) {
					exist = true;
				}
			}
			if (exist) {
				chain.doFilter(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("index.html");  
				rd.include(request, response);
			}
		}else if (post.equals("ES")) {
			boolean exist = false;
			for(Enseignant teacher : EnseignantResource.listTeacher.values() ) {
				if (teacher.password.equals(pass)) {
					exist = true;
				}
			}
			if (exist) {
				chain.doFilter(request, response);
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("index.html");  
				rd.include(request, response);
			}
		}
		else {
			RequestDispatcher rd = request.getRequestDispatcher("index.html");  
			rd.include(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}


}
