package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ChuckleClicker implements ActionListener {
	JButton joke;
	JButton punchline;

	public static void main(String[] args) {
		ChuckleClicker a = new ChuckleClicker();
		a.makeButtons();
	}

	public void makeButtons() {
		JFrame frame = new JFrame();
		JPanel panel = new JPanel();
		joke = new JButton();
		punchline = new JButton();
		frame.setVisible(true);
		frame.add(panel);
		joke.addActionListener(this);
		punchline.addActionListener(this);
		panel.add(joke);
		panel.add(punchline);
		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		JOptionPane.showMessageDialog(null, "hi");
		if (e.getSource() == joke) {
			JOptionPane.showMessageDialog(null, "رئيس أمريكا");
		}
		if (e.getSource() == punchline) {
			JOptionPane.showMessageDialog(null, "لكمة خط لكمة");
		}
	}
}
