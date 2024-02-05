package Resource.devoir;

import java.util.HashMap;

import CLS.devoir.Cours;
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
	public void AddCours(@FormParam("CoursName") String name , @FormParam("timeslot") String timeslot, @FormParam("date") String day ) {

		listCours.put( id, new Cours(name, timeslot,day, id )); 
		id++;
	}
	
}
