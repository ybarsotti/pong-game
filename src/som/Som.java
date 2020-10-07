package som;

import java.io.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class Som {
    public void intro(String caminho) {
        String fimDeJogoPath = "";

        File musicPath = new File(caminho);

        try {
            if (musicPath.exists()) {
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicPath);
                Clip clip = AudioSystem.getClip();
                clip.open(audioInput);
                clip.start();
                clip.loop(Clip.LOOP_CONTINUOUSLY);

            } else {
                System.out.println("NAO FOI POSSIVEL ENCONTRAR O SOM");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

