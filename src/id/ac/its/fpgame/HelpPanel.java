package id.ac.its.fpgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
import java.awt.Color;
import java.awt.Font;
 
class HelpPanel extends JPanel{
 
    Image helpbkg = new ImageIcon (this.getClass().getResource("helppanel.png")).getImage();
    JButton back = new JButton("Back");
   
    HelpPanel(){
        setFocusable(true);
        add(back); 
       
        back.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent me){
            	CteGame.cl.show(CteGame.cards, "MenuPanel");
            }  
        });
    }
   
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(helpbkg, 0,0, null);
        repaint();
    }
}