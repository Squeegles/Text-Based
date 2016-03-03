/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Sounds {

    public static synchronized void playTitleMusic(int loopCounter) {

        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    Main.class.getResourceAsStream("media/start.wav"));
            clip.open(inputStream);
            clip.loop(loopCounter);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static synchronized void playItemPickup() {

        try {
            Clip clip = AudioSystem.getClip();
            AudioInputStream inputStream = AudioSystem.getAudioInputStream(
                    Main.class.getResourceAsStream("media/inv.wav"));
            clip.open(inputStream);
            clip.start();
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

}
