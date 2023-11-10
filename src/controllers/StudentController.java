package controllers;

import java.util.Scanner;
import views.StudentView;
import interfaces.ICampStudentService;
import models.Student;
import services.CampStudentService;
import stores.AuthStore;

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
                	//controller.campStudentService.viewEnquiriesForCamp();
                	break;
                case 14: 
                	//controller.campStudentService.submitSuggestion();
                	break;
                default: 
                    System.out.println("Exiting student menu");
                    AuthController.endSession();
                    return;
               
            }
             
        }
    }
}
