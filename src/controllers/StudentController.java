package controllers;

import java.util.Scanner;
<<<<<<< HEAD

import enums.UserRole;
import views.StudentView;
import interfaces.ICampStudentService;
import models.Student;
import services.CampStudentService;
import stores.AuthStore;

=======
import views.StudentView;
import interfaces.ICampStudentService;
import models.Student;
import services.CampStudentService;
import stores.AuthStore;

>>>>>>> hq
public class StudentController extends UserController {
	public void start() {
    	Scanner scanner = new Scanner(System.in);
        Student student = (Student) AuthStore.getCurrentUser();
        CampStudentService service = new CampStudentService();

	    StudentView view = new StudentView();
	    while (true) {
            view.displayMenuView();

            
            // Checks for invalid inputs
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input!! ");
                scanner.next();
                System.out.print("Select an option: ");
            }

            int choice = scanner.nextInt();
<<<<<<< HEAD
            
            if (student.getUserRole() == UserRole.STUDENT) {
            	// Student selection menu
	            switch (choice) {
	                case 1: // View all camps viewable by Student
	                    service.viewAllCamps();
	                    break;
	                case 2: // View all camps viewable by Student with Filters
	                	service.viewAllCampsWithFilters();
	                	break;
	                case 3:
	                	service.registerCamp();
	                    break;
	                case 4:
	                	service.withdrawCamp();
	                    break;
	                case 5:
	                	service.viewRemainingSlots();
	                    break;
	                case 6:
	                	service.registerAsCommittee();
	                    break;
	                case 7:
	                	System.out.println("Cannot withdraw from Committee");
	                	//controller.campStudentService.withdrawFromCommittee();
	                    break;
	                case 8:
	                	service.viewRegisteredCamps();
	                    break;
	                case 9: 
	                	//controller.campStudentService.submitEnquiry();
	                	break;
	                case 10: 
	                	//controller.campStudentService.viewEnquiries();
	                	break;
	                case 11: 
	                	//controller.campStudentService.editEnquiry();
	                	break;
	                case 12: 
	                	//controller.campStudentService.deleteEnquiry();
	                	break;
	                case 13: 
	                	// Change password
						super.changePassword();
	                	break;
	                default: 
	                    System.out.println("Exiting student menu");
	                    AuthController.endSession();
	                    return;
	            }
            } else if (student.getUserRole() == UserRole.COMMITTEE) {
            	// Student selection menu
	            switch (choice) {
		            case 1: // View all camps viewable by Student
	                    service.viewAllCamps();
	                    break;
	                case 2: // View all camps viewable by Student with Filters
	                	service.viewAllCampsWithFilters();
	                	break;
	                case 3:
	                	service.registerCamp();
	                    break;
	                case 4:
	                	service.withdrawCamp();
	                    break;
	                case 5:
	                	service.viewRemainingSlots();
	                    break;
	                case 6:
	                	service.registerAsCommittee();
	                    break;
	                case 7:
	                	System.out.println("Cannot withdraw from Committee");
	                	//controller.campStudentService.withdrawFromCommittee();
	                    break;
	                case 8:
	                	service.viewRegisteredCamps();
	                    break;
	                case 9: 
	                	//controller.campStudentService.submitEnquiry();
	                	break;
	                case 10: 
	                	//controller.campStudentService.viewEnquiries();
	                	break;
	                case 11: 
	                	//controller.campStudentService.editEnquiry();
	                	break;
	                case 12: 
	                	//controller.campStudentService.deleteEnquiry();
	                	break;
	                case 13: 
	                	//Change password
						super.changePassword();
	                	break;
	                case 14:
	                	// View enquiries for camp
	                	break;
	                case 15:
	                	// Reply enquiries for camp
	                	break;
	                case 16:
	                	// View suggestion for camp
	                	break;
	                case 17:
	                	// Edit suggestion for camp
	                	break;
	                case 18:
	                	// Delete suggestion for camp
	                	break;
	                case 19:
	                	// Submit suggestion for camp
	                	break;
	                case 20:
	                	// Generate camp report
	                	break;
	                default: 
	                    System.out.println("Exiting student menu");
	                    AuthController.endSession();
	                    return;
	            }
=======
            scanner.nextLine();

            // choice  // fix this @ ojing
        
            switch (choice) {
                case 1:
                    //controller.campStudentService.viewAllCamps(null, null, null);
                    break;
                case 2: 
                	//controller.campStudentService.viewAllCampsWithFilters();
                	break;
                case 3:
                	service.registerCamp();
                    break;
                case 4:
                	service.withdrawCamp();
                    break;
                case 5:
                	//controller.campStudentService.viewRemainingSlots();
                    break;
                case 6:
                	service.registerAsCommittee();
                    break;
                case 7:
                	//controller.campStudentService.withdrawFromCommittee();
                    break;
                case 8:
                	//controller.campStudentService.viewRegisteredCamps();
                    break;
                case 9: 
                	service.submitEnquiry();
                	break;
                case 10: 
                	service.viewEnquiries();
                	break;
                case 11: 
                	service.editEnquiry();
                	break;
                case 12: 
                	service.deleteEnquiry();
                	break;
                case 13: 
                	service.viewEnquiriesForCamp();
                	break;
                case 14: 
                	service.respondEnquiry();
                	break;
                case 15:
                    service.submitSuggestion();
                    break;
                case 16:
                    service.viewSuggestions();
                    break;
                case 17:
                    service.editSuggestion();
                    break;
                case 18:
                    service.deleteSuggestion();
                    break;
                default: 
                    System.out.println("Exiting student menu");
                    AuthController.endSession();
                    return;
               
>>>>>>> hq
            }
             
        }
    }
}
