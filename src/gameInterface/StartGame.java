package gameInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import mainGame.WordsList;

public class StartGame extends JFrame {

	public StartGame() {

		setBackground(Color.decode("#ffe4b2"));
		setTitle("Guessing Game");
		setSize(400, 500);
		setBackground(Color.decode("#ffe4b2"));
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel ppp = new JPanel();

		JLabel text = new JLabel("WELCOME TO THE GUESSING WORD !");
		text.setBounds(604, 155, 105, 14);
		text.setForeground(Color.BLACK);
		text.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setVerticalAlignment(SwingConstants.CENTER);

		ppp.setBackground(Color.decode("#ffe4b2"));
		ppp.setLayout(new GridLayout(1, 1));

		ppp.add(text);

		JPanel p = new JPanel();

		JLabel playerOne = new JLabel("Player1 Name");
		JLabel playerTwo = new JLabel("Player2 Name");
		JTextField playerOneAnswer = new JTextField(20);
		JTextField playerTwoAnswer = new JTextField(20);

		playerOne.setHorizontalAlignment(SwingConstants.CENTER);
		playerOne.setVerticalAlignment(SwingConstants.CENTER);
		playerTwo.setHorizontalAlignment(SwingConstants.CENTER);
		playerTwo.setVerticalAlignment(SwingConstants.CENTER);

		JButton ok = new JButton("ok");
		JButton a = new JButton("Annuler");
		JButton f = new JButton("fermer");
		f.setBackground(Color.decode("#C62368"));
		ok.setBackground(Color.decode("#C62368"));
		a.setBackground(Color.decode("#C62368"));
		f.setForeground(Color.WHITE);
		ok.setForeground(Color.WHITE);
		a.setForeground(Color.WHITE);
		p.setLayout(new GridLayout(3, 2));
		p.add(playerOne);
		p.add(playerTwo);
		p.add(playerOneAnswer);
		p.add(playerTwoAnswer);
		p.setBackground(Color.decode("#ffe4b2"));

		JPanel p3 = new JPanel();
		p3.setBackground(Color.decode("#ffe4b2"));

		JLabel l1 = new JLabel("");
		p3.setLayout(new GridLayout(1, 1));
		JLabel lblNewLabel = new JLabel("");

		JLabel l2 = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("a.png"));
		
		p3.add(l1);
		
		p3.add(lblNewLabel);
		p3.add(l2);
		JPanel p2 = new JPanel();
		p2.setBackground(Color.decode("#ffe4b2"));
		p2.add(ok);
		p2.add(a);
		p2.add(f);
		JPanel pbot = new JPanel();
		pbot.setLayout(new GridLayout(4, 1));
		JPanel ptop = new JPanel();
		pbot.add(ppp);
		pbot.add(p);
		
		pbot.add(p2);
		JPanel im = new JPanel();
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setIcon(new ImageIcon("bg.png"));

		lblNewLabel1.setPreferredSize(new Dimension(200,300));
		im.setLayout(new BorderLayout());
		im.add(p3,BorderLayout.NORTH);
		
		im.add(lblNewLabel1,BorderLayout.CENTER);
		im.setBackground(Color.decode("#ffe4b2"));

		im.setPreferredSize(new Dimension(200,300));
		ptop.setLayout(new BorderLayout());
		
		ptop.add(im, BorderLayout.SOUTH);
		ptop.setBackground(Color.decode("#ffe4b2"));
		this.getContentPane().add(ptop, BorderLayout.SOUTH);

		this.getContentPane().add(pbot, BorderLayout.NORTH);
		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String name1 = playerOneAnswer.getText();
				String name2 = playerTwoAnswer.getText();
				setVisible(false);
				new Fenetre(0, 0, name1, name2);

			}
		});

		setVisible(true);
	}

}
