package com.modernjava.sealed;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {

    @Test
    void vehicle() {
        var car = new Car();
        var truck = new Truck();
        assertInstanceOf(Vehicle.class, car);
        assertInstanceOf(Vehicle.class, truck);
    }

    @Test
    void flyingCar() {
        var flyingCar = new FlyingCar();
        assertInstanceOf(Car.class, flyingCar);
    }

    @Test
    void drive() {
        var car = new Car();
        var truck = new Truck();
        assertInstanceOf(Vehicle.class, car);
        assertEquals("CAR",car.drive());
        assertEquals("TRUCK",truck.drive());

        assertInstanceOf(Vehicle.class, truck);
    }



}