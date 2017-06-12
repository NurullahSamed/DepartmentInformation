package GUI;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.Connection;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Frame extends JFrame {
	public Frame(Connection connection){
    	//Frame kapat�ld���nda ne olaca�� belirlendi.
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	//Frame'in 2 sat�r 1 s�t�n �eklinde b�l�nece�ini belirttik.
    	this.setLayout(new FlowLayout());
    	
    	
    	SorguPanel sorguPanel = new SorguPanel();
    	CiktiPanel ciktiPanel = new CiktiPanel();
    	

    	//Bile�enler olu�turulup �er�eveye yerle�tirildi
    	this.getContentPane().add(sorguPanel);
    	this.getContentPane().add(ciktiPanel);
    	
    	//�er�eve boyutland�r�ld�.
    	this.pack();
    	
    	this.setSize(600, 500);
    	this.setResizable(false);
    	//G�r�n�r yap�ld�.
    	this.setVisible(true);
	}
}
