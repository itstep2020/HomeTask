package com.itstep.hometask.dyack;

/**
 * Created by Dyachuk Sergei on 07.11.2014.
 */
import javax.sound.sampled.*;
import java.io.*;
import java.util.logging.*;

public class Sound implements Runnable {

    String filename;
    AudioInputStream ais;
    Thread t;
    int sleep;
    int count;

    public Sound(String filename, int sleep, int count) {
        this.filename = filename;
        this.sleep = sleep;
        this.count = count;
        t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            this.initialize();
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException ex) {
                Logger.getLogger(Sound.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void initialize() {
        try {
            ais = AudioSystem.getAudioInputStream(new File(filename));
        } catch (Exception e) {
            t.stop();
            System.err.println("Exception in initializing." + e);
        }

        AudioFormat format = ais.getFormat();
        SourceDataLine line = null;
        DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);

        try {
            line = (SourceDataLine) AudioSystem.getLine(info);
            line.open(format);
            line.start();

            int nBytesRead = 0;
            byte[] abData = new byte[128000];
            while (nBytesRead != -1) {
                try {
                    nBytesRead = ais.read(abData, 0, abData.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (nBytesRead >= 0) {
                    line.write(abData, 0, nBytesRead);
                }
            }
        } catch (Exception e) {
            System.err.println("Exception in inintializing. getting line. " + e);
        }
        line.drain();
        line.close();
    }
}

