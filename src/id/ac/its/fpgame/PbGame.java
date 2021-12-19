package id.ac.its.fpgame;

import java.awt.*;
import java.awt.event.*;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
public class PbGame extends JFrame{
   
	static MenuPanel mp = new MenuPanel();
    static HelpPanel hp = new HelpPanel();
    static GamePanel gp = new GamePanel();
    static LevelPanel lp = new LevelPanel();
    static CardLayout cl = new CardLayout();
    static JPanel cards = new JPanel(); 
   
    PbGame(){
       
        cards.setLayout(cl);
        cards.add(mp, "MenuPanel");
        cards.add(hp, "HelpPanel");
        cards.add(gp, "GamePanel");
        cards.add(lp, "LevelPanel");
        
        cl.show(cards, "MenuPanel");
        add(cards); 
       
        setTitle("panen buah");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setSize(1080, 720); 
        setVisible(true);    
    }
    
    
   	
public static void main(String args[]){
        new PbGame();
        
    }
}