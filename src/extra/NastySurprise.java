package extra;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NastySurprise implements MouseListener {
	static JButton trick = new JButton();
	static JButton treat = new JButton();
	static JFrame frame = new JFrame();
	static JPanel panel = new JPanel();
	
	public static void main(String[] args) {
		frame.add(panel);
		panel.setVisible(true);
		panel.add(trick);
		panel.add(treat);
		trick.setVisible(true);
		treat.setVisible(true);
		frame.pack();
		trick.addMouseListener(this);
		treat.addMouseListener(this);
		frame.pack();
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		JButton pressed = (JButton) e.getSource();
		if (pressed == this.trick) {
			showPictureFromTheInternet("https://www.craigmcginty.com/.a/6a00d8341c7e8653ef0154336b38b4970c-800wi");
		}
		if (pressed == this.treat) {
			showPictureFromTheInternet("https://img.ecartelera.com/noticias/fotos/34100/34113/1.jpg");
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		JButton pressed = (JButton) e.getSource();
		if (pressed == this.trick) {
			showPictureFromTheInternet("https://www.craigmcginty.com/.a/6a00d8341c7e8653ef0154336b38b4970c-800wi");
		}
		if (pressed == this.treat) {
			showPictureFromTheInternet("https://img.ecartelera.com/noticias/fotos/34100/34113/1.jpg");
		}
		
	}
private void showPictureFromTheInternet(String imageUrl) {
	     try {
	          URL url = new URL(imageUrl);
	          Icon icon = new ImageIcon(url);
	          JLabel imageLabel = new JLabel(icon);
	          JFrame frame = new JFrame();
	          frame.add(imageLabel);
	          frame.setVisible(true);
	          frame.pack();
	     } catch (MalformedURLException e) {
	          e.printStackTrace();
	     }
	}
}
