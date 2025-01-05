package org.example;

import java.sql.*;
import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        TruckService truckService = new TruckService();

        Truck tata = new Truck("TATA", "2019", 1000, "Rajesh");
        Truck volvo = new Truck("Volvo", "2023", 1000, "Akash");
        Truck eicher = new Truck("Eicher", "2022", 1000, "Harshit");


       //add truck in truckService means adding truck into database
        System.out.println("Adding data....");
        truckService.addTruck(tata);
        truckService.addTruck(volvo);
        truckService.addTruck(eicher);

        //how to read the data (fetch)
        System.out.println("Fetching data by id: ........"+1);
        Truck truck = truckService.getTruckById(1);
        System.out.println("Truck data: "+truck);

        //updating truck data
        System.out.println("Updating data....");
       truck.setDriverName("Ramesh");
       truckService.updateTruck(truck);
        System.out.println("Updated truck data: "+truckService.getTruckById(1));

        //get all truck data
        System.out.println("Fetching all data......");
        List<Truck> allTrucks = truckService.getAllTrucks();
        System.out.println("All trucks in DB: ");
      //  System.out.println(allTrucks);
        // or one by one printing trucksdata using foreach loop
        for(Truck truck1 : allTrucks)
        {
            System.out.println(truck1);
        }

        //delete truck data
        System.out.println("Deleting data by id: ...."+2);
         truckService.deleteTruck(2);
        System.out.println("Data deleted by Id: "+2);

        // then finally print all trucks to check
        System.out.println("Finally get all data.....");
       allTrucks = truckService.getAllTrucks();
        System.out.println("All trucks after all operations :");
        System.out.println(allTrucks);





                   // OR //






//        //for adding performing operations using switch case

        
//        // Create a Scanner for user input
//        Scanner sc = new Scanner(System.in);
//        int operation = sc.nextInt();
//
//        // Infinite loop for operations
//        while (true) {
//            // Print options
//            System.out.println("\n--- Truck Service Menu ---");
//            System.out.println("1. Add Truck");
//            System.out.println("2. Fetch Truck by ID");
//            System.out.println("3. Update Truck");
//            System.out.println("4. Get All Trucks");
//            System.out.println("5. Delete Truck by ID");
//            System.out.println("6. Exit");
//            System.out.print("Enter your choice: ");
//            operation = sc.nextInt();
//
//            switch (operation) {
//                case 1:
//                    // Add truck
//                    System.out.println("Enter truck details to add.");
//                    System.out.print("Brand: ");
//                    String brand = sc.next();
//                    System.out.print("Year: ");
//                    String year = sc.next();
//                    System.out.print("Weight Capacity: ");
//                    int weightCapacity = sc.nextInt();
//                    System.out.print("Owner Name: ");
//                    String owner = sc.next();
//                    Truck newTruck = new Truck(brand, year, weightCapacity, owner);
//                    truckService.addTruck(newTruck);
//                    System.out.println("Truck added successfully.");
//                    break;
//
//                case 2:
//                    // Fetch truck by ID
//                    System.out.print("Enter the truck ID to fetch: ");
//                    int fetchId = sc.nextInt();
//                    Truck fetchedTruck = truckService.getTruckById(fetchId);
//                    if (fetchedTruck != null) {
//                        System.out.println("Fetched truck data: " + fetchedTruck);
//                    } else {
//                        System.out.println("Truck with ID " + fetchId + " not found.");
//                    }
//                    break;
//
//                case 3:
//                    // Update truck
//                    System.out.print("Enter the truck ID to update: ");
//                    int updateId = sc.nextInt();
//                    Truck updateTruck = truckService.getTruckById(updateId);
//                    if (updateTruck != null) {
//                        System.out.print("Enter new driver name: ");
//                        String newDriverName = sc.next();
//                        updateTruck.setDriverName(newDriverName);
//                        truckService.updateTruck(updateTruck);
//                        System.out.println("Truck updated successfully.");
//                    } else {
//                        System.out.println("Truck with ID " + updateId + " not found.");
//                    }
//                    break;
//
//                case 4:
//                    // Get all trucks
//                    System.out.println("Fetching all trucks...");
//                    List<Truck> allTrucks = truckService.getAllTrucks();
//                    if (allTrucks.isEmpty()) {
//                        System.out.println("No trucks found.");
//                    } else {
//                        System.out.println("All trucks in DB:");
//                        for (Truck truck : allTrucks) {
//                            System.out.println(truck);
//                        }
//                    }
//                    break;
//
//                case 5:
//                    // Delete truck by ID
//                    System.out.print("Enter the truck ID to delete: ");
//                    int deleteId = sc.nextInt();
//                    truckService.deleteTruck(deleteId);
//                    System.out.println("Truck with ID " + deleteId + " deleted successfully.");
//                    break;
//
//                case 6:
//                    // Exit
//                    System.out.println("Exiting the program.");
//                    sc.close();  // Close scanner when exiting
//                    return;  // Exit the loop and the program
//
//                default:
//                    System.out.println("Invalid choice. Please try again.");
//            }
//
//
//
//            }

        }
    }

