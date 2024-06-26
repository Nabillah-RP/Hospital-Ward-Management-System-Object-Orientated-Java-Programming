/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: 22024987
 * Student ID: {type your id here}
 * Class: {type your class here}
 * Date/Time created: Tuesday 13-12-2022 14:23
 */

/**
 * @author 22024987
 *
 */
public class Patient {

	// Create the fields/attributes
	private String nric4;
	private String name;
	private String ward;
	private int bed;
	private String dateWarded;
	private String dateDischarged;
	private int visitorCount;

	// Constructor1
	public Patient(String nric4, String name, String ward, int bed, String dateWarded, String dateDischarged,
			int visitorCount) {
		this.nric4 = nric4;
		this.name = name;
		this.ward = ward;
		this.bed = bed;
		this.dateWarded = dateWarded;
		this.dateDischarged = dateDischarged;
		this.visitorCount = visitorCount;

	}

	// Constructor2
	public Patient(String nric4, String name, String ward, int bed, String dateWarded) {
		this.nric4 = nric4;
		this.name = name;
		this.ward = ward;
		this.bed = bed;
		this.dateWarded = dateWarded;
		this.dateDischarged = "";
		this.visitorCount = 0;

	}

	// Method - getNric4()
	public String getNric4() {
		return nric4;
	}

	// Method - getName()
	public String getName() {
		return name;
	}

	// Method - getWard()
	public String getWard() {
		return ward;
	}

	// Method - getBed()
	public int getBed() {
		return bed;
	}

	// Method - getDateWarded()
	public String getDateWarded() {
		return dateWarded;
	}

	// Method - getDateDischarged()
	public String getDateDischarged() {
		return dateDischarged;
	}

	// Method - setDateDischarged(String)
	public void setDateDischarged(String dateDischarged) {
		this.dateDischarged = dateDischarged;
	}

	// Method - getVisitorCount()
	public int getVisitorCount() {
		return visitorCount;
	}

	// Method - setVisitorCount(int)
	public void setVisitorCount(int visitorCount) {
		this.visitorCount = visitorCount;
	}

	// Method - display()
	public void display() {
		System.out.println("Patient Name: " + name);
		System.out.println("Ward: " + ward);
		System.out.println("Bed: " + bed);
		System.out.println("Date Warded: " + dateWarded);
		System.out.println("Date Discharged: " + dateDischarged);
		System.out.println("No of visitor(s): " + visitorCount);

	}
}
