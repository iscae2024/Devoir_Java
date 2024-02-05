package Servlet.devoir;

import java.io.IOException;
import java.io.PrintWriter;
import java.rmi.ServerException;

import CLS.devoir.Enseignant;
import Resource.devoir.EnseignantResource;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AdminServices extends HttpServlet{

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
		//List  directeurs
		out.println("<div class=container><h2 class=text-center>Liste des Directeurs</h2><table class=\"table\">\r\n"
				+ "  <thead>\r\n"
				+ "    <tr>\r\n"
				+ "      <th scope=\"col\">id</th>\r\n"
				+ "      <th scope=\"col\">NOM</th>\r\n"
				+ "      <th scope=\"col\">Modifier</th>\r\n"
				+ "    </tr>\r\n"
				+ "  </thead>\r\n"
				+ "  <tbody>\r\n");
		for(CLS.devoir.Directeur directeur : Resource.devoir.DirecteurResource.directeur.values() ) {
				out.println("<tr><th scope=\"row\">"+ directeur.id +"</th>\r\n"
				+ "      <td>"+directeur.username+"</td>\r\n"
				+ "      <td class=d-flex>\r\n"
				+ "		  <a class=\"btn btn-primary\" href=GestionDirecteur?id="+directeur.id+"&nom="+directeur.username.replace(" ", "-")+"&pass="+directeur.password.replace(" ", "-")+">Modifier</a>\r\n"
				+ "		  <form action=Dashboard/DirecteurAPI/delete method=post>\r\n"
				+ "			<input type=hidden value="+ directeur.id +" name=delete>\r\n"
				+"			<button type=submit class=\"btn btn-danger\">Supprimer</button></form>\r\n"
				+ "		  </td>\r\n"			
				+ "    </tr>\r\n");
				
		}
				out.println("</tbody>\r\n"
				+ "</table>\r\n");
  //List  ens
				out.println("<h2 class=text-center>Liste des enseignants</h2><table class=\"table\">\r\n"
						+ "  <thead>\r\n"
						+ "    <tr>\r\n"
						+ "      <th scope=\"col\">id</th>\r\n"
						+ "      <th scope=\"col\">NOM</th>\r\n"
						+ "      <th scope=\"col\">Modifier</th>\r\n"
						+ "    </tr>\r\n"
						+ "  </thead>\r\n"
						+ "  <tbody>\r\n");
				for(Enseignant ens : EnseignantResource.listTeacher.values()) {
						out.println("<tr><th scope=\"row\">"+ ens.id +"</th>\r\n"
						+ "      <td>"+ens.name+"</td>\r\n"
						+ "      <td class=d-flex>\r\n"
						+ "		  <a class=\"btn btn-primary\" href=Gestionenseignant?id="+ens.id +"&nom="+ens.name.replace(" ","-")+"&pass="+ens.password.replace(" ","-")+">Modifier</a>\r\n"
						+ "		  <form action=Dashboard/EnseignantApi/delete method=post>\r\n"
						+ "			<input type=hidden value="+ ens.id +" name=delete>\r\n"
						+"			<button type=submit class=\"btn btn-danger\">Supprimer</button></form>\r\n"
						+ "		  </td>\r\n"			
						+ "    </tr>\r\n");
				}
						out.println("</tbody>\r\n"
						+ "</table>\r\n");		
//***List des Cours : 
				out.println("<h2 class=text-center>Liste des Cours</h2><table class=\"table\">\r\n"
						+ "  <thead>\r\n"
						+ "    <tr>\r\n"
						+ "      <th scope=\"col\">id</th>\r\n"
						+ "      <th scope=\"col\">NOM</th>\r\n"
						+ "      <th scope=\"col\">Jours</th>\r\n"
						+ "      <th scope=\"col\">Creneau</th>\r\n"
						+ "      <th scope=\"col\">Enseignant</th>\r\n"
						+ "      <th scope=\"col\">Modifier</th>\r\n"
						+ "    </tr>\r\n"
						+ "  </thead>\r\n"
						+ "  <tbody>\r\n");
				
				for(CLS.devoir.Cours cours : Resource.devoir.CoursResource.listCours.values()) {
				
						out.println("<tr><th scope=\"row\">"+ cours.id +"</th>\r\n"
						+ "      <td>"+cours.name+"</td>\r\n"
						+ "		 <td>"+cours.day+"</td>\r\n"
						+ "      <td>"+cours.timeSlot+"</td>\r\n"
						+ "      <td>"+cours.enseignant.name+"</td>\r\n"
						+ "      <td class=d-flex>\r\n"
						+ "		  <a class=\"btn btn-primary\" href=GestionCours?id="+cours.id+"&time="+cours.timeSlot+"&nom="+cours.name+"&jour="+cours.day+"&ens="+cours.enseignant.name+">Modifier</a>\r\n"
						+ "		  <form action=Dashboard/CoursAPI/delete method=post>\r\n"
						+ "			<input type=hidden value="+ cours.id +" name=delete>\r\n"
						+"			<button type=submit class=\"btn btn-danger\">Supprimer</button></form>\r\n"
						+ "		  </td>\r\n"			
						+ "    </tr>\r\n");
				}
						out.println("</tbody>\r\n"
						+ "</table>\r\n");
		//Formule pour changer Password Admin: 
		out.println("<form class=\" mt-5 form-control\" action=Dashboard/AdminResource method=post>\r\n"
				+ "  <div class=\"form-group\">\r\n"
				+ "    <label>Modifier le Mot de Passe </label>\r\n"
				+ "    <input type=\"text\" class=\"form-control mb-2\"  name=\"Newpassword\" placeholder=\"Mot de Pass\">\r\n"
				+ "  </div>\r\n"
				+ "  <button type=\"submit\" class=\"btn btn-primary\">Enregistrer</button>\r\n"
				+ "</form>");

		out.println("</div></body>\r\n"
				+ "</html>");
		
		out.close();
		
	}

}