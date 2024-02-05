package Servlet.devoir;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class GestionCours extends HttpServlet {

	public void service (HttpServletRequest req,HttpServletResponse rep) 
				throws ServerException , IOException
		{	
			
			rep.setContentType("text/html");
			String matier;
			String date;
			String timeSlot;
			String ens;
			PrintWriter out = rep.getWriter();
			out.println("<!DOCTYPE html>\r\n"
					+ "<html>\r\n"
					+ "<head>\r\n"
					+ "<meta charset=\"UTF-8\">\r\n"
					+ "<title>Cours</title>\r\n"
					+ "<link rel=\"stylesheet\" href=\"css/bootstrap.min.css\" />\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "\r\n"
					+ "<nav  class=\"navbar navbar-expand-lg navbar-light bg-light\">\r\n"
					+ " <img src=\"img/logo-iscae.png\" style=\" width:100px;  \" > "
					+ "<div class=\"container-fluid\">\r\n"
					+ "    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n"
					+ "      <span class=\"navbar-toggler-icon\"></span>\r\n"
					+ "    </button>\r\n"
					+ "    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n"
					+ "      <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n"
					+ "        <li class=\"nav-item\">\r\n"
					+ "          <a class=\"btn btn-primary\" href=\"GestionCours\">Ajouter Cours</a>\r\n"
					+ "        </li>\r\n"
					+ "      </ul>\r\n"
					+ "  </div>\r\n"
					+ "</nav>\r\n");
			if (req.getParameter("nom")!=null && req.getParameter("jour")!=null && req.getParameter("time")!=null  && req.getParameter("id")!=null) {
				matier =  req.getParameter("nom");
				timeSlot = req.getParameter("time");
				date = req.getParameter("jour");
				ens = req.getParameter("ens");
					out.println("<form action=Dashboard/CoursAPI/id method=post>\r\n"
							+ "  <div class=\"form-group\">\r\n"
							+ "    <label>Nom Matier </label>\r\n"
							+ "    <input type=\"text\" class=\"form-control w-25\" name=CoursName value="+matier+">\r\n"
							+ "    <label> Creneau </label>\r\n"
							+ "    <input type=\"text\" class=\"form-control w-25\" name=timeslot value="+timeSlot+">\r\n"
							+ "    <label> Jour </label>\r\n"
							+ "    <input type=\"text\" class=\"form-control w-25\" name=date value="+date+">\r\n"
							+ "    <label> Nom enseignant </label>\r\n"
							+ "    <input type=\"text\" class=\"form-control w-25\" name=nomEnseignant value="+ens+">\r\n"
							+ " <input type=hidden value="+ req.getParameter("id")+" name=id>\r\n"
							+ "  </div>\r\n"
							+ "  <button type=\"submit\" class=\"btn btn-primary\">Enregistrer</button>\r\n");
				out.println("</form></body>\r\n"
					+ "</html>");
			}else {
				out.println("<form action=Dashboard/CoursAPI method=post>\r\n"
						+ "  <div class=\"form-group\">\r\n"
						+ "    <label>Nom Matier </label>\r\n"
						+ "    <input type=\"text\" class=\"form-control w-25\" name=CoursName>\r\n"
						+ "    <label> Creneau </label>\r\n"
						+ "    <input type=\"text\" class=\"form-control w-25\" name=timeslot>\r\n"
						+ "    <label> Jour </label>\r\n"
						+ "    <input type=\"text\" class=\"form-control w-25\" name=date >\r\n"
						+ "    <label> Nom Enseignant </label>\r\n"
						+ "    <input type=\"text\" class=\"form-control w-25\" name=nomEnseignant >\r\n"
						+ "  </div>\r\n"
						+ "  <button type=\"submit\" class=\"btn btn-primary\">Enregistrer</button>\r\n");
		out.println("</form></body>\r\n"
				+ "</html>");
			}
			out.close();	
		}
	
	

}
