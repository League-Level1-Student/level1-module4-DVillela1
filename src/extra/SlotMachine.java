package extra;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

import javax.swing.*;

public class SlotMachine implements ActionListener {
	
	JFrame frame;
	JPanel panel;
	JLabel one;
	JLabel two;
	JLabel three;
	JButton spin;
	
	public static void main(String[] args) {
		SlotMachine a = new SlotMachine();
		a.makeUI();
	}
	void makeUI() {
		frame = new JFrame();
		panel = new JPanel();
		spin = new JButton();

		frame.setVisible(true);
		frame.setPreferredSize(new Dimension(1920, 540));
		frame.add(panel);

		panel.add(spin);
		
		spin.addActionListener(this);
		spin.setText("Spin");
		
		frame.pack();
	}
	void spin() {
		Random r = new Random();
		int b = r.nextInt(3);
			try {	
		if (b == 0) {
			one = createLabelImage("orange.png");
			panel.add(one);
			frame.pack();
		}
		if (b == 1) {
			two = createLabelImage("cherry.png");
			panel.add(two);
			frame.pack();
		}
		if (b == 2) {
			three = createLabelImage("grape.png");
			panel.add(three);	
			frame.pack();
		}
		} catch (MalformedURLException e) {
				e.printStackTrace();
			}	
		
	}
	private JLabel createLabelImage(String fileName) throws MalformedURLException{
        URL imageURL = getClass().getResource(fileName);
	if (imageURL == null){
		System.err.println("Could not find image " + fileName);
		return new JLabel();
	}
	Icon icon = new ImageIcon(imageURL);
	JLabel imageLabel = new JLabel(icon);
	return imageLabel;
}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		
		if (buttonPressed == spin) {
			spin();
		}
	}
}
