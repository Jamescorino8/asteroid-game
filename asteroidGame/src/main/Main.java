package main;

import javax.swing.JFrame;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        JFrame window = new JFrame();
        // close Jframe when worldX is pressed
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // user cannot change size of Jframe
        window.setResizable(false);
        // title of window
        window.setTitle("My Window");

        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);

        //fit to size of Jframe
        window.pack();

        // location of Jframe
        window.setLocationRelativeTo(null);
        // if Jframe is visible or not
        window.setVisible(true);

        gamePanel.startGameThread();

    }
}