package Thermometer;

class Power{
  static boolean power;
    public static powerOn(){

        if (power == true){

            selfTest();
        }
    }


    //test button, power, temperature, display, memory, sound, settings, erro/log
    // if all the class passed, then good to go.
    public boolean selfTest(){
        boolean passed;

        if (passed = true){
            return true;

        }else {
            return false;
        }

    }
    // shutdown all the activity
    public boolean powerOff(){
        return power = false;

    }
}
