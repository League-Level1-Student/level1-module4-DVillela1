package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PigLatinTranslator implements ActionListener {
	JTextField english;
	JTextField piglatin;
	JButton translate;
	JFrame frame;
	JPanel panel;

	public static void main(String[] args) {
		PigLatinTranslator a = new PigLatinTranslator();
		a.makeUI();
	}

	public void makeUI() {
		frame = new JFrame();
		frame.setVisible(true);
		panel = new JPanel();
		frame.add(panel);

		english = new JTextField(20);
		piglatin = new JTextField(20);
		piglatin.setEditable(false);
		piglatin.setSize(400, 400);
		translate = new JButton();
		translate.setText("Translate");
		translate.addActionListener(this);

		panel.add(english);
		panel.add(translate);		
		panel.add(piglatin);

		frame.pack();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		String b = translate(english.getText());
		if (buttonPressed == translate) {
			panel.remove(piglatin);
			piglatin = new JTextField((int) (b.length()/1.75));
			piglatin.setText(b);
			panel.add(piglatin);
			frame.pack();
		}
	}

	public String translate(String s) {
		String latin = "";
		int i = 0;
		while (i < s.length()) {

			while (i < s.length() && !isLetter(s.charAt(i))) {
				latin = latin + s.charAt(i);
				i++;
			}
			if (i >= s.length())
				break;

			int begin = i;
			while (i < s.length() && isLetter(s.charAt(i))) {
				i++;
			}
			int end = i;
			latin = latin + pigWord(s.substring(begin, end));
		}
		return latin;
	}

	private static boolean isLetter(char c) {
		return ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'));
	}

	private static String pigWord(String word) {
		int split = firstVowel(word);
		return word.substring(split) + "-" + word.substring(0, split) + "ay";
	}

	private static int firstVowel(String word) {
		word = word.toLowerCase();
		for (int i = 0; i < word.length(); i++)
			if (word.charAt(i) == 'a' || word.charAt(i) == 'e' || word.charAt(i) == 'i' || word.charAt(i) == 'o'
					|| word.charAt(i) == 'u')
				return i;
		return 0;
	}
}
