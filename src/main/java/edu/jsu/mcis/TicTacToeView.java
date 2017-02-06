/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.jsu.mcis;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

/**
 *
 * @author sarah
 */
public class TicTacToeView extends JFrame {

    TicTacToeModel model;
    public JButton[] ButtonArray = new JButton[9];
    private boolean xTurn = true;
    public JLabel resultLabel;

    public TicTacToeView(TicTacToeModel Model){

        model = Model;
        this.setTitle("Tic Tac Toe");
        this.setSize(new Dimension(350, 400));
        setUpWindow();
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    private class ButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            JButton button = (JButton) event.getSource();
            if (button.getText().length() == 0) {
                if (model.xTurn) {
                    button.setText("X");
                } else {
                    button.setText("O");
                }
                model.setMark(Integer.parseInt(button.getName().substring(8, 9)), Integer.parseInt(button.getName().substring(9)));
            }

        }
    }

    private void setUpWindow() {
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");

        JPanel ButtonPanel = new JPanel();
        GridLayout grid = new GridLayout(0, 3);

        for (int i = 0; i < 9; i++) {
            ButtonArray[i] = new JButton();
            ButtonArray[i].setPreferredSize(new Dimension(100, 100));
            ButtonPanel.add(ButtonArray[i]);
        }

        ButtonPanel.add(resultLabel);
        ButtonArray[0].setName("Location00");
        ButtonArray[1].setName("Location01");
        ButtonArray[2].setName("Location02");
        ButtonArray[3].setName("Location10");
        ButtonArray[4].setName("Location11");
        ButtonArray[5].setName("Location12");
        ButtonArray[6].setName("Location20");
        ButtonArray[7].setName("Location21");
        ButtonArray[8].setName("Location22");
        ButtonPanel.setLayout(grid);
        this.add(ButtonPanel);

        for (int i = 0; i < 9; i++) {
            ButtonArray[i].addActionListener(new ButtonListener());

        }

    }
}
