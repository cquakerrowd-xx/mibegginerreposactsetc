// ==========================================
// 3. SYSTEM CONTROLLER & LOGIC HANDLER
// ==========================================

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FarmSystemManager {
    private static List<AgriculturalThreat> threatDatabase = new ArrayList<>();
    private static List<IncidentRecord> incidentRecords = new ArrayList<>();

    public static void initializeDatabase() {
        // 1. Brown Planthopper (BPH)
        threatDatabase.add(new Pest("Brown Planthopper (BPH)", 
                "It sucks the sap from rice plants, causing them to turn yellow and dry out. Severe infestation can lead to hopperburn.", 
                "Rice / Palay", 
                "Grow resistant strains, avoid nitrogen over-fertilization, plant in unison, and preserve natural predators like spiders."));

        // 2. Rice Stem Borer
        threatDatabase.add(new Pest("Rice Stem Borer", 
                "The larvae feed inside the stems of rice plants, causing damage known as deadheart and whitehead.", 
                "Rice / Palay", 
                "Destroy infected stems/egg masses, practice synchronous planting and field sanitation, and use bio-control insecticides."));

        // 3. Rice Black Bug
        threatDatabase.add(new Pest("Rice Black Bug", 
                "It sucks the sap from rice plants, which can cause yellowing, wilting, and even plant death.", 
                "Rice / Palay", 
                "Use light traps for adult bugs, manage field water levels, eliminate surrounding weeds, and conserve natural pest regulators."));

        // 4. Rice Hispa
        threatDatabase.add(new Pest("Rice Hispa", 
                "Adult beetles feed on the surface of rice leaves, while the larvae create tunnels inside the leaves.", 
                "Rice / Palay", 
                "Remove and destroy infested leaves, weed fields to eliminate hiding sites, and regularly inspect rice plants."));

        // 5. Rice Gall Midge
        threatDatabase.add(new Pest("Rice Gall Midge", 
                "Affected shoots develop into silver shoots or onion-like leaves and fail to produce normal panicles.", 
                "Rice / Palay", 
                "Cultivate tolerant rice varieties, burn plants showing silver shoots, keep fields clean, and eradicate host weeds."));

        // 6. Green Leafhopper
        threatDatabase.add(new Pest("Green Leafhopper", 
                "It sucks the sap from rice plants and transmits the tungro virus.", 
                "Rice / Palay", 
                "Plant tungro-resistant varieties, remove diseased plants and host weeds, and defend natural predator insects."));

        // 7. Golden Apple Snail
        threatDatabase.add(new Pest("Golden Apple Snail", 
                "It feeds on young rice seedlings, which can damage newly planted rice crops.", 
                "Rice / Palay", 
                "Handpick snails and pink egg masses, construct water intake barriers, and manage field water depth."));

        // 8. Aphids (Melon Aphid)
        threatDatabase.add(new Pest("Aphids (Melon Aphid)", 
                "It sucks the sap from vegetable plants, causing leaves to curl, distort, and turn yellow while transmitting plant viruses.", 
                "Vegetables", 
                "Use yellow sticky traps, rake away infested leaves/weeds, and introduce natural predators like ladybugs and lacewings."));

        // 9. Tomato Fruitworm
        threatDatabase.add(new Pest("Tomato Fruitworm", 
                "The larvae feed on tomato fruits by boring into them, causing holes and rot that render fruits unconsumable.", 
                "Tomatoes", 
                "Collect and destroy damaged fruits, inspect plants for eggs/caterpillars, use moth pheromone traps, and maintain sanitation."));

        // 10. Melon Thrips
        threatDatabase.add(new Pest("Melon Thrips", 
                "It feeds on vegetable leaves and plant parts by sucking juices, causing leaf discoloration and severe damage.", 
                "Vegetables", 
                "Remove heavily infested leaves and surrounding weeds, deploy blue/yellow sticky traps, and protect beneficial insects."));

        // 11. Fruit and Shoot Borer
        threatDatabase.add(new Pest("Fruit and Shoot Borer", 
                "Larvae bore into the shoots and fruits of vegetable crops, causing wilting of young shoots and unmarketable holes in fruits.", 
                "Eggplant / Vegetables", 
                "Prune and destroy damaged shoots and fruits regularly, use pheromone traps, and apply approved biological controls."));

        // 12. Cutworm
        threatDatabase.add(new Pest("Cutworm", 
                "Caterpillars feed at night, cutting down young vegetable seedlings right at the soil line.", 
                "Leafy Vegetables", 
                "Clear weeds around fields before planting, handpick larvae during dusk, and use physical collars around seedlings."));

        // 13. Whitefly
        threatDatabase.add(new Pest("Whitefly", 
                "Sucks plant sap and secretes honeydew, leading to sooty mold growth and transmission of plant leaf curl viruses.", 
                "Tomatoes / Peppers", 
                "Install yellow sticky cards, spray with organic insecticidal soaps, and encourage beneficial predatory wasps."));

        // 14. Root-Knot Nematode
        threatDatabase.add(new Pest("Root-Knot Nematode", 
                "Microscopic roundworms that attack plant roots, causing swellings or galls that stunt plant growth and reduce nutrient uptake.", 
                "Root Vegetables / Solanaceae", 
                "Practice crop rotation with non-host plants, apply organic compost, and solarize the soil before planting."));

        // 15. Diamondback Moth
        threatDatabase.add(new Pest("Diamondback Moth", 
                "Larvae feed on leaves of cruciferous crops, creating characteristic windowpane feeding damage and small holes.", 
                "Cabbage / Crucifers", 
                "Intercrop with aromatic herbs, use row covers on young plants, and apply biological insecticides when thresholds are met."));
    }

    public static void viewThreatDatabase(Scanner scanner) {
        System.out.println("=================================================================================================");
        System.out.println("                               COMMON AGRICULTURAL PESTS & DISEASES DIRECTORY                    ");
        System.out.println("=================================================================================================");
        
        System.out.printf("%-4s | %-43s | %-16s | %-18s%n", "No.", "Name", "Category", "Target / Pathogen");
        System.out.println("-------------------------------------------------------------------------------------------------");

        for (int i = 0; i < threatDatabase.size(); i++) {
            AgriculturalThreat threat = threatDatabase.get(i);
            System.out.printf("%-4s | %-43s | %-16s | %-18s%n", 
                    "[" + (i + 1) + "]", 
                    threat.getName(), 
                    threat.getThreatCategory(), 
                    threat.getTargetOrPathogen());
        }
        System.out.println("-------------------------------------------------------------------------------------------------");
        
        int detailChoice = -1;
        while (true) {
            System.out.print("\nWould you like to view detailed prevention guides? (Enter number 1-" + threatDatabase.size() + " or 0 to skip): ");
            String input = scanner.nextLine().trim();
            
            // If user enters nothing (just hits space or enter), default to 0 (skip/back)
            if (input.isEmpty() || input.equalsIgnoreCase("0") || input.equalsIgnoreCase("back")) {
                detailChoice = 0;
                break;
            }

            try {
                detailChoice = Integer.parseInt(input);
                if (detailChoice >= 0 && detailChoice <= threatDatabase.size()) {
                    break;
                }
                System.out.println("[!] Please enter a valid number between 0 and " + threatDatabase.size() + ".");
            } catch (NumberFormatException e) {
                System.out.println("[!] Invalid input. Please enter a number.");
            }
        }

        if (detailChoice > 0 && detailChoice <= threatDatabase.size()) {
            System.out.println();
            threatDatabase.get(detailChoice - 1).displayPreventionGuide();
        }
    }
    public static void searchIncidents(Scanner scanner) {
        System.out.println("========================================================================");
        System.out.println("                       SEARCH INCIDENT RECORDS                          ");
        System.out.println("========================================================================");

        if (incidentRecords.isEmpty()) {
            System.out.println("[!] No incident records found in the database yet.");
            return;
        }

        System.out.print("Enter keyword (Farmer's Name or Threat Name): ");
        String keyword = scanner.nextLine().toLowerCase();

        boolean found = false;
        System.out.println("\nSearch Results Table:");
        System.out.printf("%-4s | %-18s | %-22s | %-15s | %-10s%n", "ID", "Farmer Name", "Threat Name", "Location", "Status");
        System.out.println("------------------------------------------------------------------------");

        for (IncidentRecord record : incidentRecords) {
            if (record.getFarmerName().toLowerCase().contains(keyword) || 
                record.getThreatName().toLowerCase().contains(keyword)) {
                System.out.printf("%-4d | %-18s | %-22s | %-15s | %-10s%n",
                        record.getIncidentId(),
                        record.getFarmerName(),
                        record.getThreatName(),
                        record.getLocation(),
                        record.getStatus());
                found = true;
            }
        }

        if (!found) {
            System.out.println("------------------------------------------------------------------------");
            System.out.println("[!] No matching records found for: \"" + keyword + "\"");
        } else {
            System.out.println("------------------------------------------------------------------------");
        }
    }

    public static void recordNewIncident(Scanner scanner) {
        System.out.println("========================================================================");
        System.out.println("                   RECORD NEW FARM PEST / INCIDENT                      ");
        System.out.println("========================================================================");
        System.out.println("(Type '0' or 'back' at any prompt to cancel and return to menu.)");

        // 1. Farmer's Name Validation
        String name = "";
        while (true) {
            System.out.print("Enter Farmer's Name (Pangalan ng Nasalanta): ");
            name = scanner.nextLine().trim();
            if (name.equalsIgnoreCase("0") || name.equalsIgnoreCase("back")) {
                System.out.println("\n[!] Action cancelled. Returning to main menu...");
                return;
            }
            if (!name.isEmpty()) break;
            System.out.println("[!] Error: Field cannot be blank. Please try again.");
        }

        // 2. Pest/Disease Name Validation
        String threat = "";
        while (true) {
            System.out.print("Enter Pest/Disease Name (Anong klase ng peste/sakit): ");
            threat = scanner.nextLine().trim();
            if (threat.equalsIgnoreCase("0") || threat.equalsIgnoreCase("back")) {
                System.out.println("\n[!] Action cancelled. Returning to main menu...");
                return;
            }
            if (!threat.isEmpty()) break;
            System.out.println("[!] Error: Field cannot be blank. Please try again.");
        }

        // 3. Farm Location Validation
        String location = "";
        while (true) {
            System.out.print("Enter Farm Location (Saan naroon ang taniman): ");
            location = scanner.nextLine().trim();
            if (location.equalsIgnoreCase("0") || location.equalsIgnoreCase("back")) {
                System.out.println("\n[!] Action cancelled. Returning to main menu...");
                return;
            }
            if (!location.isEmpty()) break;
            System.out.println("[!] Error: Field cannot be blank. Please try again.");
        }

        // 4. Probable Cause Validation
        String cause = "";
        while (true) {
            System.out.print("Enter Probable Cause / Notes (Maaaring sanhi ng problema): ");
            cause = scanner.nextLine().trim();
            if (cause.equalsIgnoreCase("0") || cause.equalsIgnoreCase("back")) {
                System.out.println("\n[!] Action cancelled. Returning to main menu...");
                return;
            }
            if (!cause.isEmpty()) break;
            System.out.println("[!] Error: Field cannot be blank. Please try again.");
        }

        // Save record if all fields are valid
        IncidentRecord newRecord = new IncidentRecord(name, threat, location, cause);
        incidentRecords.add(newRecord);
        System.out.println("\n[+] Incident successfully recorded with ID: " + newRecord.getIncidentId());
    }

    public static void updateOrDeleteIncident(Scanner scanner) {
        System.out.println("========================================================================");
        System.out.println("                   UPDATE OR DELETE INCIDENT RECORDS                    ");
        System.out.println("========================================================================");

        if (incidentRecords.isEmpty()) {
            System.out.println("[!] No incident records available to update or delete.");
            return;
        }

        showAllIncidents();

        int id = -1;
        while (true) {
            System.out.print("\nEnter Incident ID to modify (or type 0 to cancel): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("0") || input.equalsIgnoreCase("back")) {
                System.out.println("\n[!] Action cancelled. Returning to main menu...");
                return;
            }

            try {
                id = Integer.parseInt(input);
                break; 
            } catch (NumberFormatException e) {
                System.out.println("[!] Invalid input. Please enter a valid numeric ID.");
            }
        }

        IncidentRecord target = null;
        for (IncidentRecord record : incidentRecords) {
            if (record.getIncidentId() == id) {
                target = record;
                break;
            }
        }

        if (target == null) {
            System.out.println("[!] Record with ID " + id + " not found.");
            return;
        }

        System.out.println("\nSelected Record Details:");
        System.out.println("ID            : " + target.getIncidentId());
        System.out.println("Farmer Name   : " + target.getFarmerName());
        System.out.println("Threat        : " + target.getThreatName());
        System.out.println("Location      : " + target.getLocation());
        System.out.println("Probable Cause: " + target.getProbableCause());
        System.out.println("Status        : " + target.getStatus());

        System.out.println("\nChoose Action:");
        System.out.println("1. Update Status (Pending / Resolved)");
        System.out.println("2. Edit Record Details");
        System.out.println("3. Delete Record");
        
        int action = -1;
        while (true) {
            System.out.print("Choice (1-3): ");
            String actionInput = scanner.nextLine().trim();
            try {
                action = Integer.parseInt(actionInput);
                if (action >= 1 && action <= 3) break;
                System.out.println("[!] Please enter a number between 1 and 3.");
            } catch (NumberFormatException e) {
                System.out.println("[!] Invalid input. Please enter 1, 2, or 3.");
            }
        }

        switch (action) {
            case 1:
                int statChoice = -1;
                while (true) {
                    System.out.print("Set status to (1) Resolved or (2) Pending? ");
                    String statInput = scanner.nextLine().trim();
                    try {
                        statChoice = Integer.parseInt(statInput);
                        if (statChoice == 1 || statChoice == 2) break;
                        System.out.println("[!] Please enter 1 or 2.");
                    } catch (NumberFormatException e) {
                        System.out.println("[!] Invalid input. Enter 1 or 2.");
                    }
                }
                
                if (statChoice == 1) {
                    target.setStatus("Resolved");
                    System.out.println("[+] Status updated to: Resolved");
                } else {
                    target.setStatus("Pending");
                    System.out.println("[+] Status updated to: Pending");
                }
                break;
                
            case 2:
                System.out.print("Enter new Farmer Name [" + target.getFarmerName() + "]: ");
                String fName = scanner.nextLine().trim();
                if (!fName.isEmpty()) target.setFarmerName(fName);

                System.out.print("Enter new Threat Name [" + target.getThreatName() + "]: ");
                String tName = scanner.nextLine().trim();
                if (!tName.isEmpty()) target.setThreatName(tName);

                System.out.print("Enter new Location [" + target.getLocation() + "]: ");
                String loc = scanner.nextLine().trim();
                if (!loc.isEmpty()) target.setLocation(loc);

                System.out.print("Enter new Cause [" + target.getProbableCause() + "]: ");
                String cause = scanner.nextLine().trim();
                if (!cause.isEmpty()) target.setProbableCause(cause);

                System.out.println("[+] Record updated successfully.");
                break;
                
            case 3:
                incidentRecords.remove(target);
                System.out.println("[+] Incident record successfully deleted.");
                break;
        }
    }

    public static void showAllIncidents() {
        System.out.println("========================================================================");
        System.out.println("                      ALL FARM INCIDENT RECORDS                         ");
        System.out.println("========================================================================");
        
        if (incidentRecords.isEmpty()) {
            System.out.println("No incidents recorded yet.");
            return;
        }

        System.out.printf("%-4s | %-20s | %-25s | %-20s | %-10s%n", "ID", "Farmer Name", "Threat Name", "Location", "Status");
        System.out.println("------------------------------------------------------------------------");
        for (IncidentRecord record : incidentRecords) {
            System.out.printf("%-4d | %-18s | %-22s | %-15s | %-10s%n",
                    record.getIncidentId(),
                    record.getFarmerName(),
                    record.getThreatName(),
                    record.getLocation(),
                    record.getStatus());
        }
        System.out.println("------------------------------------------------------------------------");
    }

    public static void showWeatherAdvisory() {
        LocalDate today = LocalDate.now();
        String formattedDate = today.format(DateTimeFormatter.ofPattern("MMMM dd, yyyy"));

        System.out.println("========================================================================");
        System.out.println("             PAGASA / DEPARTMENT OF AGRICULTURE BULLETIN                ");
        System.out.println(" Date: " + formattedDate + "                                             ");
        System.out.println("========================================================================");
        
        System.out.println("\n[1] WEATHER OUTLOOK & ADVISORY");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("- Status: Intermittent localized thunderstorms and heavy rains.");
        System.out.println("- Impact: High moisture levels in low-lying paddies and vegetable plots.");
        System.out.println("- Action : Clear drainage canals immediately to avoid standing water root rot.");

        System.out.println("\n[2] REGIONAL PEST & DISEASE OUTBREAK ALERTS");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("- Alert Level: ELEVATED for Fungal Blast & Rice Stem Borer.");
        System.out.println("- Regions Affected: Central Luzon and Calabarzon agricultural zones.");
        System.out.println("- Advisory   : Apply recommended organic or chemical thresholds early.");

        System.out.println("\n[3] MARKET & SUBSIDY UPDATES");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("- Fertilizer Discount Vouchers: Distributed via local Municipal Agriculture Offices.");
        System.out.println("- Weather Insurance: Free crop insurance claims processing is ongoing for registered farmers.");
        System.out.println("========================================================================");
    }
}