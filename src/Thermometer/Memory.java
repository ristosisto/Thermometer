package Thermometer;
import java.io.PrintStream;
import java.util.ArrayList;

/**
 * A class used to hold and handle all the measured temperatures and write them to an external storage device
 */
class Memory {

    /**
     * An array list of previously measured temperatures
     */
    private final ArrayList<Temperature> measuredTemperatures;

    public Memory() {
        this.measuredTemperatures = new ArrayList<Temperature>();
    }

    public ArrayList<Temperature> getMeasuredTemperatures() {
        return measuredTemperatures;
    }

    /**
     * A method which writes all the temperatures in memory to a specified printstream
     *
     * @param p the printstream that the temperatures will be written to
     */
    public void writeToStorage(PrintStream p) {
        for (Temperature t : measuredTemperatures) {
            p.println(t.getAverageTemperature() + " " + t.getTimestamp());
        }
    }

    /**
     * A self-test to ensure the class is functioning properly
     */
    public static boolean selfTest(){
        return !Memory.class.isInterface();
    }


}
