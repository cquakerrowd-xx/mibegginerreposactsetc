import java.util.Scanner;

public class MainCropSystem {
    private static Scanner scanner = new Scanner(System.in);
    
    public static void main(String[] args) {
        // Initialize static data databases via the manager
        FarmSystemManager.initializeDatabase();

        char choice;
        do {
      
            printHeader();
            printMenu();
            System.out.print("Enter your choice (A-F, or 0 to exit): ");
            
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) {
                choice = ' ';
            } else {
                choice = Character.toLowerCase(input.charAt(0));
            }

            switch (choice) {
                case 'a':
                    FarmSystemManager.viewThreatDatabase(scanner);
                    break;
                case 'b':
                    FarmSystemManager.searchIncidents(scanner);
                    break;
                case 'c':
                    FarmSystemManager.recordNewIncident(scanner);
                    break;
                case 'd':
                    FarmSystemManager.updateOrDeleteIncident(scanner);
                    break;
                case 'e':
                    FarmSystemManager.showAllIncidents();
                    break;
                case 'f':
                    FarmSystemManager.showWeatherAdvisory();
                    break;
                case '0':
                    System.out.println("\nThank you for using the Crop Pest & Disease Management System. Mabuhay ang Magsasakang Pilipino!");
                    break;
                default:
                    System.out.println("\n[!] Invalid option. Please choose between 'a' and 'f', or '0' to exit.");
            }
            
            // Only prompt to continue if the user didn't choose to exit ('0')
            if (choice != '0') {
                System.out.print("\nPress Enter to return to the main menu...");
                scanner.nextLine();
            }
            
        } while (choice != '0');
        
        scanner.close(); // Clean up scanner resource on exit
    }

    private static void printHeader() {
        System.out.println("========================================================================");
        System.out.println("           CROP PESTS MANAGEMENT INFORMATION SYSTEM (CPDIIS)            ");
        System.out.println("                    Para sa mga Magsasakang Pilipino                    ");
        System.out.println("========================================================================");
    }

    private static void printMenu() {
        System.out.println("[A] View Common Pests & Diseases Directory");
        System.out.println("[B] Search Incident Records");
        System.out.println("[C] Record a New Pest/Disease Incident");
        System.out.println("[D] Update or Delete Incident Records");
        System.out.println("[E] Show All Incident Records");
        System.out.println("[F] Farm Weather & Outbreak Advisory Bulletin");
        System.out.println("[0] Exit System");
        System.out.println("------------------------------------------------------------------------");
    }
}