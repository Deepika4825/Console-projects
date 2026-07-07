import java.util.ArrayList;

public class VehicleManager {

    ArrayList<Vehicle> vehicles = new ArrayList<>();

    public void addVehicle(Vehicle v) {
        vehicles.add(v);
        System.out.println("Vehicle Added Successfully");
    }

    public void showVehicles() {

        if (vehicles.size() == 0) {
            System.out.println("No Vehicles Available");
            return;
        }

        for (Vehicle v : vehicles) {
            v.display();
        }
    }

    public Vehicle searchVehicle(int id) {

        for (Vehicle v : vehicles) {
            if (v.id == id) {
                return v;
            }
        }

        return null;
    }

    public void deleteVehicle(int id) {

        Vehicle v = searchVehicle(id);

        if (v != null) {
            vehicles.remove(v);
            System.out.println("Vehicle Deleted");
        } else {
            System.out.println("Vehicle Not Found");
        }
    }
}