package Resource.devoir;

import java.util.HashMap;

import CLS.devoir.Cours;
import CLS.devoir.Enseignant;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/CoursAPI")
public class CoursResource {
	public static HashMap<Integer, Cours> listCours = new HashMap<Integer, Cours>();
	public static int id=1;
	
	@POST
	@Consumes({"application/x-www-form-urlencoded"})
	public void AddCours(@FormParam("CoursName") String name , @FormParam("timeslot") String timeslot, @FormParam("date") String day ,@FormParam("nomEnseignant") String nomT ) {
	
		listCours.put( id, new Cours(name, timeslot,day, id ,new Enseignant(nomT)  )); 
		id++;
	}
	
	@POST
	@Path("/id")
	@Consumes({"application/x-www-form-urlencoded"})
	public void update(@FormParam("id") String ID ,@FormParam("CoursName") String name , @FormParam("timeslot") String timeslot, @FormParam("date") String day,@FormParam("nomEnseignant") String nomT ) {
		
		listCours.put(Integer.parseInt(ID), new Cours(name, timeslot,day,Integer.parseInt(ID) ,new Enseignant(nomT) )); 
		
	}
	
	@POST
	@Path("/delete")
	@Consumes({"application/x-www-form-urlencoded"})
	public void delete(@FormParam("delete") String ID) {
		
		listCours.remove(Integer.parseInt(ID));

	}
	
}
