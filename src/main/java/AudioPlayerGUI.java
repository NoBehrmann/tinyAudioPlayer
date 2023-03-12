import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.io.File;

public class AudioPlayerGUI extends JFrame {

    private  JFileChooser fc = new JFileChooser();
    private AudioPlayer ap = new AudioPlayer();
    public AudioPlayerGUI() {
        super("Audio Player");
        ap = new AudioPlayer();
        fc = new JFileChooser();
        JPanel buttonPanel = new JPanel();
        // Buttons
        JButton openButton = new JButton("Open");
        JButton stopButton = new JButton("Stop");
        JButton pauseButton = new JButton("Pause");
        JButton playButton = new JButton("Play");
        JButton[] buttons = new JButton[]{openButton,playButton, pauseButton, stopButton};


        // open button
        openButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setFileFilter(new FileNameExtensionFilter("Audio-Dateien", "wav", "mp3"));
            if (fileChooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                try {
                    ap.load(selectedFile.getPath());
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        });
        // play button
        playButton.addActionListener(e -> {
            try {
                AudioPlayer.play();
            } catch (Exception ex) {
                throw new RuntimeException(ex);
            }
        });
        // pause button
        pauseButton.addActionListener(e -> AudioPlayer.pause());
        // stop button
        stopButton.addActionListener(e -> AudioPlayer.stop());

        // Changing color of buttons and apply to buttonPanel
        for (JButton button : buttons) {
            button.setFocusPainted(false);
            button.setBackground(Color.DARK_GRAY);
            button.setForeground(Color.white);
            button.setBorder(BorderFactory.createEtchedBorder(1));
            buttonPanel.add(button);
        }
        buttonPanel.setBackground(Color.DARK_GRAY);
        // Frame
        this.setIconImage(new ImageIcon("libs\\4812505.png").getImage());
        this.getContentPane().setBackground(Color.DARK_GRAY);
        getContentPane().add(buttonPanel, BorderLayout.CENTER);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }


    public static void main(String[] args) {
        new AudioPlayerGUI();
    }
}
