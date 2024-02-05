package Resource.devoir;

import java.util.HashMap;
import CLS.devoir.Enseignant;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


@Path("EnseignantApi")
public class EnseignantResource {
	
	
	public static HashMap<Integer, Enseignant> listTeacher = new HashMap<Integer, Enseignant>();
	public static int id=1;
	
	@POST
	@Consumes({"application/x-www-form-urlencoded"})
	public void AddTeacher(@FormParam("nom") String name,@FormParam("password") String password) {
		
		listTeacher.put(id, new Enseignant(name, password,id)); 
		id++;
	}
	
	
	
	@POST
	@Path("/id")
	@Consumes({"application/x-www-form-urlencoded"})
	public void update(@FormParam("id") String ID ,@FormParam("nom") String name , @FormParam("password") String pass) {
		
		listTeacher.put(Integer.parseInt(ID), new Enseignant(name, pass,Integer.parseInt(ID))); 
		
	}
	
	@POST
	@Path("/delete")
	@Consumes({"application/x-www-form-urlencoded"})
	public void delete(@FormParam("delete") String ID) {		
		listTeacher.remove(Integer.parseInt(ID));
	}
}