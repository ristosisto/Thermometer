package Thermometer;


import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class Test {

    Settings settings;
    Display display;
    Memory memory;
    Temperature temperature;

    @org.junit.jupiter.api.BeforeEach
    void setUp() {
        settings = new Settings(true);
        display = new Display("test", settings);
        memory = new Memory();
    }

    @org.junit.jupiter.api.AfterEach
    void tearDown() {
        settings = null;
        display = null;
        memory = null;
        temperature = null;
    }

    @org.junit.jupiter.api.Test
    void powerOn_SelfTest() {
        boolean bool;
        Power.powerOn();
        if(!Power.isPower()){
            bool = false;
        }else if(!Power.selfTest()){
            bool=false;
        }
        else{
            bool = true;
        }
        assertTrue(bool);
    }

    @org.junit.jupiter.api.Test
    void temperatureMeasurement(){
        Random rand = new Random();
        double[] temps = rand.doubles(10, 95,105).toArray();
        temperature = new Temperature(temps,settings);
        if(temperature.getAverageTemperature()> settings.getUpperFeverLimit() || temperature.getAverageTemperature() < settings.getLowerFeverLimit()){
            assertTrue(temperature.isFever());
        }
        else{
            assertFalse(temperature.isFever());
        }
    }

    @org.junit.jupiter.api.Test
    void powerOff_SelfTest(){
        boolean bool;
        Power.powerOn();
        Power.powerOff();
        if(Power.isPower()){
            bool = false;
        }else if(!Power.selfTest()){
            bool=false;
        }
        else{
            bool = true;
        }
        assertTrue(bool);
    }
}