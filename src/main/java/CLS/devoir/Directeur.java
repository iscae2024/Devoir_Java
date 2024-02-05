package CLS.devoir;

import com.fasterxml.jackson.annotation.JsonProperty;
public class Directeur {
	@JsonProperty
	public  String username;
	@JsonProperty
	public  String password;
	@JsonProperty
	public  int  id; 
	public Directeur(String username, String password,int id) {
		this.username = username;
		this.password = password;
		this.id=id;
	}	
	public Directeur() {	}
}
