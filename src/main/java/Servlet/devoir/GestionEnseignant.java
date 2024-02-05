package Servlet.devoir;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GestionEnseignant extends HttpServlet {

	public void service (HttpServletRequest req,HttpServletResponse rep) 
			throws ServerException , IOException
	{	
		
		rep.setContentType("text/html");
		PrintWriter out = rep.getWriter();
		

		String Name="";
		String password="";
		out.println("<!DOCTYPE html>\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"UTF-8\">\r\n"
				+ "<title>Insert title here</title>\r\n"
				+ "<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "<nav  class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n"
				+ " <img src=\"img/logo-iscae.png\" style=\" width:100px;  \" > "
				+ "<div class=\"container-fluid\">\r\n"
				+ "    <a class=\"navbar-brand\" href=\"#\">Admin</a>\r\n"
				+ "    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
				+ "      <span class=\"navbar-toggler-icon\"></span>\r\n"
				+ "    </button>\r\n"
				+ "    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
				+ "      <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n"
				+ "        <li class=\"nav-item\">\r\n"
				+ "          <a class=\"nav-link active\" aria-current=\"page\" href=\"AdminServices\">Home</a>\r\n"
				+ "        </li>\r\n"
				+ "        <li class=\"nav-item mr-2\">\r\n"
				+ "          <a class=\"btn btn-primary\" href=\"GestionDirecteur\">Ajouter Directeur</a>\r\n"
				+ "        </li>\r\n"
				+ "        <li class=\"nav-item mx-5\">\r\n"
				+ "          <a class=\"btn btn-primary\" href=\"Gestionenseignant\">Ajouter Enseignant</a>\r\n"
				+ "        </li>\r\n"
				+ "        <li class=\"nav-item\">\r\n"
				+ "          <a class=\"btn btn-primary\" href=\"GestionCours\">Ajouter Cours</a>\r\n"
				+ "        </li>\r\n"
				+ "      </ul>\r\n"
				+ "  </div>\r\n"
				+ "</nav>\r\n");
		if (req.getParameter("nom")!=null && req.getParameter("pass")!=null && req.getParameter("id")!=null) {
			Name =  req.getParameter("nom").replace("-"," ");
			password = req.getParameter("pass").replace("-"," ");;
		//Formule Modifier nom et password d' enseignant: 
				out.println("<form action=Dashboard/EnseignantApi/id method=post>\r\n"
						+ "  <div class=\"form-group\">\r\n"
						+ "    <label>Nom Enseignant </label>\r\n"
						+ "    <input type=\"text\" class=\"form-control w-25\" name=nom value=\""+Name+"\">\r\n"
						+ "    <label> Mot de Passe </label>\r\n"
						+ "    <input type=\"text\" class=\"form-control w-25\" name=password value=\""+password+"\">\r\n"
						+ " <input type=hidden value="+ req.getParameter("id")+" name=id>\r\n"
						+ "  </div>\r\n"
						+ "  <button type=\"submit\" class=\"btn btn-primary\">Enregistrer</button>\r\n");
			out.println("</form></body>\r\n"
				+ "</html>");
		}else{
			out.println("<form action=Dashboard/EnseignantApi method=post>\r\n"
					+ "  <div class=\"form-group\">\r\n"
					+ "    <label>Nom Enseignant </label>\r\n"
					+ "    <input type=\"text\" class=\"form-control w-25\" name=nom>\r\n"
					+ "    <label> Mot de Passe </label>\r\n"
					+ "    <input type=\"text\" class=\"form-control w-25\" name=password>\r\n"
					+ "  </div>\r\n"
					+ "  <button type=\"submit\" class=\"btn btn-primary\">Enregistrer</button>\r\n");
	out.println("</form></body>\r\n"
			+ "</html>");
		}
		out.close();

	}

}

