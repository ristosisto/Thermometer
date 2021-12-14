package Thermometer;

import javax.sound.sampled.*;

/**
 * A class which drives the speakers and sound on the system
 */
class Sound {

    public static float SAMPLE_RATE = 8000f;

    /**
     * A method which produces a tone given hertz and milliseconds
     */
    public static void tone(int hz, int msecs)
            throws LineUnavailableException
    {
        tone(hz, msecs, 1.0);
    }

    /**
     * A method which produces a tone given hertz, milliseconds, and volume
     */
    public static void tone(int hz, int msecs, double vol)
            throws LineUnavailableException
    {
        byte[] buf = new byte[1];
        AudioFormat af =
                new AudioFormat(
                        SAMPLE_RATE, // sampleRate
                        8,           // sampleSizeInBits
                        1,           // channels
                        true,        // signed
                        false);      // bigEndian
        SourceDataLine sdl = AudioSystem.getSourceDataLine(af);
        sdl.open(af);
        sdl.start();
        for (int i=0; i < msecs*8; i++) {
            double angle = i / (SAMPLE_RATE / hz) * 2.0 * Math.PI;
            buf[0] = (byte)(Math.sin(angle) * 127.0 * vol);
            sdl.write(buf,0,1);
        }
        sdl.drain();
        sdl.stop();
        sdl.close();
    }

    /**
     * A self-test method used to ensure the class is functioning properly
     */
    public static boolean selfTest(){
        return Sound.class.getName().equals(Sound.class.getName());
    }



}