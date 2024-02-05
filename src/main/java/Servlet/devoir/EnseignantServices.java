package Servlet.devoir;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EnseignantServices extends HttpServlet{
	
	
	
	public void service (HttpServletRequest req,HttpServletResponse rep) 
			throws ServerException , IOException
	{	
		
		rep.setContentType("text/html");
		PrintWriter out = rep.getWriter();
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<nav class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n"
				+ "  <div class=\"container-fluid\">\r\n"
				+ " <img src=\"img/logo-iscae.png\" style=\" width:100px;  \" > "
				+ "    <a class=\"navbar-brand\" href=\"#\">Enseignant</a>\r\n"
				+ "    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
				+ "      <span class=\"navbar-toggler-icon\"></span>\r\n"
				+ "    </button>\r\n"
				+ "    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
				+ "      <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n"
				+ "        <li class=\"nav-item\">\r\n"
				+ "          <a class=\"nav-link active\" aria-current=\"page\" href=\"#\">Home</a>\r\n"
				+ "        </li>\r\n"
				+ "      </ul>\r\n"
				+ "  </div>\r\n"
				+ "</nav>\r\n");
	
	//***List des Cours : 
		out.println("<h2 class=text-center>Liste des Cours</h2><table class=\"table\">\r\n"
							+ "  <thead>\r\n"
							+ "    <tr>\r\n"
							+ "      <th scope=\"col\">id</th>\r\n"
							+ "      <th scope=\"col\">NOM</th>\r\n"
							+ "      <th scope=\"col\">Jours</th>\r\n"
							+ "      <th scope=\"col\">Creneau</th>\r\n"
							+ "      <th scope=\"col\">Nom Enseignant</th>\r\n"
							+ "    </tr>\r\n"
							+ "  </thead>\r\n"
								+ "  <tbody>\r\n");
						
						for(CLS.devoir.Cours cours : Resource.devoir.CoursResource.listCours.values()) {
						
								out.println("<tr><th scope=\"row\">"+ cours.id +"</th>\r\n"
								+ "      <td>"+cours.name+"</td>\r\n"
								+ "		 <td>"+cours.day+"</td>\r\n"
								+ "      <td>"+cours.timeSlot+"</td>\r\n"
								+ "		<td>"+cours.enseignant.name+"</td>"
								+ "    </tr>\r\n");
						}
								out.println("</tbody>\r\n"
								+ "</table>\r\n");
		
	//*******************
		out.println("</div></body>\r\n"
				+ "</html>");
		
		out.close();
		
	}

}