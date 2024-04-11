import java.util.ArrayList;
import java.util.Scanner;

public class VehicleManagement {
   public static void main(String[] args) {
      ArrayList<Vehicle> vehicleList = new ArrayList<>();
      Scanner key = new Scanner(System.in);
   
      int choice;
      do {
         System.out.println("Menu:");
         System.out.println("1. Add a vehicle");
         System.out.println("2. Display a list of vehicle details");
         System.out.println("3. Delete a vehicle");
         System.out.println("4. Sort vehicle list by age");
         System.out.println("5. Quit");
         System.out.print("Enter your choice: ");
         choice = key.nextInt();
         key.nextLine(); 
      
         switch (choice) {
            case 1:
               addVehicle(vehicleList, key);
               break;
            case 2:
               displayVehicleList(vehicleList);
               break;
            case 3:
               deleteVehicle(vehicleList, key);
               break;
            case 4:
               sortVehicleListByAge(vehicleList, key);
               break;
            case 5:
               System.out.println("Exiting program...");
               break;
            default:
               System.out.println("Invalid choice. Please try again.");
         }
      } while (choice != 5);
   
      key.close();
   }

    // Method to add a new vehicle to the list
   public static void addVehicle(ArrayList<Vehicle> vehicleList, Scanner key) {
      System.out.print("Enter Registration number: ");
      String regNo = key.nextLine();
      System.out.print("Enter manufacturer: ");
      String make = key.nextLine();
      System.out.print("Enter year of manufacture: ");
      int yearOfManufacture = key.nextInt();
      System.out.print("Enter value: ");
      double value = key.nextDouble();
      key.nextLine();
   
      Vehicle vehicle = new Vehicle(regNo, make, yearOfManufacture, value);
      vehicleList.add(vehicle);
      System.out.println("Vehicle added successfully.");
   }

    // Method to display details of all vehicles in the list
   public static void displayVehicleList(ArrayList<Vehicle> vehicleList) {
      if (vehicleList.isEmpty()) {
         System.out.println("No vehicles in the list.");
         return;
      }
   
      System.out.println("List of Vehicle Details:");
      for (Vehicle vehicle : vehicleList) {
         System.out.println(vehicle);
      }
   }

    // Method to delete a vehicle from the list
   public static void deleteVehicle(ArrayList<Vehicle> vehicleList, Scanner key) {
      if (vehicleList.isEmpty()) {
         System.out.println("No vehicles in the list to delete.");
         return;
      }
   
      System.out.println("Select the vehicle to delete by entering its index:");
      for (int i = 0; i < vehicleList.size(); i++) {
         System.out.println((i + 1) + ". " + vehicleList.get(i));
      }
      System.out.print("Enter the index of the vehicle to delete: ");
      int indexToDelete = key.nextInt();
      key.nextLine();
   
      if (indexToDelete < 1 || indexToDelete > vehicleList.size()) {
         System.out.println("Invalid index. Please enter a valid index.");
         return;
      }
   
      vehicleList.remove(indexToDelete - 1);
      System.out.println("Vehicle deleted successfully.");
   }
   
  // Method to sort the vehicle list by age
   public static void sortVehicleListByAge(ArrayList<Vehicle> vehicleList, Scanner key) {
      if (vehicleList.isEmpty()) {
         System.out.println("No vehicles in the list to sort.");
         return;
      }
   
      int choice;
      do {
         System.out.println("Sort Menu:");
         System.out.println("1. Sort by age (Ascending)");
         System.out.println("2. Sort by age (Descending)");
         System.out.println("3. Back to main menu");
         System.out.print("Enter your choice: ");
         choice = key.nextInt();
         key.nextLine(); 
      
         switch (choice) {
            case 1:
               vehicleList.sort((v1, v2) -> v1.calculateAge(2024) - v2.calculateAge(2024));
               System.out.println("Vehicle list sorted by age in ascending order.");
               displayVehicleList(vehicleList);
               break;
            case 2:
               vehicleList.sort((v1, v2) -> v2.calculateAge(2024) - v1.calculateAge(2024));
               System.out.println("Vehicle list sorted by age in descending order.");
               displayVehicleList(vehicleList);
               break;
            case 3:
               System.out.println("Returning to main menu...");
               break;
            default:
               System.out.println("Invalid choice. Please try again.");
         }
      } while (choice != 3);
   }
}
