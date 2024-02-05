package CLS.devoir;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Cours {
	@JsonProperty
	public String name;
	@JsonProperty
	public String timeSlot;
	@JsonProperty
	public String day;
	@JsonProperty
	public int id;
	@JsonProperty
	public Enseignant enseignant;
	public Cours(String name,String timeSlot , String day ,int id , Enseignant enseignant ) {
		this.name = name;
		this.timeSlot = timeSlot;
		this.day = day;
		this.id = id;
		this.enseignant = enseignant;
	}
}