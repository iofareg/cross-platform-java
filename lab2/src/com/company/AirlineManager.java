package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AirlineManager {
    public String name;
    public ArrayList<Plane> planes = new ArrayList<>();

    public AirlineManager(String name){
        this.name=name;
    }

    public void fillPlanes(){
        this.planes.add(new CargoPlane("AIRBUS A300 B4F",1982,
                320,1820,43000));
        this.planes.add(new CargoPlane("ANTONOV AN-12",1952,
                600,5500,18000));
        this.planes.add(new CargoPlane("ANTONOV AN-124",1999,
                409,6000,120000));
        this.planes.add(new CargoPlane("BAE ATP CARGO",1990,
                469,3800,8200));
        this.planes.add(new PassengerPlane("Airbus A320neo",
                2015,305,5000,236));
        this.planes.add(new PassengerPlane("Airbus A330neo",
                2019,87,5500,285));
        this.planes.add(new PassengerPlane("Boeing 737MAX",
                2017,178,5750,350));
        this.planes.add(new PassengerPlane("ATR 72-500",
                2012,432,4000,70));
    }

    public void PrintPlanes(List<Plane> ps){
        for (Plane p:ps) {
            System.out.println(p.toString());
        }
    }

    public List<PassengerPlane> FindPassengerPlanes(){
        List<PassengerPlane> pp = new ArrayList<>();
        for (Plane p:planes) {
            if (p instanceof PassengerPlane){
                pp.add((PassengerPlane)p);
            }
        }
        return pp;
    }

    public List<CargoPlane> FindCargoPlanes(){
        List<CargoPlane> cp = new ArrayList<>();
        for (Plane p:planes) {
            if (p instanceof CargoPlane){
                cp.add((CargoPlane)p);
            }
        }
        return cp;
    }

    public int CountGeneralPassengerCapacity(){
        int generalPassengerCapacity;
        List<PassengerPlane> pp = FindPassengerPlanes();
        generalPassengerCapacity = pp.stream().mapToInt(PassengerPlane::getPassengerCapacity).sum();
        return generalPassengerCapacity;
    }

    public double CountGeneralLoadCapacity(){
        double generalLoadCapacity;
        List<CargoPlane> cp = FindCargoPlanes();
        generalLoadCapacity = cp.stream().mapToDouble(plane -> (double) plane.getLoadCapacity()).sum();
        return generalLoadCapacity;
    }

    public static class NameComparator implements Comparator<Plane> {
        @Override
        public int compare(Plane p1, Plane p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }

    class RangeComparator implements Comparator<Plane>{
        @Override
        public int compare(Plane p1, Plane p2){
            return Float.compare(p1.getFlightRange(), p2.getFlightRange());
        }
    }
    //public inner
    public List<Plane> SortByRange(boolean ascending){
        List<Plane> copyPlanes = new ArrayList<>(planes);
        copyPlanes.sort(ascending ? new RangeComparator() : Collections.reverseOrder(new RangeComparator()));
        return copyPlanes;
    }
    //static public inner
    public List<Plane> SortByName(boolean ascending){
        List<Plane> copyPlanes = new ArrayList<>(planes);
        copyPlanes.sort(ascending ? new NameComparator() : Collections.reverseOrder(new NameComparator()));
        return copyPlanes;
    }

    // anonymous
    public List<Plane> sortByProductionYear(boolean ascending) {
        List<Plane> copyPlanes = new ArrayList<>(planes);
        copyPlanes.sort( new Comparator<>() {
            @Override
            public int compare(Plane p1, Plane p2) {
                int res = Integer.compare(p1.getProductionYear(), p2.getProductionYear());
                return ascending ? res : -res;
            }
        });
        return copyPlanes;
    }
    public List<Plane> sortBySuccessfulFlights(boolean ascending) {
        List<Plane> copyPlanes = new ArrayList<>(planes);
        copyPlanes.sort((p1, p2) -> {
            int res = Integer.compare(p1.getSuccessfulFlights(), p2.getSuccessfulFlights());
            return ascending ? res : -res;
        });
        return copyPlanes;
    }
}

