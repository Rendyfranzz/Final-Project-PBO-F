package id.ac.its.fpgame;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class LevelPanel extends JPanel {
	
	Image menuBg = new ImageIcon (this.getClass().getResource("background.jpg")).getImage();
	
	JPanel container = new JPanel();
	JButton backButton = new JButton("Back");
	JButton easyLevel = new JButton("");
	JButton mediumLevel = new JButton("");
	JButton hardLevel = new JButton("");
	
	ImageIcon easybtn = new ImageIcon (this.getClass().getResource ("easy.png"));
    ImageIcon mediumbtn = new ImageIcon (this.getClass().getResource ("normal.png"));
    ImageIcon hardbtn = new ImageIcon (this.getClass().getResource ("hard.png"));
	
	public LevelPanel() {
		container.setLayout(new BoxLayout(container,BoxLayout.Y_AXIS));
		add(container);
		
		easyLevel.setIcon(easybtn);
	    mediumLevel.setIcon(mediumbtn);
	    hardLevel.setIcon(hardbtn);
	    
		container.add(backButton);
		container.add(easyLevel);
		container.add(mediumLevel);
		container.add(hardLevel);
		
		backButton.addMouseListener(new MouseClick());
		easyLevel.addMouseListener(new MouseClick());
		mediumLevel.addMouseListener(new MouseClick());
		hardLevel.addMouseListener(new MouseClick());
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D)g;
        setFocusable(true);
        
        g2d.drawImage(menuBg, 0,0, null);
        repaint();
	}
	
	class MouseClick extends MouseAdapter {
		public void mouseClicked(MouseEvent e) {
			if(e.getSource() == backButton)
				PbGame.cl.show(PbGame.cards, "MenuPanel");
			else {				
				if(e.getSource() == easyLevel)
					GamePanel.setFall(1);
				else if(e.getSource() == mediumLevel)
					GamePanel.setFall(2);
				else
					GamePanel.setFall(3);
				PbGame.cl.show(PbGame.cards, "GamePanel");
			}
		}
	}

}