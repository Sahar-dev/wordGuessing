package gameInterface;

import java.awt.BorderLayout;
import java.awt.Choice;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import mainGame.WordsList;

public class Fenetre extends JFrame {
	static int scoreOne;
	static int scoreTwo;

	public Fenetre(int scoreOne, int scoreTwo, String name1, String name2) {

		ArrayList<WordsList> l = XmlList.getL();

		String t = XmlList.getCodedAnswer();

		String ans = l.get(XmlList.randomNum).getAnswer();
		String q = l.get(XmlList.randomNum).getQuestion();

		setBackground(Color.decode("#ffe4b2"));
		setTitle("Guessing Game");
		setSize(600, 600);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel ppp = new JPanel();
		JLabel lblNewLabel1 = new JLabel("");
		lblNewLabel1.setIcon(new ImageIcon("bg1.png"));

		JLabel text = new JLabel("WELCOME TO THE GUESSING WORD !");
		text.setBounds(604, 155, 105, 14);
		text.setForeground(Color.BLACK);
		text.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		text.setHorizontalAlignment(SwingConstants.CENTER);
		text.setVerticalAlignment(SwingConstants.CENTER);

		JLabel question = new JLabel("    The Question is :  ");
		JLabel qq = new JLabel(q);
		qq.setBounds(604, 155, 105, 14);
		qq.setForeground(Color.BLACK);
		qq.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		qq.setHorizontalAlignment(SwingConstants.CENTER);
		qq.setVerticalAlignment(SwingConstants.CENTER);
		JLabel answer = new JLabel("    The word hints  ");

		JLabel an = new JLabel(t);
		an.setBounds(604, 155, 105, 14);
		an.setForeground(Color.BLACK);
		an.setFont(new Font("Times New Roman", Font.PLAIN, 18));
		an.setHorizontalAlignment(SwingConstants.CENTER);
		an.setVerticalAlignment(SwingConstants.CENTER);
		ppp.setBackground(Color.decode("#ffe4b2"));
		ppp.setLayout(new GridLayout(6, 1));
		JPanel im = new JPanel();
		im.setLayout(new GridLayout(1, 1));
		im.add(lblNewLabel1);

		ppp.add(text);
		ppp.add(question);
		ppp.add(qq);
		ppp.add(answer);
		ppp.add(an);
		JPanel p = new JPanel();

		JLabel playerOne = new JLabel("Player1     " + name1);
		JLabel playerTwo = new JLabel("Player2     " + name2);

		JLabel ss = new JLabel("" + getScoreOne());
		JLabel ss2 = new JLabel("" + getScoreTwo());

		JTextField aa = new JTextField(10);
		JTextField bb = new JTextField(10);
		playerOne.setHorizontalAlignment(SwingConstants.CENTER);
		playerOne.setVerticalAlignment(SwingConstants.CENTER);
		playerTwo.setHorizontalAlignment(SwingConstants.CENTER);
		playerTwo.setVerticalAlignment(SwingConstants.CENTER);
		ss.setHorizontalAlignment(SwingConstants.CENTER);
		ss.setVerticalAlignment(SwingConstants.CENTER);
		ss2.setHorizontalAlignment(SwingConstants.CENTER);
		ss2.setVerticalAlignment(SwingConstants.CENTER);

		JPanel playerOneAnswer = new JPanel();
		playerOneAnswer.setBackground(Color.decode("#ffe4b2"));
		ArrayList<JTextField> textFields = new ArrayList<JTextField>();
		for (int i = 0; i < ans.length(); i++) {
			JTextField plzwork = new JTextField(1);
			plzwork.setDocument(new LengthRestrictedDocument(1));

			textFields.add(plzwork);
			playerOneAnswer.add(textFields.get(i));
		}
		for (int i = 0; i < textFields.size() - 1; i++) {
			JTextField f = textFields.get(i + 1);
			JTextField f2 = textFields.get(i);
			f2.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					String value = f2.getText();
					if (value.length() == 1) {
						f.requestFocus();
					}
				}
			});
		}

		JPanel playerTwoAnswer = new JPanel();
		playerTwoAnswer.setBackground(Color.decode("#ffe4b2"));
		ArrayList<JTextField> textFields2 = new ArrayList<JTextField>();
		for (int i = 0; i < ans.length(); i++) {
			JTextField plzwork = new JTextField(1);

			plzwork.setDocument(new LengthRestrictedDocument(1));
			textFields2.add(plzwork);
			playerTwoAnswer.add(textFields2.get(i));
		}
		for (int i = 0; i < textFields2.size() - 1; i++) {
			JTextField f = textFields2.get(i + 1);
			JTextField f2 = textFields2.get(i);
			f2.addKeyListener(new KeyAdapter() {
				public void keyPressed(KeyEvent e) {
					String value = f2.getText();
					if (value.length() == 1) {
						f.requestFocus();
					}
				}
			});
		}
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
		p.add(ss);
		p.add(ss2);
		p.add(playerOneAnswer);
		p.add(playerTwoAnswer);

		JLabel lblNewLabel2 = new JLabel("");
		lblNewLabel2.setIcon(new ImageIcon("two.png"));
		JLabel lblNewLabel3 = new JLabel("");
		lblNewLabel3.setIcon(new ImageIcon("one.png"));
		JPanel p2 = new JPanel();
		p2.add(lblNewLabel3);
		p2.add(ok);
		p2.add(a);
		p2.add(f);
		p2.add(lblNewLabel2);
		JPanel pbot = new JPanel();
		pbot.setLayout(new GridLayout(3, 1));
		JPanel tr = new JPanel();
		pbot.add(ppp);
		pbot.add(p);
		pbot.add(p2);
		p2.setBackground(Color.decode("#ffe4b2"));
		p.setBackground(Color.decode("#ffe4b2"));

		this.getContentPane().add(pbot, BorderLayout.SOUTH);

		this.getContentPane().add(im, BorderLayout.NORTH);

		ok.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String one = "";
				for (int i = 0; i < ans.length(); i++) {
					one = one + textFields.get(i).getText();
				}
				String two = "";
				for (int i = 0; i < ans.length(); i++) {
					two = two + textFields2.get(i).getText();
				}

				if (one.equals(ans)) {
					setScoreOne();
				}
				if (two.equals(ans)) {
					setScoreTwo();
				}

				if ((getScoreOne() < 2) && (getScoreTwo() < 2)) {
					setVisible(false);
					new Fenetre(getScoreOne(), getScoreTwo(), name1, name2);

				} else if ((getScoreOne()) == 2) {
					setVisible(false);
					new Winner(name1);
				} else {
					setVisible(false);
					new Winner(name1);
				}

			}
		});

		setVisible(true);
	}

	public static int getScoreOne() {
		return scoreOne;
	}

	public static void setScoreOne() {
		Fenetre.scoreOne++;
	}

	public static int getScoreTwo() {
		return scoreTwo;
	}

	public static void setScoreTwo() {
		Fenetre.scoreTwo++;
	}
}
