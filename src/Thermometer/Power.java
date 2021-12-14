package Thermometer;

/**
 * A class to control the power and self-test methods for the system
 */
class Power{
    /**
     * Is true if the unit is powered on and false if the unit is powered off
     */
    private static boolean power = false;
    /**
     * A string which is sent to the Display class to be shown on the display
     */
    private static String toDisplay = "";

    /**
     * A method to power on the unit and run the self-test
     */
    static void powerOn(){
        if(selfTest()){
            power = true;
        }
        try {
            Thread.sleep(3000);
            toDisplay = "Self-test complete";
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * A boolean which tests if all the parts of the system of functioning properly
     *
     * @return true if the self-test passes and false if the self-test fails
     */
    static boolean selfTest(){
        boolean test = true;
        if(!Memory.selfTest()){
            test = false;
            System.err.println("Memory class is broken");
        }
        if(!Sound.selfTest()){
            test = false;
            System.err.println("Sound class is broken");
        }if(!Temperature.selfTest()){
            test = false;
            System.err.println("Temperature class is broken");
        }if(!Settings.selfTest()){
            test = false;
            System.err.println("Settings class is broken");
        }if(!Display.selfTest()){
            test = false;
            System.err.println("Display class is broken");
        }if(!Button.selfTest()){
            test = false;
            System.err.println("Button class is broken");
        }
        return test;
    }

    /**
     * A method which powers off the unit and runs the self-test
     */
    static void powerOff(){
        toDisplay="Powering off, please wait for self-test to finish";

        if(selfTest()){
            power = false;
        }
    }

    public static String getToDisplay() {
        return toDisplay;
    }
}