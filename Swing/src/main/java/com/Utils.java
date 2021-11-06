package com;

import org.apache.commons.io.FileUtils;

import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.TargetDataLine;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

public class Utils {
    /**
     *
     * @param path: path from resources folder
     */
    public static ImageIcon getMainImage(String path) {
        BufferedImage img = null;
        try {
            img = ImageIO.read(getResource(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image imgd = img.getScaledInstance(640, 360, Image.SCALE_SMOOTH);
        return new ImageIcon(imgd);
    }

    public static File getResource(String path) {
        try {
            InputStream cpResource = Client.class.getClassLoader().getResourceAsStream(path);
            File file = File.createTempFile("file", "temp");
            FileUtils.copyInputStreamToFile(cpResource, file); // FileUtils from apache-io
            return file;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void playWavSound(String sound) {
        try {
            InputStream is = Client.class.getClassLoader().getResourceAsStream("sounds/"+sound);
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new BufferedInputStream(is));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
            // If you want the sound to loop infinitely, then put: clip.loop(Clip.LOOP_CONTINUOUSLY);
            // If you want to stop the sound, then use clip.stop();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
