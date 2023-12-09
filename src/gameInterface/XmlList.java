package gameInterface;

import java.io.File;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import mainGame.WordsList;

public class XmlList {
	static ArrayList<WordsList> l = new ArrayList<WordsList>();
	static int randomNum = (int) Math.floor(Math.random() * (7 - 0 + 1) + 0);
	static int randomNum2 = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);

	public XmlList() {

	}

	public static ArrayList<WordsList> getL() {
		try {
			File fXmlFile = new File("words.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
			doc.getDocumentElement().normalize();
			NodeList nList = doc.getElementsByTagName("question");
			for (int temp = 0; temp < nList.getLength(); temp++) {
				Node nNode = nList.item(temp);
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element eElement = (Element) nNode;
					l.add(new WordsList(eElement.getElementsByTagName("text").item(0).getTextContent(),
							eElement.getElementsByTagName("answer").item(0).getTextContent()));

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return l;
	}

	public void setL(ArrayList<WordsList> l) {
		this.l = l;
	}

	static public String getCodedAnswer() {

		randomNum = (int) Math.floor(Math.random() * (7 - 0 + 1) + 0);

		String s = l.get(randomNum).getAnswer();
		randomNum2 = (int) Math.floor(Math.random() * (s.length() - 2 - 0 + 1) + 0);
		System.out.println(randomNum + "  " + randomNum2 + "  " + s);
		char c = 0;
		String t = " ";
		c = s.charAt(randomNum2);
		int i = 0;
		int randomNum3 = 0;
		int randomNum4 = 0;
		if (s.length() < 12 && s.length() > 9) {
			do {
				randomNum3 = (int) Math.floor(Math.random() * (s.length() - 2 - 0 + 1) + 0);
			} while (randomNum3 == randomNum2);
			char c2 = s.charAt(randomNum3);
			for (i = 0; i < s.length(); i++) {
				if (i == randomNum2)
					t = t + c;
				else if (i == randomNum3)
					t = t + c2;
				else
					t = t + " __ ";
			}
		} else if (s.length() > 11) {
			do {
				randomNum3 = (int) Math.floor(Math.random() * (s.length() - 2 - 0 + 1) + 0);
				randomNum4 = (int) Math.floor(Math.random() * (s.length() - 2 - 0 + 1) + 0);
			} while ((randomNum3 == randomNum2) && (randomNum3 == randomNum4) && (randomNum4 == randomNum2));
			char c2 = s.charAt(randomNum3);
			char c3 = s.charAt(randomNum4);
			for (i = 0; i < s.length(); i++) {
				if (i == randomNum2)
					t = t + c;
				else if (i == randomNum3)
					t = t + c2;
				else if (i == randomNum4)
					t = t + c3;
				else
					t = t + " __ ";
			}
		} else if (s.length() < 10) {
			for (i = 0; i < s.length(); i++) {
				if (i == randomNum2)
					t = t + c;
				else
					t = t + " __ ";
			}
		}

		/*
		 * 
		 * if (randomNum2 == 1) { c = s.charAt(s.length() - 1); int i = 0; while (i <
		 * s.length() - 1) {
		 * 
		 * t = t + " __ "; i++;
		 * 
		 * } t = t + c; } if (randomNum2 ==0) { c = s.charAt(0) ; int i=0; t=t+c;
		 * while(i<s.length()-1) {
		 * 
		 * t= t+" __ "; i++;
		 * 
		 * } System.out.println(t);} if (randomNum2 ==2) { c = s.charAt(s.length()%2) ;
		 * int i=0; t=""; while(i<s.length()%2) {
		 * 
		 * t= t+" __ "; i++;
		 * 
		 * } t=t+c; while(i<s.length()-1) {
		 * 
		 * t= t+" __ "; i++;
		 * 
		 * } System.out.println(t); }
		 */

		return t;
	}

}
