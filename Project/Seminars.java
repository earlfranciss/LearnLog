package Project;

public abstract class Seminars {
	private String type;
	private String title;
	private String venue;
	Date dateOfActivity;
	Speaker Speaker;
	
	public void setType(String type) {
		this.type = type;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public void setVenue(String venue) {
		this.venue = venue;
	}
	
	public void setDateOfAct(Date dateOfActivity) {
		this.dateOfActivity = dateOfActivity;
	}
	
	public void setSpeaker(Speaker Speaker) {
		this.Speaker = Speaker;
	}
	
	public String getType() {
		return type;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getVenue() {
		return venue;
	}
	
	public Date getDateOfAct() {
		return dateOfActivity;
	}
	
	public Speaker getSpeaker() {
		return Speaker;
	}
	
	public abstract int computeNoOfSeminars(String filePath, String id, String name, String specialization);
	
	public abstract int computeTotalPoints(String filePath, String id, String name, String specialization);
	
	@Override
	public String toString() {
		return dateOfActivity + "," + title + "," + type + "," + venue + "," + Speaker;
	}
}
