
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class AudioPlayer {

    private static Clip clip;

    public void load(String filePath) throws Exception {
        File file = new File(filePath);
        if (!file.exists() || !file.isFile()) {
            throw new Exception("Datei nicht gefunden: " + filePath);
        }

        clip = AudioSystem.getClip();
        clip.open(AudioSystem.getAudioInputStream(file));
    }

    public static void play() throws Exception {
        if (clip == null) {
            throw new Exception("Keine Datei geladen.");
        }

        clip.start();
    }

    public static void pause() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public static void stop() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

}
