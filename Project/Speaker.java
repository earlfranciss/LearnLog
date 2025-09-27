package Project;

public class Speaker {
	private String FirstName;
	private String LastName;
	private String Specialization;
	
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	public void setSpecialization(String Specialization) {
		this.Specialization = Specialization;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	
	public String getLastName() {
		return LastName;
	}
	
	public String getSpecialization() {
		return Specialization;
	}
	
	@Override
	public String toString() {
		return FirstName + "," + LastName + "," + Specialization;
	}
}
