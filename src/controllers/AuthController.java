package controllers;

import java.util.Scanner;

import interfaces.IAuthService;
import models.User;
import services.AuthStudentService;
import stores.AuthStore;
import services.AuthStaffService;
import views.AuthView;
import utility.InputSelectionUtility;


/**
 *  class provides utility methods for managing user authentication within the application. 
 * It offers methods to start and end user sessions, as well as handle user login and logout. This
 * class utilizes the IAuthService interface for handling the
 * authentication process.
 */
public class AuthController {
    
    private static final Scanner sc = new Scanner(System.in);

    private static IAuthService authService;

    
    private AuthController() {};

    /**
     * Starts a user session by prompting the user to select their role and
     * enter their credentials. The method loops until valid credentials are
     * provided or the system is shut down.
     */
    public static void startSession() {
        int choice;
        boolean authenticated = false;
        AuthView view = new AuthView();
        view.displayMenuView();
        do {
<<<<<<< HEAD
        	choice = InputSelectionUtility.getIntInput("Enter your user type: ");

            switch (choice) {
=======
            while (true) {
                System.out.println("<Enter 0 to EXIT>\n");
                System.out.println("Login as:");
                System.out.println("1. Student");
                System.out.println("2. Staff");

                String input = sc.nextLine();

                if (input.matches("[0-9]+")) { // If the input is an integer, proceed with the code
                    choice = Integer.parseInt(input);

                    if (choice < 0 || choice > 3) {
                        System.out.println("Invalid input. Please enter 0-3!");
                    } else {
                        break;
                    }
                } else { // If the input is not an integer, prompt the user to enter again
                    System.out.println("Invalid input. Please enter an integer.\n");
                }

            }

            switch (choice) {
                case 0:
                    System.out.println("Shutting down CAMs...");
                    authService = null; // Set authService to null    
                    return;
>>>>>>> hq
                case 1:
                    authService = new AuthStaffService();
                    break;
                case 2:
                    authService = new AuthStudentService();
                    break;
                case 3:
                    System.out.println("Shutting down CAMs...");
                    AuthView.quitApp();
                    authService = null; // Set authService to null    
                    return;
        	}

            String userID, password;

            System.out.print("UserID: ");
            userID = sc.nextLine();

            System.out.print("Password: ");
            password = sc.nextLine();

            authenticated = authService.login(userID, password);
            if (!authenticated) {
                // We do not specify whether the userID or password is incorrect to make it more
                // secure
                System.out.println("Credentials invalid! Note that UserID and Password are case-sensitive.\n");
            }

            if(authenticated){
                User user = (User) AuthStore.getCurrentUser();
                if(!user.getIsPasswordChanged()){
                    System.out.println("Please Change the Default Password.\n");
                    UserController.changePassword();
                    user.setIsPasswordChanged(true);
                }
            }

        } while (!authenticated);
    }

    /**
     * Ends the current user session by logging the user out and displaying a
     * logout message.
     */
    public static void endSession() {
        // Check if authService is not null before calling methods on it
        if (authService != null) {
            authService.logout();
<<<<<<< HEAD
            System.out.println("User logged out successfully. (Press Enter)");
=======
            System.out.println("User logged out successfully.");
>>>>>>> hq
        } else {
            System.out.println("Error: AuthService is null.");
        }

        // Reset the input stream (System.in) to avoid potential issues
        sc.nextLine();
    }
}