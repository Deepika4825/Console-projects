public class Vehicle {

    int id;
    String name;
    String numberPlate;
    double rentPerDay;
    boolean available;

    public Vehicle(int id, String name, String numberPlate, double rentPerDay) {
        this.id = id;
        this.name = name;
        this.numberPlate = numberPlate;
        this.rentPerDay = rentPerDay;
        this.available = true;
    }

    public void display() {
        System.out.println("----------------------------");
        System.out.println("ID : " + id);
        System.out.println("Name : " + name);
        System.out.println("Number Plate : " + numberPlate);
        System.out.println("Rent : " + rentPerDay);
        System.out.println("Available : " + available);
    }
}