package controllers;

import java.util.Scanner;
import java.util.Map;
import java.util.List;

import interfaces.ICampStudentService;
import interfaces.ICampValidationService;
import interfaces.IEnquiryResponderService;
import interfaces.ISuggestionSenderService;
import interfaces.IReportStudentService;
import enums.MessageStatus;
import enums.UserRole;
import models.Student;
import models.Suggestion;
import models.Camp;
import models.Enquiry;
import services.CampStudentService;
import services.CampValidationService;
import services.EnquiryResponderService;
import services.SuggestionSenderService;
import services.ReportStudentService;
import stores.AuthStore;
import utility.InputSelectionUtility;
import utility.FilePathsUtility;
import views.CampCommitteeView;
import views.MessageView;

/**
 * The {@link CampCommitteeController} class is the main controller for camp committee members.
 * It extends from the {@link UserController} class to utilize {@link UserController} password related services
 * It also extends from the {@link StudentController} class to utilize {@link StudentController} related services,
 * as camp committee members can also participate in a regular student's perspective in other camps.
 * {@link CampCommitteeController} class provides the allocation of camp committee members' exclusive operations 
 * to the respective methods, on top of existing student actions that are inherited from {@link StudentController} class.
 * Such exclusive methods include responding to enquiries and generating reports.
 * It utilizes many services such as {@link ICampStudentService} interface to run student permitted 
 * camp related services to perform its desired action.
 */
public class CampCommitteeController extends StudentController {

	/**
	 * Service for handling student-related operations specific to camps.
	 */
    private final ICampStudentService campStudentService = new CampStudentService();
    
    /**
	 * Service for validating camp-related operations for the camp committee.
	 */
	private final ICampValidationService campValidationService = new CampValidationService();
	
	/**
	 * Service for handling enquiries for the camp committee.
	 */
    private final IEnquiryResponderService enquiryCampComitteeService = new EnquiryResponderService();
    
    /**
	 * Service for creating, editing and sending suggestions as a member of the camp committee.
	 */
    private final ISuggestionSenderService suggestionCampComitteeService = new SuggestionSenderService();
    
    /**
	 * Service for handling student-related report generation for the camp committee.
	 */
	private final IReportStudentService reportStudentService = new ReportStudentService();
	
	/**
	 * View responsible for displaying information to the camp committee.
	 */
	private final CampCommitteeView view = new CampCommitteeView();
	
	/**
	 * Scanner object for receiving input from the camp committee member.
	 */
	private final Scanner scanner = new Scanner(System.in);

    /**
     * Initiates the camp committee menu, allowing committee members to perform various operations.
     * The method enters a loop where it repeatedly displays the camp committee menu, takes user input,
     * and executes the corresponding operation based on the user's choice. 
     * The loop continues until the user chooses to log out.
     * Operations shared with students are inherited from {@code StudentController} class and called.
     */
    public void start() {
        Student student = (Student) AuthStore.getCurrentUser();
        while (true) {
            view.displayMenuView();

            // Checks for invalid inputs
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input!! ");
                scanner.next();
                System.out.print("Select an option: ");
            }
            int choice = scanner.nextInt();

            // Sanity Check
            if (student.getUserRole() == UserRole.COMMITTEE) {
            	// Student selection menu
	            switch (choice) {
	                case 1: 
	                    viewAllCamps();
	                    break;
	                case 2: 
	                	viewAllCampsWithFilters();
	                	break;
	                case 3:
	                	registerCamp();
	                    break;
	                case 4:
	                	withdrawCamp();
	                    break;
	                case 5:
	                	viewRemainingSlots();
	                    break;
	                case 6:
	                	viewRegisteredCamps();
	                    break;
	                case 7:
	                	submitEnquiry();
	                    break;
	                case 8:
	                	viewEnquiries();
	                    break;
	                case 9: 
	                	editEnquiry();
	                	break;
	                case 10: 
	                	deleteEnquiry();
	                	break;
	                case 11: 
	                	viewEnquiriesForCamp();
	                	break;
	                case 12: 
	                	respondToEnquiry();
	                	break;
	                case 13: 
	                	submitSuggestion();
	                	break;
	                case 14: 
	                	editSuggestion();
	                	break;
                    case 15:
                        deleteSuggestion();
                        break;
                    case 16:
                        viewSuggestions();
                        break;
                    case 17:
                    	generateReport();
                        break;
	                case 18: 
	                	// Change password
						if (changePassword()) {
                            // Restart session by logging out
                            AuthController.endSession();
                            return;
                        }
	                	break;
	                default: 
	                    System.out.println("Exiting student menu");
	                    AuthController.endSession();
	                    return;
	            }
            } 
			else{
				System.out.println("Error! Exiting student menu");
				AuthController.endSession();
			}
        }
    }

    /**
     * Displays pending enquiries for the camp committee related to their assigned camp.
     */
    protected void viewEnquiriesForCamp() {
		// Get list of Staff created camps
        Student student = (Student) AuthStore.getCurrentUser();
        Camp camp = campStudentService.getCampCommitteeCamp(student);
        if (camp == null) {
            System.out.println("You are not registered as a camp committee for any camp.");
            return;
        } 
		Map<Integer, Enquiry> campEnquiries = enquiryCampComitteeService.getAllPendingEnquiriesForCamp(camp);
		view.displayEnquiries(campEnquiries);
		MessageView.endMessage(scanner, null, true);
	}

    /**
     * Allows the camp committee member to respond to pending enquiries related to their assigned camp.
     */
	protected void respondToEnquiry() {
        Student student = (Student) AuthStore.getCurrentUser();
       
        Camp camp = campStudentService.getCampCommitteeCamp(student);
        if (camp == null) {
            System.out.println("You are not registered for any camp.");
            return;
        } 

		// Get enquiries for the selected camp
		Map<Integer, Enquiry> campEnquiries = enquiryCampComitteeService.getAllPendingEnquiriesForCamp(camp);
		// Check if there are draft enquiries to edit
		if (campEnquiries.isEmpty()) {
			System.out.println("You have no student enquiries to reply to.");
			return;
		}

		view.displayEnquiries(campEnquiries);
		// Get User input
		Enquiry selectedEnquiry = InputSelectionUtility.getSelectedEnquiry(campEnquiries);
		
		if (selectedEnquiry != null) {
			String response = InputSelectionUtility.getStringInput("Enter response: ");
	
			// Respond using EnquiryStudentService
			boolean success = enquiryCampComitteeService.respondToEnquiry(selectedEnquiry.getEnquiryID(), student.getStudentID(), MessageStatus.ACCEPTED, response);
			MessageView.endMessage(scanner, success ? "Enquiry responded successfully" : "Error responding to suggestion", true);
		}
    }

	/**
	 * Allows the camp committee member to submit a suggestion for their assigned camp
	 * for staff members to respond to.
	 */
    protected void submitSuggestion() {
		Student student = (Student) AuthStore.getCurrentUser();

		if(!campValidationService.isUserCampCommittee(student)){
			System.out.println("Only committee members can submit suggestions!");
			return;
		}
		// Get User's committee camp
		Camp committeecamp = campStudentService.getCampCommitteeCamp(student);

		// Get User input
		String campName = committeecamp.getCampInformation().getCampName();
		String suggestionMessage = InputSelectionUtility.getStringInput("Enter suggestion: ");
		// Prompt the user whether they'd like the suggestion to be saved as draft or submit
		int draftChoice = InputSelectionUtility.getIntInput("Do you want to save the suggestion as a draft or submit? (1: Draft, 2: Submit): ");
		boolean isDraft = (draftChoice == 1);
		if (!isDraft){student.incrementStudentPoints();}

		// Create a new suggestion using SuggestionStudentService
		int suggestionID = suggestionCampComitteeService.submitSuggestion(student.getStudentID(), campName, suggestionMessage, isDraft);
		String message;
		if (isDraft) message = "Suggestion draft saved with ID: " + suggestionID; else message = "Suggestion submitted with ID: " + suggestionID;
		MessageView.endMessage(scanner, message, false);
	}

    /**
     * Displays all suggestions, including drafts, submitted, accepted, and rejected, for the camp committee member.
     */
    protected void viewSuggestions() {
		Student student = (Student) AuthStore.getCurrentUser();

		if(!campValidationService.isUserCampCommittee(student)){
			System.out.println("Only committee members can view suggestions!");
			return;
		}
		// Get draft, pending and responded suggestions
		Map<Integer, Suggestion> draftSuggestions = suggestionCampComitteeService.getDraftSuggestion(student.getStudentID());
		Map<Integer, Suggestion> submittedSuggestions = suggestionCampComitteeService.getSubmittedSuggestion(student.getStudentID());
		Map<Integer, Suggestion> acceptedSuggestions = suggestionCampComitteeService.getAcceptedSuggestion(student.getStudentID());
		Map<Integer, Suggestion> rejectedSuggestions = suggestionCampComitteeService.getRejectedSuggestion(student.getStudentID());

		// Display Suggestions
		view.displaySuggestions(draftSuggestions, submittedSuggestions, acceptedSuggestions, rejectedSuggestions);
		MessageView.endMessage(scanner, null, true);
	}

    /**
     * Allows the camp committee member to edit a draft suggestion.
     *
     * @return True if the suggestion is successfully edited, false otherwise.
     */
	protected boolean editSuggestion() {
		Student student = (Student) AuthStore.getCurrentUser();

		if(!campValidationService.isUserCampCommittee(student)){
			MessageView.endMessage(scanner, "Only committee members can edit suggestions!", false);
			return false;
		}
		// Get Data
		Map<Integer, Suggestion> draftSuggestions = suggestionCampComitteeService.getDraftSuggestion(student.getStudentID());

		// Check if there are draft suggestions to edit
		if (draftSuggestions.isEmpty()) {
			MessageView.endMessage(scanner, "You have no draft suggestions to edit.", false);
			return false;
		}
		
		// Display Suggestions
		view.displaySuggestions(draftSuggestions);
		// Get User input
		Suggestion selectedSuggestion = InputSelectionUtility.getSelectedSuggestion(draftSuggestions);

		if (selectedSuggestion != null) {
			String newDetails = InputSelectionUtility.getStringInput("Enter your new suggestion: ");

			// Prompt the user whether they'd like the suggestion to be saved as draft or submit
			int draftChoice = InputSelectionUtility.getIntInput("Do you want to save the suggestion as a draft or submit? (1: Draft, 2: Submit): ");
			boolean isDraft = (draftChoice == 1);
			if (!isDraft){student.incrementStudentPoints();}

			// Edit the selected draft suggestion using SuggestionStudentService
			return suggestionCampComitteeService.editSuggestion(selectedSuggestion.getSuggestionID(), student.getStudentID(), newDetails, isDraft);
		}
		return false;
	}

	/**
	 * Allows the camp committee member to delete a draft suggestion.
	 */
	protected void deleteSuggestion() {
		Student student = (Student) AuthStore.getCurrentUser();

		if(!campValidationService.isUserCampCommittee(student)){
			MessageView.endMessage(scanner, "Only committee members can delete suggestions!", false);
			return;
		}
		// Get Data
		Map<Integer, Suggestion> draftSuggestions = suggestionCampComitteeService.getDraftSuggestion(student.getStudentID());

		// Check if there are draft suggestions to delete
		if (draftSuggestions.isEmpty()) {
			MessageView.endMessage(scanner, "You have no draft suggestions to delete.", false);
			return;
		}
		
		// Display Suggestions
		view.displaySuggestions(draftSuggestions);
		// Get User input
		Suggestion selectedSuggestion = InputSelectionUtility.getSelectedSuggestion(draftSuggestions);

		if (selectedSuggestion != null) {
			// Confirm deletion
			int confirmChoice = InputSelectionUtility.getIntInput("Are you sure you want to delete this suggestion? (1: Yes, 2: No): ");
			if (confirmChoice == 1) {
				// Delete the selected draft enquiry using EnquiryStudentService
				boolean deleted = suggestionCampComitteeService.deleteDraftSuggestion(selectedSuggestion.getSuggestionID(), student.getStudentID());
				if (deleted) {
					MessageView.endMessage(scanner, "Suggestion deleted successfully.", true);
				} else {
					MessageView.endMessage(scanner, "Failed to delete the suggestion. Please try again.", true);
				}
			} else {
				MessageView.endMessage(scanner, "Suggestion deletion canceled.", true);
			}
		}
	}

	/**
	 * Generates a report for the camp committee member based on specified filters and their assigned camp.
	 */
	protected void generateReport() {
        Student student = (Student) AuthStore.getCurrentUser();
        Camp camp = campStudentService.getCampCommitteeCamp(student);
		if (camp == null) {
			System.out.println("Invalid camp selection. Exiting From Report Generation");
			return;
		} 
		view.showFilterInput();
        List<String> filter = InputSelectionUtility.getFilterInput();
		boolean success = reportStudentService.generateReport(filter,camp,FilePathsUtility.csvFilePaths());
		MessageView.endMessage(scanner, success ? "Report generated successfully" : "Error generating report", false);
    }
}
