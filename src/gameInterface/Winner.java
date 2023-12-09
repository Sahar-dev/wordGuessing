package gameInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Winner extends JFrame {

	public Winner(String winner) {

		setBackground(Color.decode("#ffe4b2"));
		setTitle("Guessing Game");
		setSize(500, 180);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel ppp = new JPanel();

		JLabel text = new JLabel("CONGRATULATIONS " + winner + "  !!!!!!");

		text.setForeground(Color.BLACK);
		text.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setVerticalAlignment(SwingConstants.CENTER);

		ppp.setBackground(Color.decode("#ffe4b2"));
		ppp.setLayout(new GridLayout(4, 1));

		JLabel sub1 = new JLabel("You won this game with 10/10 score!");
		JLabel sub2 = new JLabel("THANK YOU BOTH FOR JOINING");
		sub1.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		sub2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		sub1.setHorizontalAlignment(SwingConstants.CENTER);
		sub1.setVerticalAlignment(SwingConstants.CENTER);
		sub2.setHorizontalAlignment(SwingConstants.CENTER);
		sub2.setVerticalAlignment(SwingConstants.CENTER);

		JButton f = new JButton("fermer");
		f.setBackground(Color.decode("#C62368"));
		f.setForeground(Color.WHITE);
		f.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		ppp.add(text);
		ppp.add(sub1);
		ppp.add(sub2);
		ppp.add(f);

		JPanel pbot = new JPanel();
		pbot.setLayout(new GridLayout(3, 1));

		pbot.add(ppp);

		this.getContentPane().add(pbot, BorderLayout.NORTH);
		f.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				setVisible(false);

			}
		});

		setVisible(true);
	}

}
