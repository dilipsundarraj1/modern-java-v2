package com.modernjava.sealed;

public non-sealed class Car extends Vehicle implements SmartMediaPLayer {
    @Override
    public String drive() {
        return "CAR";
    }

    @Override
    public void connectPhone() {
        System.out.println("Phone Connected");
    }
}

//public sealed class Car extends Vehicle permits FlyingCar { }

