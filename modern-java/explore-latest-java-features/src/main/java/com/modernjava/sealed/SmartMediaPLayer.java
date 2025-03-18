package com.modernjava.sealed;

public sealed interface SmartMediaPLayer permits Car {

    void connectPhone();
}
