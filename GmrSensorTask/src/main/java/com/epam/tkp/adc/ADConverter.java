package com.epam.tkp.adc;

import java.util.Arrays;

public class ADConverter {

    int bits = 16;
    int refererenceVoltage = 5;

    public double getAdcValue(double inputVoltage) {

        int[] register = { 0, 0, 0, 0 };

        register = init(register);

        double dacVoltage = generateVoltage(register);

        for (int i = 0; i < register.length; i++) {

            int comparatorResult = compareVoltage(inputVoltage, dacVoltage);
            register = processComparatorResult(i, comparatorResult, register);
            dacVoltage = generateVoltage(register);
        }
        return dacVoltage;
    }

    // DAC

    public double generateVoltage(int[] register) {
        String array = convertToString(register);
        double digitalVoltage = (double) Integer.parseInt(array, 2);
        
        System.out.println("Digital scale: " + digitalVoltage);
        double weight = digitalVoltage / bits;
        System.out.println("Weight: " + weight);
        double dacOutput = refererenceVoltage * weight;
        System.out.println("DAC voltage: " + dacOutput);
        System.out.println();
        return dacOutput;
    }

    // Register //

    private int[] init(int[] register) {
        register[0] = 1;
        System.out.println("Register: setting 1 to MSB:" + Arrays.toString(register));
        return register;
    }

    public int[] processComparatorResult(int currentIndex, int comparisonResult, int[] register) {
         if (comparisonResult == 0) {
            register[currentIndex] = 0;
        }
        if ((currentIndex + 1) < register.length) {
             register[currentIndex + 1] = 1;
        }
        System.out.println("Register:" + Arrays.toString(register));
        return register;
    }

    public int compareVoltage(double inputVoltage, double dacVoltage) {
        int result = 0;
        if (inputVoltage > dacVoltage) {
            result = 1;
        } else if (inputVoltage < dacVoltage) {
            result = 0;
        }
        System.out.println("Comparator ( Vin=" + inputVoltage + ", Vdac=" + dacVoltage + ") result: " + result);
        return result;
    }
    
    private String convertToString(int[] register) {
        StringBuffer buf = new StringBuffer();
        for (int i = 0; i < register.length; i++) {
            buf.append(register[i]);
        }
        return buf.toString();
    }

    public static void main(String[] args) {
        ADConverter adc = new ADConverter();
        double result = adc.getAdcValue(3);
        System.out.println(result);

    }

}
