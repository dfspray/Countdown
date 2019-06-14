/* This file contains the countdown interface items*/

import java.awt.Font;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.SwingConstants;
import java.util.*;
import java.text.*;


public class BasicCountdown {

    public static void main(String[] args) {

        JLabel daysLeft = new TimeLeft("days");
        JLabel hoursLeft = new TimeLeft("hours");
        JLabel minutesLeft = new TimeLeft("minutes");
        JLabel secondsLeft = new TimeLeft("seconds");

        /*Image panel config*/
        JPanel imagePanel = new JPanel();
        String imagePath = System.getProperty("user.dir") + "\\Java\\jpg\\Andrey.jpg";
        ImageIcon image1 = new ImageIcon(imagePath);
        JLabel imageLabel = new JLabel(image1);
        imagePanel.add(imageLabel);
        imagePanel.setBackground(Color.blue);
        imagePanel.setSize(400, 100);

        /*Time panel config*/
        JPanel timePanel = new JPanel();
        timePanel.add(daysLeft);
        timePanel.add(hoursLeft);
        timePanel.add(minutesLeft);
        timePanel.add(secondsLeft);
        timePanel.setBackground(Color.blue);
        timePanel.setSize(400, 50);

        /*Freedom panel config*/
        JLabel byeMessage = new JLabel("TO FREEDOM!");
        byeMessage.setHorizontalAlignment(SwingConstants.CENTER);
        byeMessage.setFont(new Font("arial", Font.PLAIN, 20));
        byeMessage.setForeground(Color.white);
        JPanel freedomPanel = new JPanel();
        freedomPanel.add(byeMessage);
        freedomPanel.setBackground(Color.blue);
        freedomPanel.setSize(400, 50);

        /*JFrame settings*/
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Andrey's Final Countdown!");
        frame.setSize(400, 235);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        /*Adding panels to frame*/
        frame.add(imagePanel, BorderLayout.NORTH);
        frame.add(timePanel, BorderLayout.CENTER);
        frame.add(freedomPanel, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}

class TimeLeft extends JLabel implements ActionListener {

    String type;
    SimpleDateFormat sdf;
    int divisor;
    int time_remainder;
    String component;

    public TimeLeft(String type) {

        this.type = type;
        setForeground(Color.white);

        switch (type) {
            case "days"     :   divisor = 1000*60*60*24;
                                time_remainder = 1;
                                component = "Days";
                                setFont(new Font("arial", Font.PLAIN, 20));
                                setHorizontalAlignment(SwingConstants.CENTER);
                                setVerticalAlignment(SwingConstants.CENTER);
                                break;
            case "hours"    :   divisor = 1000*60*60;
                                time_remainder = 24;
                                component = "Hours";
                                setFont(new Font("arial", Font.PLAIN, 20));
                                setHorizontalAlignment(SwingConstants.CENTER);
                                break;
            case "minutes"  :   divisor = 1000*60;
                                time_remainder = 60;
                                component = "Minutes";
                                setFont(new Font("arial", Font.PLAIN, 20));
                                setHorizontalAlignment(SwingConstants.CENTER);
                                break;
            case "seconds"  :   divisor = 1000;
                                time_remainder = 60;
                                component = "Seconds";
                                setFont(new Font("arial", Font.PLAIN, 20));
                                setHorizontalAlignment(SwingConstants.CENTER);
                                break;
        }

        Timer t = new Timer(1000, this);
        t.start();
    }

    public void actionPerformed(ActionEvent ae) {
        Date dateNow = new Date();
        Date dateEnd = new Date(119, 4, 28, 23, 30, 00);
        long difference = dateEnd.getTime() - dateNow.getTime();
        if (time_remainder == 1) {
            long timeCalc = (difference / divisor);
            String timeCalcString = String.format("%d %s", timeCalc, component);
            setText(timeCalcString);
        } else {
            long timeCalc = (difference / divisor) % time_remainder;
            String timeCalcString = String.format("%d %s", timeCalc, component);
            setText(timeCalcString);
        }
    }
}
