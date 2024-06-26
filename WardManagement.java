import java.util.ArrayList;

/*
 * I declare that this code was written by me. 
 * I do not copy or allow others to copy my code. 
 * I understand that copying code is considered as plagiarism.
 * 
 * Student Name: Nabillah Aniq Tan (Chen Yuxin)
 * Student ID: 22024987
 * Class: W65P
 * Date/Time Last modified: Friday 03-02-2023 01:00
 */

public class WardManagement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// initialise Ward array with ward objects
		Ward[] wardArr = new Ward[4];

		// -------------------
		// Complete code here

		wardArr[0] = new Ward("A", "1 Bed, attached bath/toilet", 10, 535.00);
		wardArr[1] = new Ward("B1", "4 Bed, attached bath/toilet", 20, 266.43);
		wardArr[2] = new Ward("B2", "6 Bed, common bath/toilet", 20, 83.00);
		wardArr[3] = new Ward("C", "8 Bed, common bath/toilet", 50, 37.00);

		// -------------------

		// initialise Patient arraylist with patient objects
		ArrayList<Patient> patientList = new ArrayList<Patient>();

		// -------------------
		// Complete code here

		patientList.add(new Patient("111A", "John Lee", "A", 2, "01/12/2022", "", 0));
		patientList.add(new Patient("222B", "Mary Jane", "B1", 11, "02/12/2022", "", 0));
		patientList.add(new Patient("333C", "Abdul Musri", "B1", 12, "03/12/2022", "", 0));
		patientList.add(new Patient("444D", "Jane Tan", "B2", 2, "12/12/2022", "", 3));
		patientList.add(new Patient("555E", "Paul Tan", "C", 2, "02/11/2022", "", 4));
		patientList.add(new Patient("666F", "Paul Ng", "C", 3, "03/11/2022", "09/11/2022", 0));
		patientList.add(new Patient("777G", "Wong Kuan", "C", 4, "02/12/2022", "", 0));

		// -------------------

		// display standard menu and ask for option
		int option = -99;
		publicMenu();

		// indefinite while loop
		while (option != 9) {
			boolean patientfound = true;
			option = Helper.readInt("\nEnter option or 0 for main menu > ");

			// check for options
			if (option == 0) {
				// display main menu
				publicMenu();

			} else if (option == 1) {
				// list ward info
				displayWardInfo(wardArr);

			} else if (option == 2) {
				// display patient in ward
				displayPatientList(patientList);

			} else if (option == 3) {
				// admit patient
				admitPatient(patientList);

			} else if (option == 4) {
				// discharged patient
				patientfound = dischargePatient(patientList);
			} else if (option == 5) {
				// Remove patient visit

				patientfound = removePatient(patientList);
			} else if (option == 6) {
				// register visit
				patientfound = registerVisit(patientList);
			} else if (option == 7) {
				// End visit
				patientfound = endVisit(patientList);
			} else if (option == 8) {
				// End visit
				displayWardOverview(patientList, wardArr);
			} else if (option == 9) {
				// log out
				System.out.println("\nGood bye!");
			} else {
				// invalid option chosen
				System.out.println("\n*** Invalid option selected ***\n");
			}

			// if patient does not exist based on return boolean
			if (!patientfound) {
				System.out.println("\n*** No such patient in ward ***\n");
			}

		}

	} // end of main

	// -------------------------------------------------------------------------------------------------------
	// static method to print the standard menu
	// -------------------------------------------------------------------------------------------------------
	public static void publicMenu() {
		System.out.println();
		Helper.line(45, "*");
		System.out.println("*****     PATIENT  MANAGEMENT  MENU     *****");
		Helper.line(45, "*");

		// -------------------
		// Complete code here
		// -------------------

		System.out.println("1. View all Ward Info");
		System.out.println("2. Display Patient List");
		System.out.println("3. Admit Patient");
		System.out.println("4. Discharge Patient");
		System.out.println("5. Remove Patient");
		System.out.println("6. Register Visit");
		System.out.println("7. End Visit");
		System.out.println("8. Display Ward Overview");
		System.out.println("9. Logout");

	}

	// -------------------------------------------------------------------------------------------------------
	// static method takes in a ward array and list out ward details in a tabular
	// list
	// -------------------------------------------------------------------------------------------------------
	public static void displayWardInfo(Ward[] wardArr) {

		// -------------------
		// Complete code here
		// -------------------

		String output = String.format("%-10s %-30s %-15s %-20s\n", "WARD", "DESCRIPTION", "BED COUNT", "BED CHARGE");

		for (int i = 0; i < wardArr.length; i++) {
			if (wardArr[i] != null) {
				output += String.format("%-10s %-30s %-15d %-20.2f\n", wardArr[i].getWard(),
						wardArr[i].getDescription(), wardArr[i].getBedCount(), wardArr[i].getBedCharge());
			}
		}
		System.out.println(output);

	}

	// -------------------------------------------------------------------------------------------------------
	// static method takes in a patient arraylist and display all the patient
	// information in a tabular list
	// -------------------------------------------------------------------------------------------------------
	public static void displayPatientList(ArrayList<Patient> patientList) {

		// -------------------
		// Complete code here
		// -------------------

		String output = String.format("%-10s %-20s %-10s %-10s %-15s %-20s %-15s\n", "NRIC4", "NAME", "WARD", "BED",
				"DATE WARDED", "DATE DISCHARGED", "VISITOR COUNT");

		for (int i = 0; i < patientList.size(); i++) {
			output += String.format("%-10s %-20s %-10s %-10d %-15s %-20s %-15d\n", patientList.get(i).getNric4(),
					patientList.get(i).getName(), patientList.get(i).getWard(), patientList.get(i).getBed(),
					patientList.get(i).getDateWarded(), patientList.get(i).getDateDischarged(),
					patientList.get(i).getVisitorCount());

		}
		System.out.println(output);

	}

	// -------------------------------------------------------------------------------------------------------
	// static method takes in a patient arraylist and performs the admit patient
	// functionality
	// -------------------------------------------------------------------------------------------------------
	public static void admitPatient(ArrayList<Patient> patientList) {

		// -------------------
		// Complete code here
		// -------------------

		// Add objects into arraylist
		String nric4 = Helper.readString("Enter patient 4 digit NRIC > ");
		String name = Helper.readString("Enter patient name > ");
		String ward = Helper.readString("Enter patient ward > ");
		int bed = Helper.readInt("Enter bed > ");
		String dateWarded = Helper.readString("Enter date warded > ");

		// To check whether there is a duplicate patient
		boolean isAdded = false;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getNric4().equalsIgnoreCase(nric4)
					&& patientList.get(i).getName().equalsIgnoreCase(name)) {
				isAdded = true;
				break;
			}
		}

		// If there is no duplicate patient then add new patient
		if (isAdded == false) {

			// Create the new patient
			Patient new_patient = new Patient(nric4, name, ward, bed, dateWarded);

			// To add the new patient
			patientList.add(new_patient);
			System.out.println("");
			new_patient.display();
			System.out.println("\n***Patient has been successfully added!***");

		} else {
			System.out.println("\n***Patient already in system!***");
		}
	}

	// -------------------------------------------------------------------------------------------------------
	// static method takes in a patient arraylist and performs the discharge patient
	// functionality
	// It will return 'true' if the patient record exist
	// -------------------------------------------------------------------------------------------------------
	public static boolean dischargePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		// -------------------
		// Complete code here
		// -------------------

		// enter user
		String pname = Helper.readString("Enter patient name > ");

		// check if patient exist
		for (int i = 0; i < patientList.size(); i++) {

			if (patientList.get(i).getName().equalsIgnoreCase(pname)) {
				// display patient's info

				if (patientList.get(i).getDateDischarged().isEmpty()) {
					patientList.get(i).display();
					String disc_date = Helper.readString("Enter discharge date > ");

					// update patients info
					patientList.get(i).setDateDischarged(disc_date);
					patientList.get(i).setVisitorCount(0);

				} else {
					System.out.println("*** Patient has already been discharged ***");

				}

				patientfound = true;
			}
		}
		if (patientfound == true) {
		} else {

		}

		return patientfound;
	}

	// -------------------------------------------------------------------------------------------------------
	// static method takes in a patient arraylist and performs the remove patient
	// functionality
	// It will return 'true' if the patient record exist
	// -------------------------------------------------------------------------------------------------------
	public static boolean removePatient(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		// -------------------
		// Complete code here
		// -------------------

		// enter user
		String pname = Helper.readString("Enter patient name > ");

		// check if user exist
		for (int i = 0; i < patientList.size(); i++) {

			if (patientList.get(i).getName().equalsIgnoreCase(pname)) {
				// display patient's info
				patientList.get(i).display();

				// confirm deletion
				char confirmation = Helper.readChar("Confirm deletion (y/n) > ");
				if (confirmation == 'y' || confirmation == 'Y') {
					patientList.remove(i);
					System.out.println("");
					System.out.println("*** Patient has been deleted ***");

				}

				patientfound = true;
			}
		}

		if (patientfound == true) {
		} else {

		}

		return patientfound;
	}

	// -------------------------------------------------------------------------------------------------------
	// static method takes in a patient arraylist and performs the register visit
	// functionality
	// It will return 'true' if the patient record exist
	// -------------------------------------------------------------------------------------------------------
	public static boolean registerVisit(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		// -------------------
		// Complete code here
		// -------------------

		// enter patient name
		String pname = Helper.readString("Enter patient name > ");

		// check if patient exist
		for (int i = 0; i < patientList.size(); i++) {

			if (patientList.get(i).getName().equalsIgnoreCase(pname)) {

				// check if patient is still in ward
				if (patientList.get(i).getDateDischarged().isEmpty()) {
					patientList.get(i).display();
					if (patientList.get(i).getVisitorCount() == 0) {
						System.out.println("");
						System.out.println("*** Only 4 visitor(s) allowed ***");
					} else {
						System.out.println("");
						System.out.println(
								"*** Only " + (4 - patientList.get(i).getVisitorCount()) + " visitor(s) allowed ***");
					}

					// check the number of visitors present
					if (patientList.get(i).getVisitorCount() == 4) {
						System.out.println("*** No additional visitor allowed ***");

					} else {
						int new_visitors = Helper.readInt("Enter number of new visitors > ");
						if ((new_visitors + patientList.get(i).getVisitorCount()) > 4) {
							System.out.println("*** Visitors exceeded ***");
						} else {
							patientList.get(i).setVisitorCount(patientList.get(i).getVisitorCount() + new_visitors);
							System.out.println("*** Please proceed to ward ***");

						}
					}
				} else {
					System.out.println("*** Patient has already been discharged ***");

				}
				patientfound = true;
			}
		}
		if (patientfound == true) {
		} else {

		}

		return patientfound;

	}

	// -------------------------------------------------------------------------------------------------------
	// static method takes in a patient arraylist and performs the end visit
	// functionality
	// It will return 'true' if the patient record exist
	// -------------------------------------------------------------------------------------------------------
	public static boolean endVisit(ArrayList<Patient> patientList) {

		boolean patientfound = false;

		// -------------------
		// Complete code here
		// -------------------

		// enter patient name
		String pname = Helper.readString("Enter patient name > ");

		// check if patient exist
		for (int i = 0; i < patientList.size(); i++) {

			if (patientList.get(i).getName().equalsIgnoreCase(pname)) {
				// display patient's info
				patientList.get(i).display();

				// check if patient is still in ward
				if (patientList.get(i).getDateDischarged().isEmpty()) {

					// number of visitors leaving
					int leaving = Helper.readInt("Enter number of visitor(s) leaving > ");
					if (leaving > patientList.get(i).getVisitorCount()) {
						System.out.println("*** Vistor(s) leaving is more than visited ***");
					} else {
						System.out.println("*** No. of visitor(s) still at ward: "
								+ (patientList.get(i).getVisitorCount() - leaving) + " ***");
						patientList.get(i).setVisitorCount(patientList.get(i).getVisitorCount() - leaving);
					}

				} else {
					System.out.println("*** Patient has been discharged ***");
				}
				patientfound = true;
			}
		}

		if (patientfound == true) {
		} else {

		}

		return patientfound;
	}

	// ------------------------------------------------------------------------------------------------------------
	// static method that takes in a patient arraylist, a ward array and display an
	// overview of the ward information
	// ------------------------------------------------------------------------------------------------------------
	public static void displayWardOverview(ArrayList<Patient> patientList, Ward[] wardArr) {

		// -------------------
		// Complete code here
		// -------------------

		// Each Ward
		Helper.line(40, "=");
		System.out.println("*****   EACH WARD  *****");
		Helper.line(40, "=");

		String output = String.format("%-10s %-30s %-20s\n", "WARD", "DESCRIPTION", "BED COUNT");

		for (int i = 0; i < wardArr.length; i++) {
			output += String.format("%-10s %-30s %-20d\n", wardArr[i].getWard(), wardArr[i].getDescription(),
					wardArr[i].getBedCount());
		}

		String output2 = String.format("%-20s %-30s\n", "TOTAL PATIENTS", "TOTAL VISITORS");

		// total patients - each ward
		int patientA = 0;
		int patientB1 = 0;
		int patientB2 = 0;
		int patientC = 0;

		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getWard().equalsIgnoreCase("A")
					&& patientList.get(i).getDateDischarged().equals("")) {
				patientA = patientA + 1;

			} else if (patientList.get(i).getWard().equalsIgnoreCase("B1")
					&& patientList.get(i).getDateDischarged().equals("")) {
				patientB1 = patientB1 + 1;

			} else if (patientList.get(i).getWard().equalsIgnoreCase("B2")
					&& patientList.get(i).getDateDischarged().equals("")) {
				patientB2 = patientB2 + 1;

			} else if (patientList.get(i).getWard().equalsIgnoreCase("C")
					&& patientList.get(i).getDateDischarged().equals("")) {
				patientC = patientC + 1;

			}

		}

		// total visitors - each ward
		int visitorsA = 0;
		int visitorsB1 = 0;
		int visitorsB2 = 0;
		int visitorsC = 0;

		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getWard().equalsIgnoreCase("A")) {
				visitorsA = visitorsA + patientList.get(i).getVisitorCount();

			} else if (patientList.get(i).getWard().equalsIgnoreCase("B1")) {
				visitorsB1 = visitorsB1 + patientList.get(i).getVisitorCount();

			} else if (patientList.get(i).getWard().equalsIgnoreCase("B2")) {
				visitorsB2 = visitorsB2 + patientList.get(i).getVisitorCount();

			} else if (patientList.get(i).getWard().equalsIgnoreCase("C")) {
				visitorsC = visitorsC + patientList.get(i).getVisitorCount();

			}

		}

		output2 += String.format("%-20s %-30s\n", patientA, visitorsA);
		output2 += String.format("%-20s %-30s\n", patientB1, visitorsB1);
		output2 += String.format("%-20s %-30s\n", patientB2, visitorsB2);
		output2 += String.format("%-20s %-30s\n", patientC, visitorsC);

		System.out.println(output);
		System.out.println(output2);

		// Total Ward
		Helper.line(40, "=");
		System.out.println("*****   TOTAL WARD  *****");
		Helper.line(40, "=");

		String output3 = String.format("%-20s %-20s %-20s\n", "TOTAL BED COUNT", "TOTAL PATIENTS", "TOTAL VISITORS");

		// total bed count - total ward
		int sumBedCount = 0;
		for (int i = 0; i < wardArr.length; i++) {
			if (wardArr[i] != null) {
				sumBedCount += wardArr[i].getBedCount();

			}

		}

		// total patients - total ward
		int sumPatient = 0;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getDateDischarged().equals("")) {
				sumPatient = sumPatient + 1;

			}
		}

		// total visitors - total ward
		int sumVisitors = 0;
		for (int i = 0; i < patientList.size(); i++) {
			if (patientList.get(i).getDateDischarged().equals("")) {
				sumVisitors += patientList.get(i).getVisitorCount();

			}

		}
		output3 += String.format("%-20d %-20d %-20d\n", sumBedCount, sumPatient, sumVisitors);
		System.out.println(output3);

	}

}