package Car_Rental_System;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//Vehicle Class (Abstraction):
//Create an abstract class named Vehicle with the following attributes and methods:
//        make: The make of the vehicle.
//        model: The model of the vehicle.
//        year: The manufacturing year of the vehicle.
//rentalPrice: The daily rental price of the vehicle.
abstract class Vehicle
{
    private String make;
    private String model;
    private double year ;
    private double rentalPrice ;
    public Vehicle(String make, String model,double year,double rentalPrice)
    {
        this.make = make;
        this.model = model;
        this.year = year;
        this.rentalPrice = rentalPrice;
    }
    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    public String getModel()
    {
        return model;
    }
    public void setModel(String model)
    {
        this.model = model;
    }
    public double getYear()
    {
        return year;
    }
    public void setYear(double year)
    {
        this.year = year;
    }

    public double getRentalPrice()
    {
        return rentalPrice;
    }
    public void setRentalPrice(double rentalPrice)
    {
        this.rentalPrice = rentalPrice;
    }
    public double calculateRentalCost(double numOfDays)
    {
        return rentalPrice * numOfDays;
    }
//    public String toString()
//    {
//        return ("make :" + getMake() + " madel : " + getModel() + "Year :" + getYear() + "RentalPrice : " + getRentalPrice());
//    }
}
//Create a Car class that extends the Vehicle class. Add specific attributes such as:
//numSeats: The number of seats in the car.
//        fuelType: The type of fuel the car uses.
class car extends Vehicle
{
    private int seats ;
    private String fuelType ;
    public car(String make, String model,double year,double rentalPrice, int seats , String fuelType)
    {
        super(make , model , year , rentalPrice);
        this.seats = seats;
        this.fuelType = fuelType;
    }

    public int getSeats()
    {
        return seats;
    }

    public String getFuelType()
    {
        return fuelType;
    }

    public void setSeats(int seats)
    {
        this.seats = seats;
    }

    public void setFuelType(String fuelType)
    {
        this.fuelType = fuelType;
    }
    public String toString(){
        return ("make:" + getMake() + "model:" + getModel() + "year:" + getYear()+ "rental price:" + getRentalPrice()+ "Seats:" +
                getSeats() + "fuelType" + getFuelType());
    }
}
//Customer Class (Encapsulation):
//Create a Customer class with the following encapsulated attributes:
//name: The name of the customer.
//        email: The email address of the customer.
//rentedVehicles: A list to store rented vehicles.
class Customer
{
    private String cust_name ;
    private String cust_email;
    private List<Vehicle>rentedVehicle;
    private List<Customer> customerList;
   // public List<car> carList=new ArrayList<>();

    public Customer(String cust_name ,String cust_email)
    {
        this.cust_name = cust_name;
        this.cust_email = cust_email;
       this.rentedVehicle = new ArrayList<>();
    }


    public String getCust_name()
    {
        return cust_name;
    }

    public void setCust_name(String cust_name)
    {
        this.cust_name = cust_name;
    }

    public String getCust_email()
    {
        return cust_email;
    }

    public void setCust_email(String cust_email)
    {
        this.cust_email = cust_email;
    }
    public void rentVehicle(Vehicle vehicle)
    {
        rentedVehicle.add(vehicle);
        System.out.println("rented vehicle : " + vehicle.getMake() + " " + vehicle.getModel());
    }
    public  void returnVehicle(Vehicle vehicle)
    {
        rentedVehicle.remove(vehicle);
        System.out.println("return vehicle : " + vehicle.getMake() + " " + vehicle.getModel());
    }
    public void addCustomer(Customer customer)
    {
        customerList.add(customer);
        System.out.println("customer is added");
    }

    public List<Vehicle> getRentedVehicle(){
        return rentedVehicle;
    }
}
//RentalAgency Class (Polymorphism):
//Modify the RentalAgency class to use polymorphism:
//Allow renting and returning both cars and other types of vehicles.
//Calculate rental cost based on the type of vehicle.
class RentalAgency
{
    private List<Vehicle> vehicles;
    private List<Vehicle> availableVehicle;

    public List<car> carList=new ArrayList<>();
    public RentalAgency()
    {
        this.vehicles = new ArrayList<>();
        this.availableVehicle = new ArrayList<>();
    }
    public void addcar(car car){
        carList.add(car);
    }
    public  void addVehicle(Vehicle vehicle)
    {
        availableVehicle.add(vehicle);
        System.out.println("vehicle added :" + vehicle.getMake() + " " + vehicle.getModel());
    }
//    public void setAvailableVehicle()
//    {
//        this.availableVehicle= availableVehicle;
//    }
//    public void rentVehicle(Vehicle vehicle , Customer customer , int days)
//    {
//        if(vehicles.contains(vehicle))
//        {
//            System.out.println("vehicle is availabe ");
//        }else{
//            System.out.println("please make other chaoice ");
//        }
//    }

    public void removeVehicle(Vehicle vehicle)
    {
        availableVehicle.remove(vehicle);
        System.out.println("vehicle removed: " + vehicle.getMake() + " " + vehicle.getModel());
    }

    public void rentVehicle(Vehicle vehicle , Customer customer , int days) {
        if (availableVehicle.contains(vehicle))
        {
            customer.rentVehicle(vehicle);
            double rentalCost = vehicle.calculateRentalCost(days);
            System.out.println("Total rental cost : $ "+ rentalCost);
        } else {
            System.out.println("Vehicle is not available for rental.");
        }
    }

    public void returnVehicle(Vehicle vehicle , Customer customer) {
         if(customer.getRentedVehicle().contains(vehicle)){
             customer.returnVehicle(vehicle);
         }else{
             System.out.println("vehicle not rented by customer");
         }
    }

    public List<Vehicle> getAvailableVehicle() {
        return availableVehicle;
    }
    public void displayCar()
    {
        System.out.println("all cars are :");
        for (car car1 : carList)
        {
            System.out.println(car1);
        }

    }
}
//Payment System (Abstraction):
//Implement a simple payment system:
//Create an abstract method in the Vehicle class to calculate the rental cost. Override this method in the Car class.

public class CarRentalSystem {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RentalAgency rentalAgency = new RentalAgency();
        //Customer customer = new Customer("John Doe", "johndoe@example.com");




        while (true) {
            System.out.println("--- Welcome to Car Rental System ---");
            System.out.println("--- 0 . Exit  ---");
            System.out.println("--- 1 . Add Car ---");
            System.out.println("--- 2 . Add Customer ---");
            System.out.println("--- 3 . Rent  car  ---");
            System.out.println("--- 4 . Return Car  ---");

            int n = sc.nextInt();


            if (n == 0) {
                System.out.println("Exit");
            }
            switch (n) {
                // String make, String model,double year,double rentalPrice, int seats , String fuelType
                case 1: {
                    System.out.println("enter the type of make");
                    String make = sc.next();
                    System.out.println("enter the type of model");
                    String model = sc.next();
                    System.out.println("enter the manufacture year ");
                    double year = sc.nextDouble();
                    System.out.println("enter the rentalPrice");
                    double rentalPrice = sc.nextDouble();
                    System.out.println("enter seats ");
                    int seats = sc.nextInt();
                    System.out.println("enter the fueltype ");
                    String fueltype = sc.next();
                    car car = new car(make, model, year, rentalPrice, seats, fueltype);
                    rentalAgency.addVehicle(car);
                    System.out.println("vehicle added succssfully");
                    break;

                }
                case 2://String cust_name ,String cust_email  // add customer
                {
                    System.out.println(" enter the customer name : ");
                    String cust_name = sc.next();
                    System.out.println(" enter the customer email : ");
                    String cust_email = sc.next();
                    Customer cust = new Customer(cust_name , cust_email);
                    System.out.println("customer is added ");
                    break;



                }
                case 3:// Rent Car
                {
                    System.out.println("enter the name of the customer");
                    String name = sc.next();
                    System.out.println("enter the email of the custome");
                    String email = sc.next();
                    Customer customer = new Customer(name , email );
                    System.out.println(" enter the make of the vehicle you want to rent");
                    String make = sc.next();
                    System.out.println(" enter the model of the vehicle you want to rent ");
                    String model = sc.next();
                    for (Vehicle vehicle : rentalAgency.getAvailableVehicle()) {
                        if (vehicle.getMake().equals(make) && vehicle.getModel().equals(model)) {
                            System.out.println("Enter the number of days you want to rent: ");
                            int days = sc.nextInt();
                            rentalAgency.rentVehicle(vehicle, customer, days);
                            break;
                        }

                    }
                }
                case 4:
                {
                    System.out.println("enter the name of the customer");
                    String name = sc.next();
                    System.out.println("enter the email of the custome");
                    String email = sc.next();
                    Customer customer = new Customer(name , email );
                    System.out.println("enter the make of the vehicle you want to return");
                    String make = sc.next();
                    System.out.println("enter the model of the vehicle you want to return");
                    String model = sc.next();
                    for (Vehicle vehicle : customer.getRentedVehicle()){
                        if (vehicle.getMake().equals(make) && vehicle.getModel().equals(model)) {
                            rentalAgency.returnVehicle(vehicle, customer);
                            break;
                        }
                    }
                }
                default:
                {
                    System.out.println("invalid option");
                }
            }
        }
    }
}

