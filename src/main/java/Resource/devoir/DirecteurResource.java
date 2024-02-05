package Resource.devoir;

import java.util.HashMap;

import CLS.devoir.Directeur;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;

@Path("/DirecteurAPI")
public class DirecteurResource {
	
	public static int id=1;
	public static HashMap<Integer, Directeur> directeur = new HashMap<Integer,Directeur>();
	static{
		directeur.put(id, new Directeur("Directeur1", "Directeur",id));
		id++;
		directeur.put(id, new Directeur("Directeur2", "Directeur",id));
		id++;
	}
	
	@POST
	@Consumes({"application/x-www-form-urlencoded"})
	public void Save(@FormParam("DirecteurName") String name , @FormParam("passwordDir") String pass) {
		directeur.put(id , new Directeur(name, pass,id) ); 
		id++;
	}
	
	@POST
	@Path("/id")
	@Consumes({"application/x-www-form-urlencoded"})
	public void update(@FormParam("id") String ID ,@FormParam("DirecteurName") String name , @FormParam("passwordDir") String pass) {
		
		directeur.put(Integer.parseInt(ID), new Directeur(name, pass,Integer.parseInt(ID))); 
		
	}
	
	@POST
	@Path("/delete")
	@Consumes({"application/x-www-form-urlencoded"})
	public void delete(@FormParam("delete") String ID) {
		
		directeur.remove(Integer.parseInt(ID));
		
	}
	
}
