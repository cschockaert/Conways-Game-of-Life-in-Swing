/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gameoflife;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

/**
 *
 * @author mmylavar
 */
public class GameOfLife {

    static int genCounter = 0;

    static Grid grid = new Grid(100, 100);
 static Integer gen = 0;
    static GameController controller = new GameController(grid);
    
    static Timer timer = new Timer(1000, new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            controller.getNextGen();
            controller.repaint();
            genCounter++;
            if (genCounter == gen) {
                timer.stop();
            }

        }
    });

    public static void main(String[] args) {
        JLabel namelabel = new JLabel("Enter number of generation ");
        final JTextField genTextField = new JTextField(10);
        JButton playButton = new JButton("Play");

        playButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                gen = Integer.parseInt(genTextField.getText());
                timer.start();
            }
        });

        JFrame frame = new JFrame();
        controller.add(namelabel);
        controller.add(genTextField);
        controller.add(playButton);

        frame.getContentPane().add(controller);

        // frame.setSize(1600, 840); 
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);

    }
}
