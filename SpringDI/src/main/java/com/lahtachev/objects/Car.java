package com.lahtachev.objects;

public class Car {
    private String carName;
    private Engine engine;

    public Car(String carName, Engine engine) {
        this.carName = carName;
        this.engine = engine;
        System.out.println("Car.Car");
    }

    public Engine getEngine() {
        System.out.println("engine = " + engine);
        return engine;
    }

    public String getCarName() {
        System.out.println("carName = " + carName);
        return carName;
    }
}
