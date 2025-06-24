package GameSelection;

import java.awt.*;
import javax.swing.*;

public class GameSelectionWindow {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Game Selection");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);

        // Create buttons
        JButton spaceInvaderButton = new JButton("Launch Space Invader");
        JButton pacmanButton = new JButton("Launch Pacman");
        JButton flappyBirdButton = new JButton("Launch Flappy Bird");
        JButton minesweeperButton = new JButton("Launch Minesweeper");

        // Set font
        Font buttonFont = new Font("Arial", Font.PLAIN, 16);
        spaceInvaderButton.setFont(buttonFont);
        pacmanButton.setFont(buttonFont);
        flappyBirdButton.setFont(buttonFont);
        minesweeperButton.setFont(buttonFont);

        // Button actions
        spaceInvaderButton.addActionListener(e -> launchGame("SpaceInvader.App", frame));
        pacmanButton.addActionListener(e -> launchGame("PacMan.App", frame));
        flappyBirdButton.addActionListener(e -> launchGame("FlappyBird.App", frame));
        minesweeperButton.addActionListener(e -> launchGame("Minesweeper.App", frame));

        // Layout
        frame.setLayout(new GridLayout(4, 1, 10, 10)); // Updated to 4 rows
        frame.add(spaceInvaderButton);
        frame.add(pacmanButton);
        frame.add(flappyBirdButton);
        frame.add(minesweeperButton);

        frame.setLocationRelativeTo(null); // Center the window
        frame.setVisible(true);
    }

    public static void launchGame(String gameClass, JFrame frame) {
        frame.dispose(); // Close the Game Selection Window

        try {
            Process process = new ProcessBuilder("java", gameClass).start();
            process.waitFor(); // Wait for the game to finish
            main(new String[0]); // Relaunch Game Selection Window
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
