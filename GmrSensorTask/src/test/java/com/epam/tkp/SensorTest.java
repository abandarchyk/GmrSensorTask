package com.epam.tkp;

import org.junit.Test;

import com.epam.tkp.sensor.Sensor;

public class SensorTest {

    @Test
    public void testSineOutput(){
        Sensor sensor = new Sensor();
        double angle = 100;
        sensor.sentAngle(angle);
        double sinOutput = sensor.getSensorSinData();
        System.out.println("Angle="+angle+" degrees. Sine voltage="+ sinOutput);
    }
    
    @Test
    public void testCosineOutput(){
        Sensor sensor = new Sensor();
        double angle = 100;
        sensor.sentAngle(angle);
        double cosOutput = sensor.getSensorCosData();
        System.out.println("Angle="+angle+" degrees. Cosine voltage="+ cosOutput);
    }
    
}
