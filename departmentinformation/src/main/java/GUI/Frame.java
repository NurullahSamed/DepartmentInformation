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
    	//Frame kapatýldýðýnda ne olacaðý belirlendi.
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	
    	//Frame'in 2 satýr 1 sütün þeklinde bölüneceðini belirttik.
    	this.setLayout(new FlowLayout());
    	
    	
    	SorguPanel sorguPanel = new SorguPanel();
    	CiktiPanel ciktiPanel = new CiktiPanel();
    	

    	//Bileþenler oluþturulup çerçeveye yerleþtirildi
    	this.getContentPane().add(sorguPanel);
    	this.getContentPane().add(ciktiPanel);
    	
    	//Çerçeve boyutlandýrýldý.
    	this.pack();
    	
    	this.setSize(600, 500);
    	this.setResizable(false);
    	//Görünür yapýldý.
    	this.setVisible(true);
	}
}
