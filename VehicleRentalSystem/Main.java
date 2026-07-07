import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VehicleManager manager = new VehicleManager();
        RentalManager rental = new RentalManager();

        while (true) {

            System.out.println("\n===== Vehicle Rental System =====");
            System.out.println("1. Add Vehicle");
            System.out.println("2. View Vehicles");
            System.out.println("3. Rent Vehicle");
            System.out.println("4. Return Vehicle");
            System.out.println("5. Delete Vehicle");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.print("Enter Vehicle Type(Car/Bike): ");
                    String type = sc.next();

                    System.out.print("ID: ");
                    int id = sc.nextInt();

                    System.out.print("Name: ");
                    String name = sc.next();

                    System.out.print("Number Plate: ");
                    String plate = sc.next();

                    System.out.print("Rent Per Day: ");
                    double rent = sc.nextDouble();

                    if (type.equalsIgnoreCase("Car")) {
                        manager.addVehicle(new Car(id, name, plate, rent));
                    } else {
                        manager.addVehicle(new Bike(id, name, plate, rent));
                    }

                    break;

                case 2:

                    manager.showVehicles();
                    break;

                case 3:

                    System.out.print("Enter Vehicle ID: ");
                    id = sc.nextInt();

                    Vehicle v = manager.searchVehicle(id);

                    if (v != null)
                        rental.rentVehicle(v);
                    else
                        System.out.println("Vehicle Not Found");

                    break;

                case 4:

                    System.out.print("Enter Vehicle ID: ");
                    id = sc.nextInt();

                    v = manager.searchVehicle(id);

                    if (v != null)
                        rental.returnVehicle(v);
                    else
                        System.out.println("Vehicle Not Found");

                    break;

                case 5:

                    System.out.print("Enter Vehicle ID: ");
                    id = sc.nextInt();

                    manager.deleteVehicle(id);

                    break;

                case 6:

                    System.out.println("Thank You");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");
            }
        }
    }
}