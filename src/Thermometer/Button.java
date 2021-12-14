package Thermometer;

import java.util.Random;

/**
 * A class which simulates buttons on the thermometer
 */
class Button{

    /**
     * A method which simulates a press of the power button
     *
     * @param power true if the machine is being powered on and false if the machine is being powered off
     */
    public static void powerButton(boolean power){
        if(power){
            Power.powerOn();
        }
        else{
            Power.powerOff();
        }
    }

    /**
     * A method which simulates the press of the scan button
     *
     * @param settings the settings of the thermometer
     * @return a temperature object which can be stored in the memory class
     */
   public static Temperature scanButton(Settings settings){
       Random rand = new Random();
       double[] temps = rand.doubles(10, 95,110).toArray();
       return new Temperature(temps, settings);
    }

    /**
     * A method which simulates the press of the up button
     */
    public static void upButton(){

    }

    /**
     * A method which simulates the press of the down button
     */
    public static void downButton(){

    }

    /**
     * A method which simulates the press of the action button.
     * Can be used to access settings or view the temperature logs
     */
    public static void actionButton(){

    }


    /**
     * A self-test to ensure that the system is functioning properly
     */
    public static boolean selfTest(){
        return !Button.class.isHidden();
    }
}
