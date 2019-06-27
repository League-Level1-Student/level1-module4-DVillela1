package extra;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class TypingTutor implements KeyListener {
	static char currentLetter;
	JLabel label;
	public void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setVisible(true);

		currentLetter = generateRandomLetter();
		
		
		label = new JLabel();
		label.setVisible(true);
		label.setText("" + currentLetter);
		label.setFont(label.getFont().deriveFont(28.0f));
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.add(label);
		
		frame.addKeyListener(this);
		frame.pack();
		
	}

	static char generateRandomLetter() {
		Random r = new Random();
		return (char) (r.nextInt(26) + 'a');
	}

	@Override
	public void keyPressed(KeyEvent e) {
		System.out.println(e.getKeyChar());
	}

	@Override
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() == currentLetter) {
			System.out.println("Correct");
		}
		else {
			System.out.println("Incorrect");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		currentLetter = generateRandomLetter();
		label.setText("" + currentLetter);
	}
}
