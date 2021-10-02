package com.company;

public class PassengerPlane extends Plane{
    public Integer passengerCapacity;

    @Override
    public String toString() {
        return super.toString() +
                " passenger capacity: " + passengerCapacity + ";";
    }

    public PassengerPlane(String name, Integer productionYear,
                          Integer successfulFlights,float flightRange, Integer passengerCapacity){
        super(name,productionYear,successfulFlights,flightRange,Type.Passenger);
        this.passengerCapacity=passengerCapacity;
    }

    public Integer getPassengerCapacity() {
        return passengerCapacity;
    }
}
