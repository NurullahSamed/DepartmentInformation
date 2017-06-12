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
    	
    	//Frame'in layout tipi belirtildi.
    	this.setLayout(new FlowLayout());
    	
    	//Frame'in içerisinde yer alacak iki ana panel oluþturuldu.
    	SorguPanel sorguPanel = new SorguPanel();
    	CiktiPanel ciktiPanel = new CiktiPanel();
    	

    	//Bileþenler oluþturulup çerçeveye yerleþtirildi
    	this.getContentPane().add(sorguPanel);
    	this.getContentPane().add(ciktiPanel);
    	
    	//Çerçeve boyutlandýrýldý.
    	this.pack();
    	
    	//Frame boyutu belirlendi ve boyutu deðiþtirilemez yapýldý.
    	this.setSize(600, 500);
    	this.setResizable(false);
    	
    	//Görünür yapýldý.
    	this.setVisible(true);
	}
}
