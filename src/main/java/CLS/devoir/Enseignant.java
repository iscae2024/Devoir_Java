package CLS.devoir;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Enseignant {

	@JsonProperty
	public  String password;
	@JsonProperty
	public  String name;
	@JsonProperty
	public int id;
	
	public Enseignant(String name,String pass , int id) {
		this.name = name;
		this.password = pass;
		this.id = id;
	}
	
	public  Enseignant(String name) {
		this.name = name;
	}
	
}
