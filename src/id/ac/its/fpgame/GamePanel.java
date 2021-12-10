package id.ac.its.fpgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
class GamePanel extends JPanel{
    Image gamebkg = new ImageIcon(this.getClass().getResource("background.jpg")).getImage();
    Image basket  = new ImageIcon(this.getClass().getResource("basket2.png")).getImage();
    Image egg     = new ImageIcon(this.getClass().getResource("pisang.png")).getImage();
    Image anggur     = new ImageIcon(this.getClass().getResource("anggur.png")).getImage();
    Image gameOverbkg= new ImageIcon (this.getClass().getResource ("gameover.png")).getImage();
    Image tempbkg;
	JButton back = new JButton("Back");
    
   
    int x_basket,y_basket;
    int x_buah,y_buah,x_buah2,y_buah2;
    Random rand = new Random(); 
    static int fall = 1;
    static int point ;
    JLabel time;
    JLabel points;
    JLabel sisanyawa;
    int pointsCount;
    static int nyawa =3;
    boolean gameOver = false;
    
  
 

	GamePanel(){
       
        setLayout(null);
        setFocusable(true);
        tempbkg = gamebkg;
       
        x_basket = 400; y_basket = 550;
        x_buah = (int)rand.nextInt(1230);
        y_buah = 0;
        x_buah2 = (int)rand.nextInt(1230);
        y_buah2 = 0;
       
       
        points = new JLabel("Points: 0");
        points.setBounds(200,5,100,20);
        points.setForeground(Color.WHITE);
        points.setFont(new Font("Roboto",Font.BOLD,20));
        
        sisanyawa = new JLabel("nyawa: 3");
        sisanyawa.setBounds(400,5,100,20);
        sisanyawa.setForeground(Color.WHITE);
        sisanyawa.setFont(new Font("Roboto",Font.BOLD,20));
   
        add(points);
        add(sisanyawa);
       
        addKeyListener(new KeyAdapter(){
            public void keyPressed(KeyEvent ke){
               
                if(ke.getKeyCode() == ke.VK_LEFT & x_basket>10){
                    x_basket-=20;
                    repaint(); 
                }
                if(ke.getKeyCode() == ke.VK_RIGHT & x_basket<1230){
                    x_basket+=20;
                    repaint();
                }
            }
        });
    }
   
    void fallFruit(){
        if(y_buah >=650){
            y_buah = 0;
            x_buah = rand.nextInt(1230);
        }
        else
            y_buah+=fall;
    }


	void fallFruit2(){
        if(y_buah2 >=650){
            y_buah2 = 0;
            x_buah2 = rand.nextInt(1230);
        }
        else
            y_buah2+=fall;
    }
   
    void detectCollision(){
        Rectangle basketRect = new Rectangle(x_basket,y_basket,100,65);
        Rectangle pisangRect    = new Rectangle(x_buah,y_buah,50,67); 
        Rectangle anggurRect    = new Rectangle(x_buah2,y_buah2,50,67); 
        Rectangle miss     = new Rectangle(0,650,1230,1);
        
        if(pisangRect.intersects(basketRect) ){
            pointsCount+=5; 
            points.setText("Points:"+pointsCount);
            y_buah = 0; 
            x_buah = rand.nextInt(1230); 
        }else if(anggurRect.intersects(basketRect)) {
        	pointsCount+=10; 
            points.setText("Points:"+pointsCount); 
            y_buah2 = 0; 
            x_buah2 = rand.nextInt(1230); 
        }else if (anggurRect.intersects(miss) || pisangRect.intersects(miss) ) {
        	if(pisangRect.intersects(miss)) {
        		nyawa-=1;
                y_buah = 0; 
                x_buah = rand.nextInt(1230);
        	}else if(anggurRect.intersects(miss)) {
        		nyawa-=1;
        		 y_buah2 = 0;
        	     x_buah2 = rand.nextInt(1230);
        		
        	}
        	sisanyawa.setText("nyawa:"+nyawa);
        }
    }
    
    void checkGameOver(){
        if(nyawa == 0)
        {
        	tempbkg = gameOverbkg;
        	
        	back.setBounds(600,500,100,20);
            add(back);
    		
            JLabel yourScore = new JLabel("Your SCORE :" + pointsCount);
            yourScore.setBounds(500, 350, 500, 200);
            gameOver = true;
            yourScore.setForeground(Color.BLACK);
            yourScore.setFont(new Font("Roboto",Font.BOLD,40));
           
            add(yourScore);
            
            back.addMouseListener(new MouseAdapter(){
                public void mouseClicked(MouseEvent me){
                            CteGame.cl.show(CteGame.cards, "MenuPanel"); 
                }  
              });
            
        }
    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D)g;
        g2d.drawImage(tempbkg,0,0,null); 
       
        checkGameOver();
       
        if(gameOver == false){
            setFocusable(true);
            grabFocus();
           
            fallFruit();
            fallFruit2();
            detectCollision();
            g2d.drawImage(anggur, x_buah2, y_buah2,null); 
            g2d.drawImage(egg, x_buah, y_buah,null);
            g2d.drawImage(basket, x_basket, y_basket, null); 
        }
       
        repaint(); 
    }
}