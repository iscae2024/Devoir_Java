package Resource.devoir;
import java.util.HashMap;
import java.util.Map;

import CLS.devoir.Admin;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.FormParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
@Path("/AdminResource")
public class AdminResource {
	
	public static Map<Integer, Admin> admin = new HashMap<Integer, Admin>();

	static {
		admin.put(1, new Admin("Admin", "Admin"));
	}
	@POST
	@Consumes({"application/x-www-form-urlencoded"})
	public void changeInfoAdmin(@FormParam("Newpassword") String pass) {
		admin.clear();
		admin.put(1, new Admin("Admin", pass)); 
	}
	
}