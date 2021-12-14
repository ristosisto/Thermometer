package Thermometer;

import javax.sound.sampled.LineUnavailableException;
import javax.swing.*;
import java.util.InputMismatchException;
import java.util.Objects;
import java.util.Scanner;


/**
 * The main method where the main program is run
 */
class Main{

    /**
     * The method where the program is run
     */
    static void main3(){
        Settings settings = new Settings(true);
        Display display = new Display("Press the Power Button to power on the machine", settings);
        Memory memory = new Memory();
        JFrame frame = new JFrame("Group Z Thermometer");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setSize(700,100);
        frame.setLocationRelativeTo(null);
        frame.add(display);
        frame.setVisible(true);
        StringBuilder scan = null;
        boolean power = true;
        while(power){
            try {
                Thread.sleep(100);
                scan = new StringBuilder("Please wait while the temperature is being measured");

                if(display.isScanning()){
                    for (int i = 0; i < 5; i++) {

                        Thread.sleep(1000);
                        display.setToDisplay(scan.toString());
                        frame.repaint();
                        scan.append(".");
                    }
                    try {
                        Sound.tone(600, 200);
                    } catch (LineUnavailableException e) {
                        e.printStackTrace();
                    }
                    display.setScanning(false);
                    memory.getMeasuredTemperatures().add(display.scan()); //adds the temperature object from scanning to the memory list
                }
                frame.repaint();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        main3();
    }

}
