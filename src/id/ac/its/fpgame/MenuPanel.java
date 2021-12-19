package id.ac.its.fpgame;

import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URL;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
 
class MenuPanel extends JPanel{
 
    JButton play = new JButton("");
    JButton level = new JButton("");
    JButton help = new JButton("");
    JButton exit = new JButton("");
   
    Image menubkg = new ImageIcon (this.getClass().getResource("background.jpg")).getImage();
   
    ImageIcon playbtn = new ImageIcon (this.getClass().getResource ("play.png"));
    ImageIcon levelbtn = new ImageIcon (this.getClass().getResource ("level.png"));
    ImageIcon helpbtn = new ImageIcon (this.getClass().getResource ("help.png"));
    ImageIcon exitbtn = new ImageIcon (this.getClass().getResource ("exit.png"));
 
    JPanel center = new JPanel();
   
    MenuPanel(){
       
        center.setLayout(new BoxLayout(center,BoxLayout.Y_AXIS)); 
        add(center);
       
        play.setIcon(playbtn);
        level.setIcon(levelbtn);
        help.setIcon(helpbtn);
        exit.setIcon(exitbtn);
       
        center.add(play);
        center.add(level);
        center.add(help);
        center.add(exit);
               
        play.addMouseListener(new Click());
        level.addMouseListener(new Click());
        help.addMouseListener(new Click());
        exit.addMouseListener(new Click());
       
    }
   
    class Click extends MouseAdapter{
        public void mouseClicked(MouseEvent me){
            if(me.getSource()== play){
                PbGame.cl.show(PbGame.cards, "GamePanel");
            }
            if(me.getSource()== level){
                PbGame.cl.show(PbGame.cards, "LevelPanel");
            }
            if(me.getSource()== help){
                PbGame.cl.show(PbGame.cards, "HelpPanel");
            }  
            if(me.getSource()== exit){
                System.exit(0);
            }
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        setFocusable(true);
       
        g2d.drawImage(menubkg, 0,0, null);
        repaint();
    }
}