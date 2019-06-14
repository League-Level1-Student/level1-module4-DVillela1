package extra;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Calculator implements ActionListener {
	public static void main(String[] args) {
		Calculator calc = new Calculator();
		calc.makeCalculator();
	}
	static int g;
	int a;
	int b;
	JLabel label;
	JButton add;
	JButton subtract;
	JButton multiply;
	JButton divide;
	
	public void makeCalculator() {
		JFrame frame = new JFrame();
		frame.setVisible(true);
		label = new JLabel();
		frame.add(label);
		
		add = new JButton();
		add.addActionListener(this);
		subtract = new JButton();
		subtract.addActionListener(this);
		multiply = new JButton();
		multiply.addActionListener(this);
		divide = new JButton();
		divide.addActionListener(this);
	}
	public static void multiply(int a, int b) {
		g = (a*b);
	}
	public static void add(int a, int b) {
		g = (a+b);
	}
	public static void subtract(int a, int b) {
		g = (a-b);
	}
	public static void divide(int a, int b) {
		g = (a/b);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (e.getSource() == add) {
			add(a, b);
		}
	}
}
