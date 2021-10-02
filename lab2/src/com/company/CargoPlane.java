package com.company;

public class CargoPlane extends Plane{
    public float loadCapacity;

    @Override
    public String toString() {
        return super.toString() +
                " load capacity: " + loadCapacity + ";";
    }

    public CargoPlane(String name, Integer productionYear,
                      Integer successfulFlights,float flightRange, float loadCapacity){
        super(name,productionYear,successfulFlights,flightRange,Type.Cargo);
        this.loadCapacity=loadCapacity;
    }

    public float getLoadCapacity() {
        return loadCapacity;
    }
}
