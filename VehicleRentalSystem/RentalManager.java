public class RentalManager {

    public void rentVehicle(Vehicle v) {

        if (v.available) {
            v.available = false;
            System.out.println("Vehicle Rented Successfully");
        } else {
            System.out.println("Vehicle Not Available");
        }
    }

    public void returnVehicle(Vehicle v) {

        v.available = true;
        System.out.println("Vehicle Returned");
    }
}