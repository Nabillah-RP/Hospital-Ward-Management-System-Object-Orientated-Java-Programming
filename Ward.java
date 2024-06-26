/* I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: 22024987
 * Student ID: {type your id here}
 * Class: {type your class here}
 * Date/Time created: Tuesday 13-12-2022 14:22
 */

/**
 * @author 22024987
 *
 */
public class Ward {

	// Create the fields/attributes
	private String ward;
	private String description;
	private int bedCount;
	private double bedCharge;

	// Constructor
	public Ward(String ward, String description, int bedCount, double bedCharge) {
		this.ward = ward;
		this.description = description;
		this.bedCount = bedCount;
		this.bedCharge = bedCharge;
	}

	// Method - getWard()
	public String getWard() {
		return ward;
	}

	// Method - getDescription()
	public String getDescription() {
		return description;
	}

	// Method - getBedCount()
	public int getBedCount() {
		return bedCount;
	}

	// Method - getBedCharge()
	public double getBedCharge() {
		return bedCharge;
	}

}
