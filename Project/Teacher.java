package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Teacher extends Seminars{
	private String FirstName;
	private String LastName;
	private String IdNumber;
	private String Specialization;
	Date Birthday;
	
	public void setFirstName(String FirstName) {
		this.FirstName = FirstName;
	}
	
	public void setLastName(String LastName) {
		this.LastName = LastName;
	}
	
	public void setIdNumber(String IdNumber) {
		this.IdNumber = IdNumber;
	}
	
	public void setSpecialization(String Specialization) {
		this.Specialization = Specialization;
	}
	
	public void setBirthday(Date Birthday) {
		this.Birthday = Birthday;
	}
	
	public String getFirstName() {
		return FirstName;
	}
	
	public String getLastName() {
		return LastName;
	}
	
	public String getIdNumber() {
		return IdNumber;
	}
	
	public String getSpecialization() {
		return Specialization;
	}
	
	public Date setBirthday() {
		return Birthday;
	}
	
	@Override
	public String toString() {
		return IdNumber + "," + FirstName + "," + LastName + "," + Specialization + "," + Birthday;
	}
	
	
	 public int computeNoOfSeminars(String filePath, String id, String name, String specialization) {
		int total = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 8 && parts[0].trim().equals(id) && (parts[2].trim() + " " + parts[3].trim()).equals(name) && parts[5].trim().equals(specialization)) {
	                	for(int i = 8; i < parts.length; i += 2) {
	                		total++;
	                	}
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return total;
	}
	
	public int computeTotalPoints(String filePath, String id, String name, String specialization) {
		int total = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length > 8 && parts[0].trim().equals(id) && (parts[2].trim() + " " + parts[3].trim()).equals(name) && parts[5].trim().equals(specialization)) {
	                	for(int i = 9; i < parts.length; i+=2) {
	                		total += Integer.parseInt(parts[i].trim());
	                	}
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
		return total;
	}
}
