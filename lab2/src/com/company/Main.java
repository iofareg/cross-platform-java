package com.company;

public class Main {

    public static void main(String[] args) {
        AirlineManager a = new AirlineManager("iofareg");
        a.fillPlanes();

        System.out.println("General Passenger Capacity: " + a.CountGeneralPassengerCapacity());
        System.out.println("General Load Capacity: " + a.CountGeneralLoadCapacity());
        System.out.println("\nUnsortedPlanes\n");
        a.PrintPlanes(a.planes);
        System.out.println("\nSorting by name (ascending (A->z)):\n");
        a.PrintPlanes(a.SortByName(true));
        System.out.println("\nSorting by flight range (descending):\n");
        a.PrintPlanes(a.SortByRange(false));
        System.out.println("\nSorting by production year (ascending):\n");
        a.PrintPlanes(a.sortByProductionYear(true));
        System.out.println("\nSorting by successful flights (descending):\n");
        a.PrintPlanes(a.sortBySuccessfulFlights(false));
    }
}
