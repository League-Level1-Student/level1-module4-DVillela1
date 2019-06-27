package extra;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.Random;

import javax.swing.*;

public class WhackAMole implements ActionListener {
	JFrame frame;
	int molesWacked;
	Date timeAtStart;
	public static void main(String[] args) {
		WhackAMole a = new WhackAMole();
		a.drawButtons();
	}

	void drawButtons() {
		timeAtStart = new Date();
		frame = new JFrame();
		JPanel panel = new JPanel();

		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(300, 500));
		frame.add(panel);
		
		Random a = new Random();
		int b = a.nextInt(26);
		
		for (int i = 0; i <= 26; i++) {
			JButton button = new JButton();
			if (i == b) {
				button.setText("Mole");
			}
			button.addActionListener(this);
			panel.add(button);
		}
		
		frame.pack();
	}

	void speak(String message) {
		try {
			Runtime.getRuntime().exec("say " + message).waitFor();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	void endGame(Date timeAtStart, int molesWacked) {
		Date timeAtEnd = new Date();
		JOptionPane.showMessageDialog(null, "Your whack rate is "
				+ ((timeAtEnd.getTime() - timeAtStart.getTime()) / 1000.00 / molesWacked) + " moles per second.");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed.getText().equals("Mole")) {
			molesWacked += 1;
			frame.dispose();
			drawButtons();
		}
		else {
			speak("You missed!");
			frame.dispose();
			drawButtons();
		}
		if (molesWacked == 10) {
			endGame(timeAtStart, molesWacked);
		}
		
	}
}
