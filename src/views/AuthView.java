package views;

import interfaces.IMenuView;
<<<<<<< HEAD
import utility.ViewUtility;
=======
import models.Camp;
>>>>>>> hq

public class AuthView implements IMenuView {


	@Override
	public void displayMenuView() {
<<<<<<< HEAD
		ViewUtility.clearScreen();
		System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                          ║");   
		System.out.println("║             ██████╗ █████╗ ███╗   ███╗███████╗           ║");
		System.out.println("║            ██╔════╝██╔══██╗████╗ ████║██╔════╝           ║");
		System.out.println("║            ██║     ███████║██╔████╔██║███████╗           ║");
		System.out.println("║            ██║     ██╔══██║██║╚██╔╝██║╚════██║           ║");
		System.out.println("║            ╚██████╗██║  ██║██║ ╚═╝ ██║███████║           ║");
		System.out.println("║             ╚═════╝╚═╝  ╚═╝╚═╝     ╚═╝╚══════╝           ║");
        System.out.println("║                                                          ║");                                      
=======

        /* 
		System.out.println("-----------------------------------");
        System.out.println("|           Login Screen          |");
        System.out.println("|---------------------------------|");
        System.out.println("| 1. Login as Staff               |");
        System.out.println("| 2. Login as Student Bob         |");
        System.out.println("| 3. Quit                         |");
        System.out.println("-----------------------------------");
        System.out.print("Select an option: ");
        */
        
        System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                                                          ║");
        System.out.println("║          ░█████╗░░█████╗░███╗░░░███╗░██████╗             ║");
        System.out.println("║          ██╔══██╗██╔══██╗████╗░████║██╔════╝             ║");
        System.out.println("║          ██║░░╚═╝███████║██╔████╔██║╚█████╗░             ║");
        System.out.println("║          ██║░░██╗██╔══██║██║╚██╔╝██║░╚═══██╗             ║");
        System.out.println("║          ╚█████╔╝██║░░██║██║░╚═╝░██║██████╔╝             ║");
        System.out.println("║           ░╚════╝░╚═╝░░╚═╝╚═╝░░░░░╚═╝╚═════╝░            ║");                                      
>>>>>>> hq
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║                    - User Selection -                    ║");
        System.out.println("╠══════════════════════════════════════════════════════════╣");
        System.out.println("║[1] Staff Login                                           ║");
        System.out.println("║[2] Student Login                                         ║");
        System.out.println("║[3] Quit                                                  ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
	}
	
	public static void quitApp() {
		System.out.println();
		System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                Thank you for using CAMS!!                ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
	}
    
	public static void staffLoginView() {
		System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                      - Staff Login -                     ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
	}
	
	public static void studentLoginView() {
		System.out.println("╔══════════════════════════════════════════════════════════╗");
        System.out.println("║                     - Student Login -                    ║");
        System.out.println("╚══════════════════════════════════════════════════════════╝");
	}
    
}
