package views;

import java.util.List;
import java.util.Map;

import interfaces.IMenuView;
import models.Camp;
import models.CampInformation;
import models.Enquiry;
import models.Suggestion;
import stores.AuthStore;
import stores.DataStore;
import utility.ViewUtility;

public class StudentView implements IMenuView{

	@Override
	public void displayMenuView() {
		//ViewUtility.clearScreen(); comment to debug
		
		String welcomeMessage = "Welcome " + AuthStore.getCurrentUser().getName();
		int totalLength = welcomeMessage.length();
		int spaces = (58 - totalLength) / 2;

		System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                          ║");   
		System.out.println("║             ██████╗ █████╗ ███╗   ███╗███████╗           ║");
		System.out.println("║            ██╔════╝██╔══██╗████╗ ████║██╔════╝           ║");
		System.out.println("║            ██║     ███████║██╔████╔██║███████╗           ║");
		System.out.println("║            ██║     ██╔══██║██║╚██╔╝██║╚════██║           ║");
		System.out.println("║            ╚██████╗██║  ██║██║ ╚═╝ ██║███████║           ║");
		System.out.println("║             ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝           ║");
        System.out.println("║                                                          ║");   
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║                     - Student Menu -                     ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║" + " ".repeat(spaces) + welcomeMessage + " ".repeat(58 - totalLength - spaces) + "║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        ViewUtility.displayInMenuNumbered("View All Camps", 1);
        ViewUtility.displayInMenuNumbered("View Camps with Filters", 2);
        ViewUtility.displayInMenuNumbered("Register for Camp", 3);
        ViewUtility.displayInMenuNumbered("Withdraw from Camp", 4);
        ViewUtility.displayInMenuNumbered("View Remaining Slots of Camp", 5);
        ViewUtility.displayInMenuNumbered("View Registered Camps", 6);
        ViewUtility.displayInMenuNumbered("Submit Enquiry", 7);
        ViewUtility.displayInMenuNumbered("View Enquiry", 8);
        ViewUtility.displayInMenuNumbered("Edit Enquiry", 9);
        ViewUtility.displayInMenuNumbered("Delete Enquiry", 10);
        ViewUtility.displayInMenuNumbered("Register as Committee", 11);
        ViewUtility.displayInMenuNumbered("Change Password", 12);
        ViewUtility.displayInMenuNumbered("Logout", 13);
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.print("Select an option: ");
	}

	public void displayCampComitteeMenuView() {
		ViewUtility.clearScreen();
		
		String welcomeMessage = "Welcome " + AuthStore.getCurrentUser().getName();
		int totalLength = welcomeMessage.length();
		int spaces = (58 - totalLength) / 2;

		System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                          ║");   
		System.out.println("║             ██████╗ █████╗ ███╗   ███╗███████╗           ║");
		System.out.println("║            ██╔════╝██╔══██╗████╗ ████║██╔════╝           ║");
		System.out.println("║            ██║     ███████║██╔████╔██║███████╗           ║");
		System.out.println("║            ██║     ██╔══██║██║╚██╔╝██║╚════██║           ║");
		System.out.println("║            ╚██████╗██║  ██║██║ ╚═╝ ██║███████║           ║");
		System.out.println("║             ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝           ║");
        System.out.println("║                                                          ║");   
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║                  - Camp Committee Menu -                 ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║" + " ".repeat(spaces) + welcomeMessage + " ".repeat(58 - totalLength - spaces) + "║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        ViewUtility.displayInMenuNumbered("View All Camps", 1);
        ViewUtility.displayInMenuNumbered("View Camps with Filters", 2);
        ViewUtility.displayInMenuNumbered("Register for Camp", 3);
        ViewUtility.displayInMenuNumbered("Withdraw from Camp", 4);
        ViewUtility.displayInMenuNumbered("View Registered Slots of Camp", 5);
        ViewUtility.displayInMenuNumbered("View Registered Camps", 6);
        ViewUtility.displayInMenuNumbered("View Enquiries For Camp", 7);
        ViewUtility.displayInMenuNumbered("Respond to Enquiry", 8);
        ViewUtility.displayInMenuNumbered("Submit Suggestion", 9);
        ViewUtility.displayInMenuNumbered("Edit Suggestion", 10);
        ViewUtility.displayInMenuNumbered("Delete Suggestion", 11);
        ViewUtility.displayInMenuNumbered("View Suggestion", 12);
        ViewUtility.displayInMenuNumbered("Generate Report", 13);
        ViewUtility.displayInMenuNumbered("Change Password", 14);
        ViewUtility.displayInMenuNumbered("Logout", 15);
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.print("Select an option: ");
	}
	
	/**
	 * Displays all camps without any filters
	 * @param list 
	 */
	public void viewCamps(List<Camp> campData, String title) {
    	// Print the filtered and sorted camps
		System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                          ║");   
		System.out.println("║         ██████╗ █████╗ ███╗   ███╗██████╗ ███████╗       ║");
		System.out.println("║        ██╔════╝██╔══██╗████╗ ████║██╔══██╗██╔════╝       ║");
		System.out.println("║        ██║     ███████║██╔████╔██║██████╔╝███████╗       ║");
		System.out.println("║        ██║     ██╔══██║██║╚██╔╝██║██╔═══╝ ╚════██║       ║");
		System.out.println("║        ╚██████╗██║  ██║██║ ╚═╝ ██║██║     ███████║       ║");
		System.out.println("║         ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═╝     ╚══════╝       ║");
        System.out.println("║                                                          ║");                                  
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        ViewUtility.displayInMenuCentered(title);
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        int i = 1;
    	for (Camp c : campData) {
    		ViewUtility.displayInMenuNumbered(c.getCampInformation().getCampName(), i);
        	i++;
    	}
        System.out.println("╚══════════════════════════════════════════════════════════╝");
	}
	
	/**
	 * Displays the camp information of the camp
	 * @param Camp c
	 */
	public void viewCampInformation(Camp c) {
    	// Print the filtered and sorted camps
		System.out.println("╔══════════════════════════════════════════════════════════╗");
		ViewUtility.displayInMenuCentered(" - " + c.getCampInformation().getCampName() + " - ");
		System.out.println("╠══════════════════════════════════════════════════════════╣");
        int i = 1;
    	//for (Camp c : campData) {
    		CampInformation campInfo = c.getCampInformation();
    		ViewUtility.displayInMenuBullet("Name: " + campInfo.getCampName());
    		ViewUtility.displayInMenuBullet("Start Date: " + campInfo.getCampStartDate());
    		ViewUtility.displayInMenuBullet("End Date: " + campInfo.getCampEndDate());
    		ViewUtility.displayInMenuBullet("Registration Closing Date: " + campInfo.getCampRegistrationClosingDate());
    		ViewUtility.displayInMenuBullet("User Group: " + campInfo.getFacultyGroup());
    		ViewUtility.displayInMenuBullet("Location: " + campInfo.getCampLocation());
    		ViewUtility.displayInMenuBullet("Total Slots: " + campInfo.getCampTotalSlots());
    		ViewUtility.displayInMenuBullet("Committee Slots: " + campInfo.getCampCommitteeSlots());
    		ViewUtility.displayInMenuBullet("Description: " + campInfo.getCampDescription());
    		ViewUtility.displayInMenuBullet("Staff In Charge: " + campInfo.getCampStaffInCharge());
        	i++;
    	//}
        System.out.println("╚══════════════════════════════════════════════════════════╝");
        System.out.print("(Press Enter to return) ");
	}
	
	/**
	 * Displays all camps without any filters
	 * @param list 
	 */
	public void viewCampsSlots(List<Camp> campData) {
		Map<String , List<String>> registeredStudents = DataStore.getCampToRegisteredCampCommitteeData(); 
		Map<String , List<String>> registeredCampCommittee = DataStore.getCampToRegisteredStudentData();
    	// Print the filtered and sorted camps
		System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                          ║");   
		System.out.println("║         ██████╗ █████╗ ███╗   ███╗██████╗ ███████╗       ║");
		System.out.println("║        ██╔════╝██╔══██╗████╗ ████║██╔══██╗██╔════╝       ║");
		System.out.println("║        ██║     ███████║██╔████╔██║██████╔╝███████╗       ║");
		System.out.println("║        ██║     ██╔══██║██║╚██╔╝██║██╔═══╝ ╚════██║       ║");
		System.out.println("║        ╚██████╗██║  ██║██║ ╚═╝ ██║██║     ███████║       ║");
		System.out.println("║         ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚═╝     ╚══════╝       ║");
        System.out.println("║                                                          ║");                                  
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        ViewUtility.displayInMenuCentered(" - Slots taken for each camp - ");
        System.out.println("╠════════════════════════════════════════════════╦═════════╣");
        System.out.println("║                   Camp Name                    ║  Slots  ║");
        int i = 1;
    	for (Camp c : campData) {
//			int filledSlots = registeredStudents.get(c.getCampInformation().getCampName()).size()+registeredCampCommittee.get(c.getCampInformation().getCampName()).size();
//			int totalSlots = c.getCampInformation().getCampTotalSlots();
			String campName = c.getCampInformation().getCampName();

	        List<String> students = registeredStudents.get(campName);
	        List<String> committeeMembers = registeredCampCommittee.get(campName);

	        int filledSlots = 0;
	        if (students != null) {
	            filledSlots += students.size();
	        }
	        if (committeeMembers != null) {
	            filledSlots += committeeMembers.size();
	        }

	        int totalSlots = c.getCampInformation().getCampTotalSlots();
			ViewUtility.displayInMenuNumberedTwoColumns(c.getCampInformation().getCampName(), i ,filledSlots, totalSlots);
			i++;
		}
        System.out.println("╚════════════════════════════════════════════════╩═════════╝");
        System.out.print("(Press Enter to return) ");
	}

	public void viewFliterOption() {
    	// Print the filtered and sorted camps
		System.out.println("╔══════════════════════════════════════════════════════════╗");
		ViewUtility.displayInMenuCentered(" - Filter Options - ");
		System.out.println("╠══════════════════════════════════════════════════════════╣");
		ViewUtility.displayInMenuNumbered("Filter by Date", 1);
		ViewUtility.displayInMenuNumbered("Filter by Location", 2);
		ViewUtility.displayInMenuNumbered("Sort by Name (Alphabetical Order)", 3);
		System.out.println("╚══════════════════════════════════════════════════════════╝");
	}

	public void displayEnquiries(Map<Integer, Enquiry> enquiries) {
		System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                                            ║"); 
	    System.out.println("║             ███████╗███╗   ██╗ ██████╗ ██╗   ██╗██╗██████╗ ██╗███████╗███████╗             ║");
	    System.out.println("║             ██╔════╝████╗  ██║██╔═══██╗██║   ██║██║██╔══██╗██║██╔════╝██╔════╝             ║");
	    System.out.println("║             █████╗  ██╔██╗ ██║██║   ██║██║   ██║██║██████╔╝██║█████╗  ███████╗             ║");
	    System.out.println("║             ██╔══╝  ██║╚██╗██║██║▄▄ ██║██║   ██║██║██╔══██╗██║██╔══╝  ╚════██║             ║");
	    System.out.println("║             ███████╗██║ ╚████║╚██████╔╝╚██████╔╝██║██║  ██║██║███████╗███████║             ║");
	    System.out.println("║             ╚══════╝╚═╝  ╚═══╝ ╚══▀▀═╝  ╚═════╝ ╚═╝╚═╝  ╚═╝╚═╝╚══════╝╚══════╝             ║");
        System.out.println("║                                                                                            ║");
		if (enquiries.isEmpty()) {
			System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
			System.out.println("║                                   No Enquiries to Display.                                 ║");
		} else {
			System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
			for (Enquiry enquiry : enquiries.values()) {
				ViewUtility.displayInMenuBulletLarge("Enquiry ID: " + enquiry.getEnquiryID());
				ViewUtility.displayInMenuBulletLarge("Camp Name: " + enquiry.getCampName());
				ViewUtility.displayInMenuBulletLarge("Message: " + enquiry.getEnquiryMessage());
				ViewUtility.displayInMenuBulletLarge("Status: " + enquiry.getEnquiryStatus());
				ViewUtility.displayInMenuBulletLarge("Response: " + enquiry.getEnquiryResponse());
				ViewUtility.displayInMenuBulletLarge("Responder ID: " + enquiry.getResponderID());
				System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
			}
		}
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════╝");
	}
	
	public void displayStudentEnquiries(Map<Integer, Enquiry> draftEnquiries, Map<Integer, Enquiry> submittedEnquiries, Map<Integer, Enquiry> respondedEnquiries) {
		System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                                            ║"); 
	    System.out.println("║             ███████╗███╗   ██╗ ██████╗ ██╗   ██╗██╗██████╗ ██╗███████╗███████╗             ║");
	    System.out.println("║             ██╔════╝████╗  ██║██╔═══██╗██║   ██║██║██╔══██╗██║██╔════╝██╔════╝             ║");
	    System.out.println("║             █████╗  ██╔██╗ ██║██║   ██║██║   ██║██║██████╔╝██║█████╗  ███████╗             ║");
	    System.out.println("║             ██╔══╝  ██║╚██╗██║██║▄▄ ██║██║   ██║██║██╔══██╗██║██╔══╝  ╚════██║             ║");
	    System.out.println("║             ███████╗██║ ╚████║╚██████╔╝╚██████╔╝██║██║  ██║██║███████╗███████║             ║");
	    System.out.println("║             ╚══════╝╚═╝  ╚═══╝ ╚══▀▀═╝  ╚═════╝ ╚═╝╚═╝  ╚═╝╚═╝╚══════╝╚══════╝             ║");
        System.out.println("║                                                                                            ║");
        Map<Integer, Enquiry> enquiries = null;
		for (int i = 0; i < 3; i++) {
			System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
			switch (i) {
				case 0: enquiries = draftEnquiries; 
				System.out.println("║                                   --- Draft Enquiries ---                                  ║"); break;
				case 1: enquiries = submittedEnquiries; 
				System.out.println("║                                 --- Submitted Enquiries ---                                ║"); break;
				case 2: enquiries = respondedEnquiries;
				System.out.println("║                                 --- Responded Enquiries ---                                ║"); break;
			}
			if (enquiries.isEmpty()) {
				System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
				System.out.println("║                                   No Enquiries to Display.                                 ║");
	        } else {
	        	for (Enquiry enquiry : enquiries.values()) {
			    	System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
			    	ViewUtility.displayInMenuBulletLarge("Enquiry ID: " + enquiry.getEnquiryID());
					ViewUtility.displayInMenuBulletLarge("Camp Name: " + enquiry.getCampName());
					ViewUtility.displayInMenuBulletLarge("Message: " + enquiry.getEnquiryMessage());
					ViewUtility.displayInMenuBulletLarge("Status: " + enquiry.getEnquiryStatus());
					ViewUtility.displayInMenuBulletLarge("Response: " + enquiry.getEnquiryResponse());
					ViewUtility.displayInMenuBulletLarge("Responder ID: " + enquiry.getResponderID());
			        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
			    }
	        }
		}
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════╝");
	}
	
	public void displaySuggestion(Map<Integer, Suggestion> suggestion) {

		System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════╗");
		System.out.println("║                                                                                            ║"); 
		System.out.println("║ ███████╗██╗   ██╗ ██████╗  ██████╗ ███████╗███████╗████████╗██╗ ██████╗ ███╗   ██╗███████╗ ║");
		System.out.println("║ ██╔════╝██║   ██║██╔════╝ ██╔════╝ ██╔════╝██╔════╝╚══██╔══╝██║██╔═══██╗████╗  ██║██╔════╝ ║");
		System.out.println("║ ██████╗ ██║   ██║██║  ███╗██║  ███╗█████╗  ███████╗   ██║   ██║██║   ██║██╔██╗ ██║███████╗ ║");
		System.out.println("║ ╚════██║██║   ██║██║   ██║██║   ██║██╔══╝  ╚════██║   ██║   ██║██║   ██║██║╚██╗██║╚════██║ ║");
		System.out.println("║ ███████║╚██████╔╝╚██████╔╝╚██████╔╝███████╗███████║   ██║   ██║╚██████╔╝██║ ╚████║███████║ ║");
		System.out.println("║ ╚══════╝ ╚═════╝  ╚═════╝  ╚═════╝ ╚══════╝╚══════╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝ ║");
		System.out.println("║                                                                                            ║");
		if (suggestion.isEmpty()) {
			System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
			System.out.println("║                                  No Suggestions to Display.                                ║");
		} else {
			for (Suggestion s : suggestion.values()) {
			System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
			ViewUtility.displayInMenuBulletLarge("Suggestion ID: " + s.getSuggestionID());
			ViewUtility.displayInMenuBulletLarge("Camp Name: " + s.getCampName());
			ViewUtility.displayInMenuBulletLarge("Message: " + s.getSuggestionMessage());
			ViewUtility.displayInMenuBulletLarge("Status: " + s.getSuggestionStatus());
			System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
			}
		}
		System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════╝");
	}

	public void displaySuggestions(Map<Integer, Suggestion> draftSuggestions, Map<Integer, Suggestion> submittedSuggestions,
									Map<Integer, Suggestion> acceptedSuggestions, Map<Integer, Suggestion> rejectedSuggestions) {
		
	    System.out.println("╔════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                                                                            ║"); 
	    System.out.println("║ ███████╗██╗   ██╗ ██████╗  ██████╗ ███████╗███████╗████████╗██╗ ██████╗ ███╗   ██╗███████╗ ║");
	    System.out.println("║ ██╔════╝██║   ██║██╔════╝ ██╔════╝ ██╔════╝██╔════╝╚══██╔══╝██║██╔═══██╗████╗  ██║██╔════╝ ║");
	    System.out.println("║ ██████╗ ██║   ██║██║  ███╗██║  ███╗█████╗  ███████╗   ██║   ██║██║   ██║██╔██╗ ██║███████╗ ║");
	    System.out.println("║ ╚════██║██║   ██║██║   ██║██║   ██║██╔══╝  ╚════██║   ██║   ██║██║   ██║██║╚██╗██║╚════██║ ║");
	    System.out.println("║ ███████║╚██████╔╝╚██████╔╝╚██████╔╝███████╗███████║   ██║   ██║╚██████╔╝██║ ╚████║███████║ ║");
	    System.out.println("║ ╚══════╝ ╚═════╝  ╚═════╝  ╚═════╝ ╚══════╝╚══════╝   ╚═╝   ╚═╝ ╚═════╝ ╚═╝  ╚═══╝╚══════╝ ║");
        System.out.println("║                                                                                            ║");
		Map<Integer, Suggestion> suggestions = null;
		for (int i = 0; i < 4; i++) {
			System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
			switch (i) {
				case 0: suggestions = draftSuggestions; 
				System.out.println("║                                  --- Draft Suggestions ---                                 ║"); break;
				case 1: suggestions = submittedSuggestions; 
				System.out.println("║                                --- Submitted Suggestions ---                               ║"); break;
				case 2: suggestions = acceptedSuggestions;
				System.out.println("║                                 --- Accepted Suggestions ---                               ║"); break;
				case 3: suggestions = rejectedSuggestions;
				System.out.println("║                                 --- Rejected Suggestions ---                               ║"); break;
			}
			if (suggestions.isEmpty()) {
				System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
				System.out.println("║                                  No Suggestions to Display.                                ║");
	        } else {
			    for (Suggestion suggestion : suggestions.values()) {
			    	System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
			        ViewUtility.displayInMenuBulletLarge("Suggestion ID: " + suggestion.getSuggestionID());
			        ViewUtility.displayInMenuBulletLarge("Camp Name: " + suggestion.getCampName());
			        ViewUtility.displayInMenuBulletLarge("Message: " + suggestion.getSuggestionMessage());
			        ViewUtility.displayInMenuBulletLarge("Status: " + suggestion.getSuggestionStatus());
			        System.out.println("╠════════════════════════════════════════════════════════════════════════════════════════════╣");
			    }
	        }
		}
	    System.out.println("╚════════════════════════════════════════════════════════════════════════════════════════════╝");
	}

	public void showFilterInput() {
		System.out.println("╔══════════════════════════════════════════════════════════╗");
		System.out.println("║                                                          ║");
		System.out.println("║██████╗ ███████╗██████╗  ██████╗ ██████╗ ████████╗███████╗║");
		System.out.println("║██╔══██╗██╔════╝██╔══██╗██╔═══██╗██╔══██╗╚══██╔══╝██╔════╝║");
		System.out.println("║██████╔╝█████╗  ██████╔╝██║   ██║██████╔╝   ██║   ███████╗║");
		System.out.println("║██╔══██╗██╔══╝  ██╔═══╝ ██║   ██║██╔══██╗   ██║   ╚════██║║");
		System.out.println("║██║  ██║███████╗██║     ╚██████╔╝██║  ██║   ██║   ███████║║");
		System.out.println("║╚═╝  ╚═╝╚══════╝╚═╝      ╚═════╝ ╚═╝  ╚═╝   ╚═╝   ╚══════╝║");
        System.out.println("║                                                          ║");
		System.out.println("╠══════════════════════════════════════════════════════════╣");
		ViewUtility.displayInMenuCentered(" - Choose Filters - ");
		System.out.println("╠══════════════════════════════════════════════════════════╣");
		ViewUtility.displayInMenuNumbered("No Filter", 1);
		ViewUtility.displayInMenuNumbered("Camp Information", 2);
		ViewUtility.displayInMenuNumbered("Attendee", 3);
		ViewUtility.displayInMenuNumbered("Camp Committee", 4);
		ViewUtility.displayInMenuNumbered("Location", 5);
		ViewUtility.displayInMenuNumbered("Date of Camp", 6);
		System.out.println("╚══════════════════════════════════════════════════════════╝");
	}

}
