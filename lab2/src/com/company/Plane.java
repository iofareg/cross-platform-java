package com.company;

public class Plane {
    public String name;
    public Integer productionYear;
    public Integer successfulFlights;
    public float flightRange;
    public enum Type {
        Passenger,
        Cargo
    }
    public Type type;
//    public String Land(){
//        return "Landing";
//    }
//    public String TakeOff(){
//        return "Taking off";
//    }


    @Override
    public String toString() {
        return type.toString() + " Plane " + '\'' + name + '\'' +
                ", production year: " + productionYear +
                ", successful flights: " + successfulFlights +
                ", flight range: " + flightRange +
                ",";
    }

    public Plane(String name, Integer productionYear, Integer successfulFlights, float flightRange, Type type){
        this.name=name;
        this.productionYear=productionYear;
        this.successfulFlights=successfulFlights;
        this.flightRange=flightRange;
        this.type=type;
    }

    public float getFlightRange() {
        return flightRange;
    }

    public String getName() {
        return name;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public Integer getSuccessfulFlights() {
        return successfulFlights;
    }
}
