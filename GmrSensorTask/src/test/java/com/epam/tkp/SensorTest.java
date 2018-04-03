package com.epam.tkp;

import org.junit.Test;

import com.epam.tkp.sensor.Sensor;

public class SensorTest {

    @Test
    public void testSineOutput() {
        Sensor sensor = new Sensor();
        double angle = 30;
        sensor.sentAngle(angle);
        double sinOutput = sensor.getSensorSinData();
        System.out.println("LOG: Result voltage=" + sinOutput + "\n");
    }

    @Test
    public void testCosineOutput() {
        Sensor sensor = new Sensor();
        double angle = 100;
        sensor.sentAngle(angle);
        double cosOutput = sensor.getSensorCosData();
        System.out.println("LOG: Result voltage=" + cosOutput + "\n");
    }

}
