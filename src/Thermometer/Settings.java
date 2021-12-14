package Thermometer;


/**
 * A class containing all the settings in the thermometer
 */
class Settings{
    /**
     * A char fahrenheit which represents the Fahrenheit temperature unit
     */
    private static final char fahrenheit = 'F';
    /**
     * A char celsius which represents the Celsius temperature unit
     */
    private static final char celsius = 'C';
    /**
     * A double which represents the upper limit of what the thermometer will define as a fever.
     * Can be changed by the user
     */
    private double upperFeverLimit;
    /**
     * A double which represents the lower limit of what the thermometer will define as a fever.
     * Can be changed by the user
     */
    private double lowerFeverLimit;
    /**
     * One of either of the two chars specified above that will define which unit the thermometer will display
     * the temperature in
     */
    private char tempUnit;

    /**
     * A settings constructor
     *
     * @param setToDefault a boolean which returns true if the fever limits and temperature unit should be set to their defaults
     */
    public Settings(boolean setToDefault){
        if(setToDefault){
            toDefault();
        }
        else{
            //set previously configured settings from storage on the device
        }
    }

    /**
     * Sets all the variables to default values if no user settings are found
     */
    private void toDefault(){
        this.tempUnit=fahrenheit;
        this.upperFeverLimit=100.4;
        this.lowerFeverLimit = 97.0;
    }

    public double getUpperFeverLimit() {
        return upperFeverLimit;
    }

    public double getLowerFeverLimit() {
        return lowerFeverLimit;
    }

    public char getTempUnit() {
        return tempUnit;
    }

    public void setLowerFeverLimit(double lowerFeverLimit) {
        this.lowerFeverLimit = lowerFeverLimit;
    }

    public void setUpperFeverLimit(double upperFeverLimit) {
        this.upperFeverLimit = upperFeverLimit;
    }

    public void setTempUnit(char tempUnit) {
        this.tempUnit = tempUnit;
    }

    public static char getCelsius() {
        return celsius;
    }

    public static char getFahrenheit() {
        return fahrenheit;
    }


    public static boolean selfTest(){
        return Settings.class.getPackageName().equals("Thermometer");
    }
}
